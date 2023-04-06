package pe.despachalo.app.company.adapters.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.despachalo.app.company.Company;
import pe.despachalo.app.company.ports.GetAllCompaniesPort;
import reactor.core.publisher.Flux;

@Component
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
