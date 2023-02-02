package pe.despachalo.app.company.ports;

import pe.despachalo.app.company.Company;
import pe.despachalo.app.company.CompanyToRegister;
import reactor.core.publisher.Mono;

public interface RegisterCompanyPort {
  Mono<Company> register(CompanyToRegister companyToRegister);
}
