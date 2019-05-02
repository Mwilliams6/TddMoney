package com.revolv3r.tddmoneyexercise.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class MonetaryUnit
{
  private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
  private double mValue;

  public MonetaryUnit(double aValue)
  {
    setValue(aValue);
  }

  public abstract Currency getUnit();
  public abstract double getDollarRate();
  public abstract double getEuroRate();
  public abstract double getPoundRate();
  public abstract double getConvertToDollarRate();
  public abstract double getConvertToEuroRate();
  public abstract double getConvertToPoundRate();

  public double getValue()
  {
    return BigDecimal.valueOf(mValue)
            .setScale(2, RoundingMode.HALF_UP)
            .doubleValue();
  }

  public void setValue(double aValue)
  {
    mValue = aValue;
  }

  public double addRate(Currency aUnit)
  {
    if(getValue()==0 || aUnit==null)
      return 1;

    switch(aUnit) {
      case POUND:
        return getPoundRate();

      case DOLLAR:
        return getDollarRate();

      case EURO:
        return getEuroRate();

      default:
        return 1;
    }
  }

  public double convertRate(Currency aUnit)
  {
    double value = getValue();

    if(value==0 || aUnit==null)
      return value;

    switch(aUnit)
    {
      case POUND:
        return value * getConvertToPoundRate();

      case DOLLAR:
        return value * getConvertToDollarRate();

      case EURO:
        return value * getConvertToEuroRate();

      default:
        return value;
    }
  }

  //add a different currency unit
  public void add(double aValue, Currency aUnit)
  {
    aValue *= addRate(aUnit);
    mValue += aValue;
  }

  public double convertToCurrency(Currency aUnit)
  {
    return BigDecimal.valueOf(convertRate(aUnit))
          .setScale(2, RoundingMode.HALF_UP)
          .doubleValue();
  }

  //add same currency unit
  public void add(double aValue)
  {
    mValue+=aValue;
  }

  @Override
  public String toString()
  {
    return String.format("%s %s", DECIMAL_FORMAT.format(mValue), getUnit().getFriendlyName()) ;
  }
}
