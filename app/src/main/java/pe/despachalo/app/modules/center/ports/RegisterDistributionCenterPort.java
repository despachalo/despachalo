package pe.despachalo.app.modules.center.ports;

import pe.despachalo.app.modules.center.domain.DistributionCenter;
import pe.despachalo.app.modules.center.domain.DistributionCenterToRegister;
import reactor.core.publisher.Mono;

public interface RegisterDistributionCenterPort {
  Mono<DistributionCenter> register(DistributionCenterToRegister toRegister);
}
