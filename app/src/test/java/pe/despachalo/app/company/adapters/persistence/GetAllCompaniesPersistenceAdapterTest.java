package pe.despachalo.app.company.adapters.persistence;

import io.r2dbc.spi.ConnectionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;
import pe.despachalo.app.company.Company;
import pe.despachalo.app.config.PostgresContainerExtension;
import reactor.test.StepVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pe.despachalo.app.utils.R2dbcScripts.executeSqlScriptBlocking;

@DataR2dbcTest
@Testcontainers
@ActiveProfiles("test")
@ExtendWith(PostgresContainerExtension.class)
@ComponentScan(basePackageClasses = {GetAllCompaniesPersistenceAdapter.class, CompanyMapper.class})
class GetAllCompaniesPersistenceAdapterTest {

  @Autowired
  private GetAllCompaniesPersistenceAdapter getAllCompaniesPersistenceAdapter;

  @Autowired
  private CompanyReactiveRepository companyReactiveRepository;

  @Autowired
  private ConnectionFactory connectionFactory;

  @Value("classpath:sql/insert-2-companies.sql")
  private Resource insert2CompaniesSql;

  @BeforeEach
  void runSQL() {
    executeSqlScriptBlocking(connectionFactory, insert2CompaniesSql);
  }

  @Test
  void getAllCompaniesFromDB() {
    var rucs = List.of("12345678901", "12345678902");
    var companies = getAllCompaniesPersistenceAdapter.getAll().collectList();

    StepVerifier.create(companies)
        .as("Check for two companies in DB")
        .assertNext(c -> {
          assertThat(c).hasSize(2);
          c.stream()
              .map(Company::ruc)
              .distinct()
              .forEach(r -> assertThat(rucs).contains(r));
        })
        .verifyComplete();
  }
}
