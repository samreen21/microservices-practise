package com.microservice.apigateway;


import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRoute( RouteLocatorBuilder builder ){
        return  builder.routes ( )
                .route ( p -> p.path ( "/get" )
                        .filters ( f -> f
                                .addRequestHeader ( "Myheader","MyURI" )
                                .addRequestParameter ( "Param","Myvalue" ))

                        .uri ( "http://httpbin.org:80" ) )
                    .route ( p->p.path ( "/currency-exchange/**"  )/*enpoint for which req hits*/
                        .uri ( "lb://currency-exchange-service" ))/*name registered in eureka*/
                 .route ( p->p.path ( "/currency-conversion/**"  )
                .uri ( "lb://currency-conversion-service" ))
                .route ( p->p.path ( "/currency-conversion-feign/**"  )
                        .uri ( "lb://currency-conversion-service" ))
                /*for new */
                .route ( p->p.path ( "/currency-conversion-new/**"  )
                        .filters ( f->f.rewritePath (
                                "/currency-conversion-new/(?<segment>.*)",
                                "/currency-conversion-feign/${segment}"

                        ) )
                        .uri ( "lb://currency-conversion-service" ))
                .build ( );
    }
}
