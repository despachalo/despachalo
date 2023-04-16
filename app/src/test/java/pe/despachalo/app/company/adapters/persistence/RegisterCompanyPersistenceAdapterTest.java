package pe.despachalo.app.company.adapters.persistence;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;
import pe.despachalo.app.company.CompanyToRegister;
import pe.despachalo.app.config.PostgresContainerExtension;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataR2dbcTest
@Testcontainers
@ActiveProfiles("test")
@ExtendWith(PostgresContainerExtension.class)
@ComponentScan(basePackageClasses = {RegisterCompanyPersistenceAdapter.class, CompanyMapper.class})
class RegisterCompanyPersistenceAdapterTest {

  @Autowired
  private RegisterCompanyPersistenceAdapter registerCompanyPersistenceAdapter;

  @Autowired
  private CompanyReactiveRepository companyReactiveRepository;

  @Test
  @DirtiesContext
  void registerACompanyInDB() {
    var companyToRegister = new CompanyToRegister("A&J Corp", "12332112332");

    var company = registerCompanyPersistenceAdapter.register(companyToRegister);

    StepVerifier.create(company)
        .as("Check company registered in DB")
        .assertNext(c -> {
          assertEquals(1L, c.id());
          assertEquals("A&J Corp", c.businessName());
          assertEquals("12332112332", c.ruc());
        })
        .verifyComplete();

    var rowInDB = companyReactiveRepository.findById(1L);
    StepVerifier.create(rowInDB)
        .as("Find company registered in BD using repositories")
        .assertNext(c -> {
          assertEquals(1L, c.getId());
          assertEquals("A&J Corp", c.getBusinessName());
          assertEquals("12332112332", c.getRuc());
        })
        .verifyComplete();
  }
}
