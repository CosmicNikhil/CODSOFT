package com.nitrkl.cse.currency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nitrkl.cse.currency.service.CurrencyConvertorService;

@RestController
@RequestMapping("/currencyexchange")
public class CurrencyConverterController {

    @Autowired
    CurrencyConvertorService convertorService;

    @GetMapping
    public ResponseEntity<List<String>> getAvailableCurrency() {
        List<String> availableCurrencies = convertorService.getAvailableCurrencies();
        
        // Print the list of available currencies
        System.out.println("Available Currencies: " + availableCurrencies);
        return new ResponseEntity<>(availableCurrencies, HttpStatus.OK);
    }

    @GetMapping("/convert")
    public ResponseEntity<Double> convertCurrency(
            @RequestParam String baseCurrency,
            @RequestParam String targetCurrency,
            @RequestParam Double amount) {
    	
        // Print the input details
        System.out.println("Input Base Currency: " + baseCurrency);
        System.out.println("Input Target Currency: " + targetCurrency);
        System.out.println("Amount to Convert: " + amount);
        
        Double convertedAmount = convertorService.convertCurrency(baseCurrency, targetCurrency, amount);
        
        // Print the conversion result
        System.out.println("Converted Amount: " + amount + " " + baseCurrency.toUpperCase() + " to " + convertedAmount + " " + targetCurrency.toUpperCase());
        
        return new ResponseEntity<>(convertedAmount, HttpStatus.OK);
    }
}
