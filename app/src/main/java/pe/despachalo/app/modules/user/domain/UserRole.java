package pe.despachalo.app.modules.user.domain;

import java.util.List;

public record UserRole(
    Long id,
    String name,
    String pictureUrl,
    List<Action> actionsAllowed) {
}
