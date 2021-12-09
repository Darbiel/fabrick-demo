package it.fabrick.demo.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GenericRestClient {

    public Object getResult(WebClientOption options){
        return options.getBody() != null ? this.withBody(options) : this.withNoBody(options);
    }

    private Object withBody(WebClientOption options) {
        return WebClient.create(options.getBaseUrl())
                .method(options.getMethod())
                .uri( uriBuilder -> uriBuilder
                        .path(options.getUri())
                        .queryParams(options.getQueryParams())
                        .build(options.getPathParams()))
                .headers(headers -> headers.addAll(options.getHeaders()))
                .body(BodyInserters.fromValue(options.getBody()))
                .retrieve()
                .bodyToMono(options.getClazz()).block();

    }

    private Object withNoBody(WebClientOption options) {
        return WebClient.create(options.getBaseUrl())
                .method(options.getMethod())
                .uri( uriBuilder -> uriBuilder
                        .path(options.getUri())
                        .queryParams(options.getQueryParams())
                        .build(options.getPathParams()))
                .headers(headers -> headers.addAll(options.getHeaders()))
                .retrieve()
                .bodyToMono(options.getClazz()).block();

    }

}
