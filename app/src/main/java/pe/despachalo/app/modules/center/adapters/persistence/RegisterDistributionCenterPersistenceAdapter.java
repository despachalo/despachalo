package pe.despachalo.app.modules.center.adapters.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.despachalo.app.modules.center.domain.DistributionCenter;
import pe.despachalo.app.modules.center.domain.DistributionCenterToRegister;
import pe.despachalo.app.modules.center.ports.RegisterDistributionCenterPort;
import pe.despachalo.app.modules.common.hexagonal.PersistenceAdapter;
import reactor.core.publisher.Mono;

@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class RegisterDistributionCenterPersistenceAdapter implements RegisterDistributionCenterPort {
  private DistributionCenterReactiveRepository distributionCenterReactiveRepository;
  private DistributionCenterMapper distributionCenterMapper;

  @Override
  public Mono<DistributionCenter> register(DistributionCenterToRegister toRegister) {
    var toSave = distributionCenterMapper.toDistributionCenterModel(toRegister);

    return distributionCenterReactiveRepository.save(toSave)
        .map(distributionCenterMapper::toDistributionCenter);
  }
}
