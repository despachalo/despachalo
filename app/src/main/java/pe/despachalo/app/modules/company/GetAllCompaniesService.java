package pe.despachalo.app.modules.company;

import reactor.core.publisher.Flux;

public interface GetAllCompaniesService {
  Flux<Company> execute();
}
