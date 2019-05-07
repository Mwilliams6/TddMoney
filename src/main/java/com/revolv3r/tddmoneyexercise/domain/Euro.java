//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.revolv3r.tddmoneyexercise.domain;

public class Euro extends MonetaryUnit {
  public Euro(double aInitVal) {
    super(aInitVal);
  }

  public Currency getUnit() {
    return Currency.EUR;
  }

  public double getDollarRate() {
    return 0.9D;
  }

  public double getEuroRate() {
    return 1.0D;
  }

  public double getPoundRate() {
    return 1.158138176D;
  }

  public double getConvertToDollarRate() {
    return 1.115255D;
  }

  public double getConvertToEuroRate() {
    return 1.0D;
  }

  public double getConvertToPoundRate() {
    return 0.862935D;
  }
}
