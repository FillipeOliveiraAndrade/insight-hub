package br.com.fillipeoliveira.insight_hub.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fillipeoliveira.insight_hub.modules.company.exceptions.CompanyCnpjAlreadyExistsException;
import br.com.fillipeoliveira.insight_hub.modules.company.exceptions.CompanyEmailAlreadyExistsException;
import br.com.fillipeoliveira.insight_hub.modules.company.exceptions.CompanyNameAlreadyExistsException;
import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;
import br.com.fillipeoliveira.insight_hub.modules.company.models.repositories.CompanyRepository;

@Service
public class CompanyService {

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public Company save(Company company) {
    validateCompany(company);

    var password = passwordEncoder.encode(company.getPassword());
    company.setPassword(password);

    return this.companyRepository.save(company);
  }

  private void validateCompany(Company company) {
    this.companyRepository.findByUsername(company.getUsername())
        .ifPresent(existingCompany -> {
          throw new CompanyNameAlreadyExistsException();
        });

    this.companyRepository.findByEmail(company.getEmail())
        .ifPresent(existingCompany -> {
          throw new CompanyEmailAlreadyExistsException();
        });

    this.companyRepository.findByCnpj(company.getCnpj())
        .ifPresent(existingCompany -> {
          throw new CompanyCnpjAlreadyExistsException();
        });
  }
}
