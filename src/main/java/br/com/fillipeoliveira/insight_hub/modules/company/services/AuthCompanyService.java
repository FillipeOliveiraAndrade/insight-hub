package br.com.fillipeoliveira.insight_hub.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fillipeoliveira.insight_hub.modules.company.dtos.AuthCompanyDTO;
import br.com.fillipeoliveira.insight_hub.modules.company.dtos.AuthCompanyResponseDTO;
import br.com.fillipeoliveira.insight_hub.modules.company.exceptions.CompanyNotFoundException;
import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;
import br.com.fillipeoliveira.insight_hub.modules.company.models.repositories.CompanyRepository;

@Service
public class AuthCompanyService {
  
  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private TokenServiceCompany tokenService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public AuthCompanyResponseDTO auth(AuthCompanyDTO authCompanyDTO) {
    Company company = this.companyRepository.findByCnpj(authCompanyDTO.cnpj())
        .orElseThrow(() -> new CompanyNotFoundException());

    boolean passwordMatches = this.passwordEncoder.matches(authCompanyDTO.password(), company.getPassword());
    if (!passwordMatches) {
      throw new CompanyNotFoundException();
    }

    String token = tokenService.generateToken(company);

    AuthCompanyResponseDTO tokenDTO = AuthCompanyResponseDTO
        .builder()
        .token(token)
        .build();

    return tokenDTO;
  }
}
