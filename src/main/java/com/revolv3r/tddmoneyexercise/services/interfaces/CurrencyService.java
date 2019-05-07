package com.revolv3r.tddmoneyexercise.services.interfaces;

import com.revolv3r.tddmoneyexercise.domain.Currency;
import org.springframework.stereotype.Service;


public interface CurrencyService
{
  double conversionRate(Currency aUnit, Currency aDestUnit);
}
