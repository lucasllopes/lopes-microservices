package lucas.estudos.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Tag(name = "Foo bar")
@RestController
@RequestMapping("book-service")
public class FooBarController {

   /* private Logger logger = LoggerFactory.getLogger(FooBarController.class);

    @GetMapping("/v1/foo-bar")
    @Retry(name = "force-request", fallbackMethod = "metodoDeFallback")
    public String fooBar(){
        logger.info("Request to foo-bar is received!");
       var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
       return response.getBody();
       // return "Foo-Bar!!!";
    }

    @GetMapping("/v2/foo-bar")
    @CircuitBreaker(name = "default",fallbackMethod = "metodoDeFallback")
    public String fooBarV2(){
        logger.info("Request to foo-bar v2 is received!");
        var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
        return response.getBody();
        // return "Foo-Bar!!!";
    }

    @GetMapping("/v3/foo-bar")
    @RateLimiter(name = "default")
    public String fooBarV3(){
        logger.info("Request to foo-bar v3 is received!");
      //  var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
      //     return response.getBody();
        return "Foo-Bar!!!";
    }

    @GetMapping("/v4/foo-bar")
    @Operation(summary = "Find a specific book by your ID")
    @Bulkhead(name = "default")
    public String fooBarV4(){
        logger.info("Request to foo-bar v4 is received!");
        //  var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
        //     return response.getBody();
        return "Foo-Bar!!!";
    }


    public String metodoDeFallback(Exception exception){
        return "metodoDeFallback foo-bar!!!";

    }/*/
}
