package pe.despachalo.app.modules.user.adapters.env;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "application.permissions")
public class PermissionProps {
  @Valid
  private Module programming;

  @Valid
  private Module users;

  @Getter
  @Setter
  static class Module {
    @NotBlank
    private String id;

    @NotBlank
    private String description;

    @NotEmpty
    private List<@Valid Action> actions;
  }

  @Getter
  @Setter
  static class Action {
    @NotBlank
    private String id;

    @NotBlank
    private String description;
  }

  public List<Module> allModules() {
    return List.of(programming, users);
  }
}
