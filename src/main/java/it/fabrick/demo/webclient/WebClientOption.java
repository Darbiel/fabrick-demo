package it.fabrick.demo.webclient;

import lombok.*;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class WebClientOption <K, T> {
    HttpMethod method;
    String uri;
    String baseUrl;
    Class<K> clazz;
    T body;
    MultiValueMap<String, String> queryParams;
    MultiValueMap<String, String> headers;
    Map<String, String> pathParams;


    public WebClientOption method(HttpMethod method) {
        setMethod(method);
        return this;
    }

    public WebClientOption uri(String uri) {
        setUri(uri);
        return this;
    }

    public WebClientOption baseUrl(String baseUrl) {
        setBaseUrl(baseUrl);
        return this;
    }

    public WebClientOption clazz(Class<K> clazz) {
        setClazz(clazz);
        return this;
    }

    public WebClientOption body(T body) {
        setBody(body);
        return this;
    }

    public WebClientOption queryParams(MultiValueMap<String, String> queryParams) {
        setQueryParams(queryParams);
        return this;
    }

    public WebClientOption headers(MultiValueMap<String, String> headers) {
        setHeaders(headers);
        return this;
    }

    public WebClientOption pathParams(Map<String, String> pathParams) {
        setPathParams(pathParams);
        return this;
    }
}
