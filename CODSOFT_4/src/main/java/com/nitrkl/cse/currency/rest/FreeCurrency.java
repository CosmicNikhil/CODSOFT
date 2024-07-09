package com.nitrkl.cse.currency.rest;

import java.util.Arrays;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class FreeCurrency {

    private static final String API_KEY_VALUE = "fca_live_A5JROXgyf7R1XKKUTzEMA50syrt9hyqQUSBbGe27";
    private static final String APIKEY = "apikey";
    private static final String URL = "https://api.freecurrencyapi.com/v1/latest";

    public Map<String, Double> getExchangeRates() {
        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder.fromHttpUrl(URL)
                    .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set(APIKEY, API_KEY_VALUE);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);

        Map<String, Double> currencyRates = (Map<String, Double>) responseEntity.getBody().get("data");


        return currencyRates;
    }
}
