package com.nitrkl.cse.currency.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitrkl.cse.currency.rest.FreeCurrency;

@Service
public class CurrencyConvertorServiceImpl implements CurrencyConvertorService {

    @Autowired
    private FreeCurrency freeCurrency;
    
    private Map<String, Double> exchangeRates;

    private void initExchangeRates() {
        if (exchangeRates == null) {
            exchangeRates = freeCurrency.getExchangeRates().entrySet().stream()
                .collect(Collectors.toMap(
                    Map.Entry::getKey, 
                    entry -> ((Number) entry.getValue()).doubleValue()
                ));
        }
    }

    @Override
    public List<String> getAvailableCurrencies() {
        initExchangeRates();
        return exchangeRates.keySet().stream().collect(Collectors.toList());
    }

    @Override
    public Double convertCurrency(String baseCurrency, String targetCurrency, Double amount) {
        initExchangeRates();
        
        // Ensure currencies are in uppercase
        baseCurrency = baseCurrency.toUpperCase();
        targetCurrency = targetCurrency.toUpperCase();

        // Check for null values
        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            throw new IllegalArgumentException("Invalid currency code");
        }

        BigDecimal baseToUSD = BigDecimal.valueOf(exchangeRates.get(baseCurrency));
        BigDecimal targetToUSD = BigDecimal.valueOf(exchangeRates.get(targetCurrency));
        BigDecimal amountInBase = BigDecimal.valueOf(amount);

        // Step 1: Convert base currency to USD
        BigDecimal amountInUSD = amountInBase.divide(baseToUSD, 10, RoundingMode.HALF_UP);

        // Step 2: Convert from USD to target currency
        BigDecimal convertedAmount = amountInUSD.multiply(targetToUSD);

        // Step 3: Round the final amount to 2 decimal places
        BigDecimal roundedAmount = convertedAmount.setScale(2, RoundingMode.HALF_UP);

        return roundedAmount.doubleValue();
    }
}
