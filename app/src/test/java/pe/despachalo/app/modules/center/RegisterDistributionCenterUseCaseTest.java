package pe.despachalo.app.modules.center;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.despachalo.app.modules.center.domain.DistributionCenter;
import pe.despachalo.app.modules.center.domain.DistributionCenterToRegister;
import pe.despachalo.app.modules.center.ports.RegisterDistributionCenterPort;
import pe.despachalo.app.modules.common.domain.Location;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterDistributionCenterUseCaseTest {

  @Mock
  private RegisterDistributionCenterPort registerDistributionCenterPort;

  private RegisterDistributionCenterService service() {
    return new RegisterDistributionCenterUseCase(registerDistributionCenterPort);
  }

  @Test
  void givenADistributionCenterToRegister_whenExecuteRegistry_thenIsRegisteredUsingPortAvailable() {
    var centerId = 1L;
    var centerName = "Test name";
    var centerAddress = "Av Test";
    var centerLocation = new Location(123.0, 123.0);
    var distributionCenterToRegister = new DistributionCenterToRegister(centerName, centerAddress, centerLocation);
    var distributionCenterRegistered = new DistributionCenter(centerId, centerName, centerAddress, centerLocation);

    when(registerDistributionCenterPort.register(any())).thenReturn(Mono.just(distributionCenterRegistered));

    var service = service();
    var res = service.execute(distributionCenterToRegister);

    StepVerifier.create(res)
        .as("Check if the distribution center registered is returned")
        .assertNext(center -> {
          assertEquals(centerId, center.id());
          assertEquals(centerName, center.name());
          assertEquals(centerAddress, center.address());
          assertEquals(centerLocation.latitude(), center.location().latitude());
          assertEquals(centerLocation.longitude(), center.location().longitude());
        })
        .expectComplete()
        .verify();

  }
}
