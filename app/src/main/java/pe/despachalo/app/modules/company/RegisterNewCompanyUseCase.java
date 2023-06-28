package pe.despachalo.app.modules.company;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.despachalo.app.modules.common.hexagonal.UseCase;
import pe.despachalo.app.modules.company.ports.RegisterCompanyPort;
import reactor.core.publisher.Mono;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class RegisterNewCompanyUseCase implements RegisterNewCompanyService {
  private final RegisterCompanyPort registerCompanyPort;

  @Override
  public Mono<Company> execute(CompanyToRegister companyToRegister) {
    return registerCompanyPort.register(companyToRegister);
  }
}
