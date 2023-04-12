package com.chae.apiservice.api.service.impl;

import com.chae.apiservice.api.service.RestClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service


public class RestTemplateClient implements RestClient {

    private final RestTemplate restTemplate;

    public RestTemplateClient() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public ResponseEntity<String> get(String url, HttpHeaders headers) {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    @Override
    public ResponseEntity<String> post(String url, Object body, HttpHeaders headers) {
        HttpEntity<Object> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }

    @Override
    public ResponseEntity<String> put(String url, Object body, HttpHeaders headers) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(String url, HttpHeaders headers) {
        return null;
    }

    @Override
    public <T> ResponseEntity<String> callApi(String url, HttpMethod httpMethod, T requestBody, HttpHeaders headers) {
        HttpEntity<T> entity = new HttpEntity<>(requestBody, headers);
        return restTemplate.exchange(url, httpMethod, entity, String.class);
    }
}