package com.revolv3r.tddmoneyexercise.services.interfaces;

import com.revolv3r.tddmoneyexercise.domain.CurrencyIO;


public interface CurrencyService
{
  CurrencyIO getConversionRates(String aUnit);
}
