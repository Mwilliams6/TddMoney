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

    assertEquals(calculateAddConversion(dollar, new Dollar(addValue), Currency.DOLLAR).getValue(), dollar.getValue());
    mLogger.info("Total: " + dollar);
  }

  @Test
  public void addPoundsToDollars()
  {
    double baseValue = 10.66;
    double addValue = 14.60;

    Dollar dollar = new Dollar(baseValue);
    dollar.add(addValue, Currency.POUND);

    assertEquals(calculateAddConversion(dollar, new Pound(addValue), Currency.POUND).getValue(), dollar.getValue());
    mLogger.info("Total: " + dollar);
  }

  @Test
  public void addEurosToDollars()
  {
    double baseValue = 10.66;
    double addValue = 14.60;

    Dollar dollar = new Dollar(baseValue);
    dollar.add(addValue, Currency.EURO);

    assertEquals(calculateAddConversion(dollar, new Euro(addValue), Currency.EURO).getValue(), dollar.getValue());
    mLogger.info("Total: " + dollar);
  }

  @Test
  public void convertDollarsToPounds()
  {
    Dollar dollar = new Dollar(10.60);
    assertEquals(8.20, dollar.convertToCurrency(Currency.POUND));
  }

  @Test
  public void convertDollarsToEuros()
  {
    Dollar dollar = new Dollar(10.60);
    assertEquals(9.50, dollar.convertToCurrency(Currency.EURO));
  }
}
