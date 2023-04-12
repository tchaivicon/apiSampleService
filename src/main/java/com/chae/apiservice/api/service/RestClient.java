package com.chae.apiservice.api.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface RestClient {
    ResponseEntity<String> get(String url, HttpHeaders headers);

    ResponseEntity<String> post(String url, Object body, HttpHeaders headers);

    ResponseEntity<String> put(String url, Object body, HttpHeaders headers);

    ResponseEntity<String> delete(String url, HttpHeaders headers);
    <T> ResponseEntity<String> callApi(String url, HttpMethod httpMethod, T requestBody, HttpHeaders headers);

}
