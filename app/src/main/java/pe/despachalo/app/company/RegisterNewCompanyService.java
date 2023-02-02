package pe.despachalo.app.company;

import reactor.core.publisher.Mono;

public interface RegisterNewCompanyService {
  Mono<Company> execute(CompanyToRegister companyToRegister);
}
