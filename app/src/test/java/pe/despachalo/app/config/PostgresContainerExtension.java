package pe.despachalo.app.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.PostgreSQLContainer;

@Slf4j
public class PostgresContainerExtension implements BeforeAllCallback, AfterAllCallback {
  private PostgreSQLContainer<?> container;

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    container = new PostgreSQLContainer<>("postgres:15.2-alpine")
        .withDatabaseName("despachalo_test");

    log.info("Start container using image: {}", container.getDockerImageName());
    container.start();

    log.info("Setup r2dbc properties using container");
    System.setProperty("spring.r2dbc.url", container.getJdbcUrl().replace("jdbc", "r2dbc"));
    System.setProperty("spring.r2dbc.username", container.getUsername());
    System.setProperty("spring.r2dbc.password", container.getPassword());

    log.info("Setup liquibase properties using container");
    System.setProperty("spring.liquibase.url", container.getJdbcUrl());
    System.setProperty("spring.liquibase.user", container.getUsername());
    System.setProperty("spring.liquibase.password", container.getPassword());

    log.info("Properties setup ready to use");
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    // nothing to do
  }
}
