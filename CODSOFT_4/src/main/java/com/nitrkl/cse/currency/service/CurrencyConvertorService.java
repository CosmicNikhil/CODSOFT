package com.nitrkl.cse.currency.service;

import java.util.List;

public interface CurrencyConvertorService {
		
	List<String> getAvailableCurrencies();
	Double convertCurrency(String baseCurrency, String targetCurrency, Double amount);
}
