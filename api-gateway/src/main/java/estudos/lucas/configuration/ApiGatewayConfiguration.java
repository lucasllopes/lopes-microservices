package estudos.lucas.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ApiGatewayConfiguration {

    /*
    METODO COMENTADO POIS A CONFIGURACAO FOI FEITA NO ARQUIVO YML. A CONFIGURACAO
    FOI FEITA POR LÁ DEVIDO AO SWAGGER.
    */
/*
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "Word")
                                .addRequestParameter("Hello", "Word"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/rota-teste").uri("https://www.google.com.br"))
                .route(p -> p.path("/cambio-service/**").uri("lb://cambio-service"))
                .route(p -> p.path("/book-service/**").uri("lb://book-service"))
                .build();


    }

*/
}
