package pe.despachalo.app.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CompanyToRegister(
    @NotBlank
    @Size(max = 100)
    String businessName,

    @NotBlank
    @Pattern(regexp="\\d{11}", message = "RUC must be a number with 11 digits")
    String ruc
) {
}
