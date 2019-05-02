package com.revolv3r.tddmoneyexercise.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class MonetaryUnit {
  private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
  private double mValue;

  public MonetaryUnit(double aValue) {
    this.setValue(aValue);
  }

  public abstract Currency getUnit();

  public abstract double getDollarRate();

  public abstract double getEuroRate();

  public abstract double getPoundRate();

  public abstract double getConvertToDollarRate();

  public abstract double getConvertToEuroRate();

  public abstract double getConvertToPoundRate();

  public double getValue() {
    return BigDecimal.valueOf(this.mValue).setScale(2, RoundingMode.HALF_UP).doubleValue();
  }

  public void setValue(double aValue) {
    this.mValue = aValue;
  }

  public double addRate(Currency aUnit) {
    if (this.getValue() != 0.0D && aUnit != null) {
      switch(aUnit) {
      case POUND:
        return this.getPoundRate();
      case DOLLAR:
        return this.getDollarRate();
      case EURO:
        return this.getEuroRate();
      default:
        return 1.0D;
      }
    } else {
      return 1.0D;
    }
  }

  public double convertRate(Currency aUnit) {
    double value = this.getValue();
    if (value != 0.0D && aUnit != null) {
      switch(aUnit) {
      case POUND:
        return value * this.getConvertToPoundRate();
      case DOLLAR:
        return value * this.getConvertToDollarRate();
      case EURO:
        return value * this.getConvertToEuroRate();
      default:
        return value;
      }
    } else {
      return value;
    }
  }

  public void add(double aValue, Currency aUnit) {
    aValue *= this.addRate(aUnit);
    this.mValue += aValue;
  }

  public double convertToCurrency(Currency aUnit) {
    return BigDecimal.valueOf(this.convertRate(aUnit)).setScale(2, RoundingMode.HALF_UP).doubleValue();
  }

  public void add(double aValue) {
    this.mValue += aValue;
  }

  public String toString() {
    return String.format("%s %s", DECIMAL_FORMAT.format(this.mValue), this.getUnit().getFriendlyName());
  }
}
