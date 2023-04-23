package pe.despachalo.app.modules.company;

import reactor.core.publisher.Mono;

public interface RegisterNewCompanyService {
  Mono<Company> execute(CompanyToRegister companyToRegister);
}
