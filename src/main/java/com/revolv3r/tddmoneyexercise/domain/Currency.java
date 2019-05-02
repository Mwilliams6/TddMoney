package com.revolv3r.tddmoneyexercise.domain;

public enum Currency
{
  DOLLAR("Dollars"), POUND("Pounds"), EURO("Euros");
  private String mFriendlyName;

  Currency(String aFriendlyName)
  {
    mFriendlyName = aFriendlyName;
  }

  public String getFriendlyName()
  {
    return mFriendlyName;
  }
}
