package pe.despachalo.app.modules.company.ports;

import pe.despachalo.app.modules.company.Company;
import pe.despachalo.app.modules.company.CompanyToRegister;
import reactor.core.publisher.Mono;

public interface RegisterCompanyPort {
  Mono<Company> register(CompanyToRegister companyToRegister);
}
