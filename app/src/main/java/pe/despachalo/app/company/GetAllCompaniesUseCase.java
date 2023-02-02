package pe.despachalo.app.company;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.despachalo.app.company.ports.GetAllCompaniesPort;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetAllCompaniesUseCase implements GetAllCompaniesService {
  private final GetAllCompaniesPort getAllCompaniesPort;

  @Override
  public Flux<Company> execute() {
    return getAllCompaniesPort.getAll();
  }
}
