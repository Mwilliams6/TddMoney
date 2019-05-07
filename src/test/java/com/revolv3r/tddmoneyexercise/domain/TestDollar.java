package com.revolv3r.tddmoneyexercise.domain;

import com.revolv3r.tddmoneyexercise.TestBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDollar extends TestBase
{
  @Test
  public void addDollarsToDollars()
  {
    double baseValue = 10;
    double addValue = 14.60;
    Dollar dollar = new Dollar(baseValue);
    dollar.add(addValue);

    assertEquals(calculateAddConversion(dollar, new Dollar(addValue), Currency.USD).getValue(), dollar.getValue());
    mLogger.info("Total: " + dollar);
  }

  @Test
  public void addPoundsToDollars()
  {
    double baseValue = 10.66;
    double addValue = 14.60;

    Dollar dollar = new Dollar(baseValue);
    dollar.add(addValue, Currency.GBP);

    assertEquals(calculateAddConversion(dollar, new Pound(addValue), Currency.GBP).getValue(), dollar.getValue());
    mLogger.info("Total: " + dollar);
  }

  @Test
  public void addEurosToDollars()
  {
    double baseValue = 10.66;
    double addValue = 14.60;

    Dollar dollar = new Dollar(baseValue);
    dollar.add(addValue, Currency.EUR);

    assertEquals(calculateAddConversion(dollar, new Euro(addValue), Currency.EUR).getValue(), dollar.getValue());
    mLogger.info("Total: " + dollar);
  }

  @Test
  public void convertDollarsToPounds()
  {
    Dollar dollar = new Dollar(10.60);
    assertEquals(8.20, dollar.convertToCurrency(Currency.GBP));
  }

  @Test
  public void convertDollarsToEuros()
  {
    Dollar dollar = new Dollar(10.60);
    assertEquals(9.50, dollar.convertToCurrency(Currency.EUR));
  }
}
