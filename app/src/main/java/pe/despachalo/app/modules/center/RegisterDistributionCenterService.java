package pe.despachalo.app.modules.center;

import pe.despachalo.app.modules.center.domain.DistributionCenter;
import pe.despachalo.app.modules.center.domain.DistributionCenterToRegister;
import reactor.core.publisher.Mono;

public interface RegisterDistributionCenterService {
  Mono<DistributionCenter> execute(DistributionCenterToRegister toRegister);
}
