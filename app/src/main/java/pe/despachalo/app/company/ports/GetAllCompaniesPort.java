package pe.despachalo.app.company.ports;

import pe.despachalo.app.company.Company;
import reactor.core.publisher.Flux;

public interface GetAllCompaniesPort {
  Flux<Company> getAll();
}
