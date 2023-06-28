package pe.despachalo.app.modules.company.adapters.persistence;

import lombok.RequiredArgsConstructor;
import pe.despachalo.app.modules.common.hexagonal.PersistenceAdapter;
import pe.despachalo.app.modules.company.Company;
import pe.despachalo.app.modules.company.ports.GetAllCompaniesPort;
import reactor.core.publisher.Flux;

@PersistenceAdapter
@RequiredArgsConstructor
public class GetAllCompaniesPersistenceAdapter implements GetAllCompaniesPort {
  private final CompanyReactiveRepository companyReactiveRepository;
  private final CompanyMapper companyMapper;

  @Override
  public Flux<Company> getAll() {
    return companyReactiveRepository.findAll()
        .map(companyMapper::toCustomer);
  }
}
