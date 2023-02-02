package pe.despachalo.app.company;

import reactor.core.publisher.Flux;

public interface GetAllCompaniesService {
  Flux<Company> execute();
}
