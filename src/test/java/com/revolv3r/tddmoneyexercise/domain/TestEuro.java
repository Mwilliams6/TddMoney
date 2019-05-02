package com.revolv3r.tddmoneyexercise.domain;

import com.revolv3r.tddmoneyexercise.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEuro extends TestBase
{
  @Test
  public void addEurosToEuros()
  {
    double baseValue = 10.12;
    double addValue = 6.02;
    Euro euro = new Euro(baseValue);
    euro.add(addValue);

    assertEquals(calculateAddConversion(euro, new Euro(addValue), Currency.EURO).getValue(), euro.getValue());
    mLogger.info("Total: " + euro);
  }

  @Test
  public void addPoundsToEuros()
  {
    double baseValue = 10.12;
    double addValue = 6.02;

    Euro euro = new Euro(baseValue);
    euro.add(addValue, Currency.POUND);

    assertEquals(calculateAddConversion(euro, new Euro(addValue), Currency.POUND).getValue(), euro.getValue());
    mLogger.info("Total: " + euro);
  }

  @Test
  public void addDollarsToEuros()
  {
    double baseValue = 10.12;
    double addValue = 6.02;

    Euro euro = new Euro(10.66);
    euro.add(1.47, Currency.DOLLAR);

    assertEquals(calculateAddConversion(euro, new Euro(addValue), Currency.DOLLAR).getValue(), euro.getValue());
    mLogger.info("Total: " + euro);
  }

  @Test
  public void convertEuroToPounds()
  {
    Euro euro = new Euro(10.60);
    assertEquals(9.15, euro.convertToCurrency(Currency.POUND));
  }

  @Test
  public void convertEurosToDollars()
  {
    Euro euro = new Euro(10.60);
    assertEquals(11.82, euro.convertToCurrency(Currency.DOLLAR));
  }
}
