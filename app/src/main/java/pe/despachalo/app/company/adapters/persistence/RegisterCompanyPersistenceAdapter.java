package pe.despachalo.app.company.adapters.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.despachalo.app.company.Company;
import pe.despachalo.app.company.CompanyToRegister;
import pe.despachalo.app.company.ports.RegisterCompanyPort;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RegisterCompanyPersistenceAdapter implements RegisterCompanyPort {
  private final CompanyReactiveRepository companyReactiveRepository;
  private final CompanyMapper companyMapper;

  @Override
  public Mono<Company> register(CompanyToRegister companyToRegister) {
    var row = companyMapper.toCompanyModel(companyToRegister);
    return companyReactiveRepository.save(row)
        .map(companyMapper::toCustomer);
  }
}
