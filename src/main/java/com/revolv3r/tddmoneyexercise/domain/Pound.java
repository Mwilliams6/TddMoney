package com.revolv3r.tddmoneyexercise.domain;

public class Pound extends MonetaryUnit {
  public Pound(double aInitVal) {
    super(aInitVal);
  }

  public Currency getUnit() {
    return Currency.POUND;
  }

  public double getDollarRate() {
    return 0.7754D;
  }

  public double getEuroRate() {
    return 0.8635D;
  }

  public double getPoundRate() {
    return 1.0D;
  }

  public double getConvertToDollarRate() {
    return 1.28944D;
  }

  public double getConvertToEuroRate() {
    return 1.158138176D;
  }

  public double getConvertToPoundRate() {
    return 1.0D;
  }
}
