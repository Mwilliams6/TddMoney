package com.revolv3r.tddmoneyexercise.services;

import com.revolv3r.tddmoneyexercise.domain.Currency;
import com.revolv3r.tddmoneyexercise.domain.CurrencyIO;
import com.revolv3r.tddmoneyexercise.services.interfaces.CurrencyService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Service
public class CurrencyServiceImpl implements CurrencyService
{
  @Override
  public CurrencyIO getConversionRates(String aUnit)
  {
    RestTemplate restTemplate = new RestTemplate();
    CurrencyIO currencyQuotes = restTemplate.getForObject(
            "https://api.exchangeratesapi.io/latest?base="+aUnit,
            CurrencyIO.class);

    return currencyQuotes;
  }
}
