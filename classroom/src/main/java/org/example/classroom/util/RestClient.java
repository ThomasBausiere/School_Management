package org.example.classroom.util;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestClient<T> {

    private final RestTemplate restTemplate;
    private final HttpHeaders headers;
    private final String urlApi;

    public RestClient(String urlApi, RestTemplate restTemplate){

        this.urlApi = urlApi;
        this.restTemplate = restTemplate;
        this.headers =  new HttpHeaders();
        this.headers.setContentType(MediaType.APPLICATION_JSON);
        this.headers.setAccept(List.of(MediaType.APPLICATION_JSON));
    }

    public T get(Class<T> responseType){
        HttpEntity<String> requestEntity = new HttpEntity<>("",headers);
        ResponseEntity<T> response = restTemplate.exchange(urlApi, HttpMethod.GET, requestEntity, responseType);
        if(response.hasBody()){
            return response.getBody();
        }
        return null;
    }
}
