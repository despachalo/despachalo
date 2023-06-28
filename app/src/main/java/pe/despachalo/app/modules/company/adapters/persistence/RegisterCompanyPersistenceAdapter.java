package pe.despachalo.app.modules.company.adapters.persistence;

import lombok.RequiredArgsConstructor;
import pe.despachalo.app.modules.common.hexagonal.PersistenceAdapter;
import pe.despachalo.app.modules.company.Company;
import pe.despachalo.app.modules.company.CompanyToRegister;
import pe.despachalo.app.modules.company.ports.RegisterCompanyPort;
import reactor.core.publisher.Mono;

@PersistenceAdapter
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
