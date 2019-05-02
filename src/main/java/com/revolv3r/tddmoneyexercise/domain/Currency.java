package com.revolv3r.tddmoneyexercise.domain;

public enum Currency {
  DOLLAR("Dollars"),
  POUND("Pounds"),
  EURO("Euros");

  private String mFriendlyName;

  private Currency(String aFriendlyName) {
    this.mFriendlyName = aFriendlyName;
  }

  public String getFriendlyName() {
    return this.mFriendlyName;
  }
}
