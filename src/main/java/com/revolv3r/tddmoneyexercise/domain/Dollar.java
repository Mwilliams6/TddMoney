package com.revolv3r.tddmoneyexercise.domain;

public class Dollar extends MonetaryUnit
{
  public Dollar(double aInitVal)
  {
    super(aInitVal);
  }

  @Override
  public Currency getUnit() {
    return Currency.DOLLAR;
  }

  @Override
  public double getDollarRate() {
    return 0;
  }

  @Override
  public double getEuroRate() {
    return 1.11338;
  }

  @Override
  public double getPoundRate() {
    return 1.28944;
  }

  @Override
  public double getConvertToDollarRate() {
    return 1;
  }

  @Override
  public double getConvertToEuroRate() {
    return 0.89663;
  }

  @Override
  public double getConvertToPoundRate() {
    return 0.773825;
  }
}
