package pe.despachalo.app.modules.company.adapters.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import pe.despachalo.app.modules.company.Company;
import pe.despachalo.app.modules.company.GetAllCompaniesService;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@WebFluxTest(GetAllCompaniesController.class)
class GetAllCompaniesControllerTest {

  @Autowired
  private WebTestClient webClient;

  @MockBean
  private GetAllCompaniesService getAllCompaniesService;

  private Flux<Company> companies() {
    var company1 = new Company(1L, "Company 1", "12345678901");
    var company2 = new Company(2L, "Company 2", "12345678902");
    var company3 = new Company(3L, "Company 3", "12345678903");
    return Flux.just(company1, company2, company3);
  }

  @Test
  void shouldReturnAListOfCompanies() {
    var companies = companies();
    when(getAllCompaniesService.execute()).thenReturn(companies);

    webClient.get()
        .uri("/companies")
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .jsonPath("[0].id").isEqualTo(1L)
        .jsonPath("[1].id").isEqualTo(2L)
        .jsonPath("[2].id").isEqualTo(3L);
  }
}
