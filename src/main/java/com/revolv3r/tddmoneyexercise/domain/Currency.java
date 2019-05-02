package com.revolv3r.tddmoneyexercise.domain;

public enum Currency {
  DOLLAR("Dollars", "USD"),
  POUND("Pounds", "GBP"),
  EURO("Euros", "EUR");

  private String mFriendlyName;
  private String mCurrencyCode;

  Currency(String aFriendlyName, String aCurrencyCode) {
    mFriendlyName = aFriendlyName;
    mCurrencyCode = aCurrencyCode;
  }

  public String getFriendlyName() {
    return mFriendlyName;
  }
  public String getCurrencyCode() {
    return mCurrencyCode;
  }

}
