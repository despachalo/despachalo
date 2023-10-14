package pe.despachalo.app.modules.user.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import pe.despachalo.app.modules.user.ActionId;

import java.util.List;

public record UserRoleToRegister(
    @NotBlank
    @Size(max = 100)
    String name,

    @Size(max = 100)
    String pictureUrl,

    @NotEmpty(message = "The role must have at least one action allowed")
    List<@ActionId String> actionsToAllow
) {
}
