package pe.despachalo.app.utils;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.core.io.Resource;
import org.springframework.r2dbc.connection.init.ScriptUtils;
import reactor.core.publisher.Mono;

public final class R2dbcScripts {

  public static void executeSqlScriptBlocking(ConnectionFactory connectionFactory, final Resource sqlScript) {
    Mono.from(connectionFactory.create())
        .flatMap(connection -> ScriptUtils.executeSqlScript(connection, sqlScript)
            .then(Mono.from(connection.close())))
        .block();
  }
}
