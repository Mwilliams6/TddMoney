package com.revolv3r.tddmoneyexercise.domain;

public class Pound extends MonetaryUnit
{
  public Pound(double aInitVal)
  {
    super(aInitVal);
  }

  @Override
  public Currency getUnit() {
    return Currency.POUND;
  }

  @Override
  public double getDollarRate() {
    return 0.7754;
  }

  @Override
  public double getEuroRate() {
    return 0.8635;
  }

  @Override
  public double getPoundRate() {
    return 1;
  }

  @Override
  public double getConvertToDollarRate() {
    return 1.28944;
  }

  @Override
  public double getConvertToEuroRate() {
    return 1.158138176;
  }

  @Override
  public double getConvertToPoundRate() {
    return 1;
  }
}
