package pe.despachalo.app.modules.company.ports;

import pe.despachalo.app.modules.company.Company;
import reactor.core.publisher.Flux;

public interface GetAllCompaniesPort {
  Flux<Company> getAll();
}
