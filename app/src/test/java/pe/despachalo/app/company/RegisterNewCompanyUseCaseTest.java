package pe.despachalo.app.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.despachalo.app.company.ports.RegisterCompanyPort;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegisterNewCompanyUseCaseTest {

  @Mock
  private RegisterCompanyPort registerCompanyPort;

  private RegisterNewCompanyService service() {
    return new RegisterNewCompanyUseCase(registerCompanyPort);
  }

  @Test
  void givenACompanyToRegister_whenExecuteCompanyRegistry_thenIsRegisteredUsingPortAvailable() {
    var companyToRegister = new CompanyToRegister("A&J Corp", "123321123321");

    var companyRegistered = new Company(1L, "A&J Corp", "123321123321");
    when(registerCompanyPort.register(any())).thenReturn(Mono.just(companyRegistered));

    var service = service();
    var res = service.execute(companyToRegister);

    StepVerifier.create(res)
        .as("Check if the company registered is returned")
        .assertNext(c -> {
          assertEquals(1L, c.id());
          assertEquals("A&J Corp", c.businessName());
          assertEquals("123321123321", c.ruc());
        })
        .expectComplete()
        .verify();

    verify(registerCompanyPort, only()).register(any());
  }
}
