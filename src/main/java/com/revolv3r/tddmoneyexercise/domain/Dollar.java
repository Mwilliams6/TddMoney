package com.revolv3r.tddmoneyexercise.domain;

public class Dollar extends MonetaryUnit {
  public Dollar(double aInitVal) {
    super(aInitVal);
  }

  public Currency getUnit() {
    return Currency.USD;
  }

  public double getDollarRate() {
    return 1.0D;
  }

  public double getEuroRate() {
    return 1.11338D;
  }

  public double getPoundRate() {
    return 1.28944D;
  }

  public double getConvertToDollarRate() {
    return 1.0D;
  }

  public double getConvertToEuroRate() {
    return 0.89663D;
  }

  public double getConvertToPoundRate() {
    return 0.773825D;
  }
}
