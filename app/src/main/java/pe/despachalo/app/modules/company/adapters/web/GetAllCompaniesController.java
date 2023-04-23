package pe.despachalo.app.modules.company.adapters.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.despachalo.app.modules.company.Company;
import pe.despachalo.app.modules.company.GetAllCompaniesService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "companies")
@RequiredArgsConstructor
public class GetAllCompaniesController {
  private final GetAllCompaniesService getAllCompaniesService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Flux<Company> getAllCompanies() {
    return getAllCompaniesService.execute();
  }
}
