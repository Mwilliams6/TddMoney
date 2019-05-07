package com.revolv3r.tddmoneyexercise.domain;

public enum Currency {
  USD("Dollars", "USD"),
  GBP("Pounds", "GBP"),
  EUR("Euros", "EUR");

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
