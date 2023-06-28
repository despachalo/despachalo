package pe.despachalo.app.modules.center.adapters.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import pe.despachalo.app.modules.center.RegisterDistributionCenterService;
import pe.despachalo.app.modules.center.domain.DistributionCenter;
import pe.despachalo.app.modules.common.domain.Location;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest(RegisterDistributionCenterController.class)
class RegisterDistributionCenterControllerTest {

  @Autowired
  private WebTestClient webClient;

  @MockBean
  private RegisterDistributionCenterService registerDistributionCenterService;

  @Value("classpath:pe/despachalo/app/modules/distribution-center/adapters/web/register-distribution-center-request.json")
  private Resource registerDistributionCenterJsonBody;

  @Test
  void shouldCallServiceToRegisterCompanyAndReturnTheCreatedOne() throws IOException {
    var centerId = 1L;
    var centerName = "Lima Center";
    var centerAddress = "Av Panama, Lima";
    var centerLocation = new Location(123456.54, -12345.32);
    var distributionCenterRegistered = new DistributionCenter(centerId, centerName, centerAddress, centerLocation);
    when(registerDistributionCenterService.execute(any())).thenReturn(Mono.just(distributionCenterRegistered));

    var jsonBody = registerDistributionCenterJsonBody.getContentAsString(StandardCharsets.UTF_8);

    webClient.post()
        .uri("/distribution-centers")
        .bodyValue(jsonBody)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .exchange()
        .expectStatus()
        .isCreated()
        .expectBody()
        .jsonPath("$.id").isEqualTo(centerId)
        .jsonPath("$.name").isEqualTo(centerName)
        .jsonPath("$.address").isEqualTo(centerAddress)
        .jsonPath("$.location.longitude").isEqualTo(centerLocation.longitude())
        .jsonPath("$.location.latitude").isEqualTo(centerLocation.latitude());
  }
}
