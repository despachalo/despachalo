package pe.despachalo.app.company;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.despachalo.app.company.ports.RegisterCompanyPort;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterNewCompanyUseCase implements RegisterNewCompanyService {
  private final RegisterCompanyPort registerCompanyPort;

  @Override
  public Mono<Company> execute(CompanyToRegister companyToRegister) {
    return registerCompanyPort.register(companyToRegister);
  }
}
