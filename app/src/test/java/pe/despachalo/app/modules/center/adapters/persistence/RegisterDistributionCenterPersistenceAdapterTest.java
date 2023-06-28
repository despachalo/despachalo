package pe.despachalo.app.modules.center.adapters.persistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;
import pe.despachalo.app.config.PostgresContainerExtension;
import pe.despachalo.app.modules.center.domain.DistributionCenterToRegister;
import pe.despachalo.app.modules.common.domain.Location;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataR2dbcTest
@Testcontainers
@ActiveProfiles("test")
@ExtendWith(PostgresContainerExtension.class)
@ComponentScan(basePackageClasses = {
    RegisterDistributionCenterPersistenceAdapter.class,
    DistributionCenterMapper.class})
class RegisterDistributionCenterPersistenceAdapterTest {

  @Autowired
  private RegisterDistributionCenterPersistenceAdapter registerDistributionCenterPersistenceAdapter;

  @Autowired
  private DistributionCenterReactiveRepository distributionCenterReactiveRepository;

  @Test
  @DirtiesContext
  void registerDistributionCenterInDB() {
    var centerName = "Test name";
    var centerAddress = "Av Test";
    var centerLocation = new Location(123.0, 123.0);
    var distributionCenterToRegister = new DistributionCenterToRegister(centerName, centerAddress, centerLocation);

    var res = registerDistributionCenterPersistenceAdapter.register(distributionCenterToRegister);

    StepVerifier.create(res)
        .as("Check distribution center registered in DB")
        .assertNext(distributionCenter -> {
          assertEquals(1L, distributionCenter.id());
          assertEquals(centerName, distributionCenter.name());
          assertEquals(centerAddress, distributionCenter.address());
          assertEquals(centerLocation.longitude(), distributionCenter.location().longitude());
          assertEquals(centerLocation.latitude(), distributionCenter.location().latitude());
        })
        .verifyComplete();

    var rowInDB = distributionCenterReactiveRepository.findById(1L);
    StepVerifier.create(rowInDB)
        .as("Find company registered in BD using repositories")
        .assertNext(distributionCenter -> {
          assertEquals(1L, distributionCenter.getId());
          assertEquals(centerName, distributionCenter.getName());
          assertEquals(centerAddress, distributionCenter.getAddress());
          assertEquals(centerLocation.longitude(), distributionCenter.getLongitude());
          assertEquals(centerLocation.latitude(), distributionCenter.getLatitude());
        })
        .verifyComplete();
  }
}
