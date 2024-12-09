package br.com.fillipeoliveira.insight_hub.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fillipeoliveira.insight_hub.modules.company.exceptions.CompanyAlreadyExistsException;
import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;
import br.com.fillipeoliveira.insight_hub.modules.company.models.repositories.CompanyRepository;

@Service
public class CompanyService {
  
  @Autowired
  private CompanyRepository companyRepository;

  public Company save(Company company) {
    this.companyRepository.findByCnpj(company.getCnpj())
        .ifPresent(existingCompany -> {
            throw new CompanyAlreadyExistsException();
        });

    return this.companyRepository.save(company);
  }
}
