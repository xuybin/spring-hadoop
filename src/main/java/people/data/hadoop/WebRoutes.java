package people.data.hadoop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class WebRoutes {

    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions.route(
                GET("/"), request -> {
                    Mono<User> user = Mono.just(new User("1", "a"));

                    return  ServerResponse.ok().body(fromPublisher(user, User.class));
                });
    }
}
