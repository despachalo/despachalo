package pe.despachalo.app.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.despachalo.app.company.ports.GetAllCompaniesPort;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetAllCompaniesUseCaseTest {
  @Mock
  private GetAllCompaniesPort getAllCompaniesPort;

  private GetAllCompaniesService service() {
    return new GetAllCompaniesUseCase(getAllCompaniesPort);
  }

  @Test
  void whenAskForAllCompanies_returnAllCompaniesAvailable() {
    var company1 = new Company(1L, "A&J Corp", "123321123321");
    var company2 = new Company(2L, "Rojas SAC", "333222111333");
    when(getAllCompaniesPort.getAll()).thenReturn(Flux.just(company1, company2));

    var service = service();
    var res = service.execute();

    StepVerifier.create(res)
        .as("Get all companies available")
        .assertNext(c -> {
          assertEquals(1L, c.id());
          assertEquals("A&J Corp", c.businessName());
          assertEquals("123321123321", c.ruc());
        })
        .assertNext(c -> {
          assertEquals(2L, c.id());
          assertEquals("Rojas SAC", c.businessName());
          assertEquals("333222111333", c.ruc());
        })
        .expectComplete()
        .verify();

    verify(getAllCompaniesPort, only()).getAll();
  }
}
