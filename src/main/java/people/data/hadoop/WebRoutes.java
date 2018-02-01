package people.data.hadoop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class WebRoutes {

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return nest(
                path("/user"),
                nest(accept(APPLICATION_JSON), route(GET("/{id}"), request ->ok().body(fromPublisher(Mono.just(new User(request.pathVariable("id"), "a")), User.class)))
                        .andRoute(method(HttpMethod.GET), request -> ok().body(fromPublisher(Flux.just(new User("2", "b")), User.class))))
                        .andRoute(POST("/").and(contentType(APPLICATION_JSON)), request -> ok().body(fromPublisher(Flux.just(new User("3", "c")), User.class)))
        ).andNest(
                path("/me"),
                route(path("/"), serverRequest -> ok().contentType(APPLICATION_JSON).body(fromPublisher(Flux.just(new User("0", "me")), User.class))
                )
        );
    }
}
