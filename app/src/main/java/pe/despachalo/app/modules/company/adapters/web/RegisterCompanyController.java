package pe.despachalo.app.modules.company.adapters.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.despachalo.app.modules.company.Company;
import pe.despachalo.app.modules.company.CompanyToRegister;
import pe.despachalo.app.modules.company.RegisterNewCompanyService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "companies")
@RequiredArgsConstructor
public class RegisterCompanyController {
  private final RegisterNewCompanyService registerNewCompanyService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Mono<Company> registerCompany(@Valid @RequestBody CompanyToRegister companyToRegister) {
    return registerNewCompanyService.execute(companyToRegister);
  }
}
