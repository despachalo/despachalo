package pe.despachalo.app.modules.center;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.despachalo.app.modules.center.domain.DistributionCenter;
import pe.despachalo.app.modules.center.domain.DistributionCenterToRegister;
import pe.despachalo.app.modules.center.ports.RegisterDistributionCenterPort;
import pe.despachalo.app.modules.common.hexagonal.UseCase;
import reactor.core.publisher.Mono;

@Slf4j
@UseCase
@RequiredArgsConstructor
public class RegisterDistributionCenterUseCase implements RegisterDistributionCenterService {
  private final RegisterDistributionCenterPort registerDistributionCenterPort;

  @Override
  public Mono<DistributionCenter> execute(DistributionCenterToRegister toRegister) {
    return registerDistributionCenterPort.register(toRegister);
  }
}
