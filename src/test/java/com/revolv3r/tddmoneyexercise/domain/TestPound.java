package com.revolv3r.tddmoneyexercise.domain;

import com.revolv3r.tddmoneyexercise.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestPound extends TestBase
{
  @Test
  public void addPoundsToPounds()
  {
    Pound pound = new Pound(10);
    pound.add(5);
    assertEquals(15.00d, pound.getValue());
    mLogger.info("Total: " + pound);

    double baseValue = 10.02;
    double addValue = 5.14;

    pound = new Pound(baseValue);
    pound.add(addValue);

    assertEquals(calculateAddConversion(pound, new Pound(addValue), Currency.GBP).getValue(), pound.getValue());
    mLogger.info("Total: " + pound);
  }

  @Test
  public void addEurosToPounds()
  {
    double baseValue = 10.76;
    double addValue = 1.67;

    Pound pound = new Pound(baseValue);
    pound.add(addValue, Currency.EUR);

    assertEquals(calculateAddConversion(pound, new Pound(addValue), Currency.GBP).getValue(), pound.getValue());
    mLogger.info("Total: " + pound);
  }

  @Test
  public void addDollarsToPounds()
  {
    double baseValue = 10.76;
    double addValue = 1.67;

    Pound pound = new Pound(baseValue);
    pound.add(addValue, Currency.USD);

    assertEquals(calculateAddConversion(pound, new Pound(addValue), Currency.GBP).getValue(), pound.getValue());
    mLogger.info("Total: " + pound);
  }

  @Test
  public void convertPoundsToEuro()
  {
    Pound pound = new Pound(10.60);
    assertEquals(12.28, pound.convertToCurrency(Currency.EUR));
  }

  @Test
  public void convertPoundsToDollars()
  {
    Pound pound = new Pound(10.60);
    assertEquals(13.67, pound.convertToCurrency(Currency.USD));
  }

}