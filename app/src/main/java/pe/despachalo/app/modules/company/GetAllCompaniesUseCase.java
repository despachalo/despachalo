package pe.despachalo.app.modules.company;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.despachalo.app.modules.common.hexagonal.UseCase;
import pe.despachalo.app.modules.company.ports.GetAllCompaniesPort;
import reactor.core.publisher.Flux;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class GetAllCompaniesUseCase implements GetAllCompaniesService {
  private final GetAllCompaniesPort getAllCompaniesPort;

  @Override
  public Flux<Company> execute() {
    return getAllCompaniesPort.getAll();
  }
}
