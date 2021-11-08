package io.artur.spring.webservices.failover.msscinventoryfailover.config;

import io.artur.spring.webservices.failover.msscinventoryfailover.web.InventoryHandler;
import org.springframework.cloud.util.ConditionalOnBootstrapEnabled;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 *
 */
@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction inventoryRoute(InventoryHandler handler) {
        return route(GET("/inventory-failover").and(accept(MediaType.APPLICATION_JSON)), handler::listInventory);
    }
}
