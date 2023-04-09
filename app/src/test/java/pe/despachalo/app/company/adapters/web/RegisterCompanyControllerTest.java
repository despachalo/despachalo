package pe.despachalo.app.company.adapters.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import pe.despachalo.app.company.Company;
import pe.despachalo.app.company.RegisterNewCompanyService;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest(RegisterCompanyController.class)
class RegisterCompanyControllerTest {

  @Autowired
  private WebTestClient webClient;

  @MockBean
  private RegisterNewCompanyService registerNewCompanyService;

  @Value("classpath:pe/despachalo/app/company/adapters/web/register-company-request.json")
  private Resource registerCompanyJsonBody;

  @Test
  void shouldCallServiceToRegisterCompanyAndReturnTheCreatedOne() throws IOException {
    var company = new Company(1L, "Company 1", "12345678901");
    when(registerNewCompanyService.execute(any())).thenReturn(Mono.just(company));

    var jsonBody = registerCompanyJsonBody.getContentAsString(StandardCharsets.UTF_8);

    webClient.post()
        .uri("/companies")
        .bodyValue(jsonBody)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .exchange()
        .expectStatus()
        .isCreated()
        .expectBody()
        .jsonPath("$.id").isEqualTo(1L)
        .jsonPath("$.businessName").isEqualTo("Company 1")
        .jsonPath("$.ruc").isEqualTo("12345678901");
  }
}
