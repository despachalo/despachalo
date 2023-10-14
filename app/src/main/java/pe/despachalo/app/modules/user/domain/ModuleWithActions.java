package pe.despachalo.app.modules.user.domain;

import java.util.List;

/**
 * Class that represents a program module of the whole system,
 * e.g., Centers Management, Dispatch Programming, etc.
 * */
public record ModuleWithActions(
    String id,
    String description,
    List<Action> actionsAllowed) {
}
