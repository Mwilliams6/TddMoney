package com.revolv3r.tddmoneyexercise.domain;

public class Euro extends MonetaryUnit
{
  public Euro(double aInitVal)
  {
    super(aInitVal);
  }

  @Override
  public Currency getUnit() {
    return Currency.POUND;
  }

  @Override
  public double getDollarRate() {
    return 0.90;
  }

  @Override
  public double getEuroRate() {
    return 1;
  }

  @Override
  public double getPoundRate() {
    return 1.158138176;
  }

  @Override
  public double getConvertToDollarRate() {
    return 1.115255;
  }

  @Override
  public double getConvertToEuroRate() {
    return 1;
  }

  @Override
  public double getConvertToPoundRate() {
    return 0.862935;
  }
}
