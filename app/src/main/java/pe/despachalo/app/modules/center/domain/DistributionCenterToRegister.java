package pe.despachalo.app.modules.center.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import pe.despachalo.app.modules.common.domain.Location;

public record DistributionCenterToRegister(
    @NotBlank
    @Size(max = 100)
    String name,

    @NotBlank
    @Size(max = 100)
    String address,

    @NotNull
    Location location
) {
}
