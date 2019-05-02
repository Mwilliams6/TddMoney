package com.revolv3r.tddmoneyexercise;

import com.revolv3r.tddmoneyexercise.domain.Currency;
import com.revolv3r.tddmoneyexercise.domain.Dollar;
import com.revolv3r.tddmoneyexercise.domain.Euro;
import com.revolv3r.tddmoneyexercise.domain.MonetaryUnit;

import java.util.logging.Logger;

public class TestBase
{
  public Logger mLogger = Logger.getLogger("Test");

  public MonetaryUnit calculateAddConversion(
  MonetaryUnit aBaseValue, MonetaryUnit aAddValue, Currency aUnit)
  {
    aBaseValue.add(aAddValue.convertToCurrency(aUnit));
    return aBaseValue;
  }
}
