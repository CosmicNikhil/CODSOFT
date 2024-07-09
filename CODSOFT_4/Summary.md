**Currency Converter Application**

**Description:**
This project is a Spring Boot application that provides currency conversion functionalities using real-time exchange rates from an external API. It allows users to retrieve available currencies and convert amounts between different currencies.

**Features:**
- **Get Available Currencies:** Retrieve a list of currencies supported by the application.
- **Convert Currency:** Convert an amount from one currency to another based on current exchange rates.

**How to Use:**
1. **Get Available Currencies API:**
   - Endpoint: `/currencyexchange`
   - Method: `GET`
   - Response Type: JSON Array of Strings
   - Example: `["USD", "EUR", "GBP", ...]`

2. **Convert Currency API:**
   - Endpoint: `/currencyexchange/convert`
   - Method: `GET`
   - Parameters:
     - `baseCurrency`: String (Currency code, e.g., "USD")
     - `targetCurrency`: String (Currency code, e.g., "EUR")
     - `amount`: Double (Amount to convert)
   - Response Type: Double (Converted amount)
   - Example: Convert 100 USD to EUR results in 85.60 EUR.
