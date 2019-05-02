package com.revolv3r.tddmoneyexercise.domain;

import java.time.LocalDate;
import java.util.Map;

public class CurrencyIO
{
  /*
  Example Data:
    "base":"USD",
    "rates":{"BGN":1.7443810203,"NZD":1.508740635,"ILS":3.5975740278,"RUB":65.334909026,"CAD":1.3435604709,"USD":1.0,"PHP":51.7508027114,"CHF":1.0184623618,"AUD":1.4243667499,"JPY":111.4966107742,"TRY":5.9643239386,"HKD":7.8449875134,"MYR":4.1369960756,"HRK":6.6128255441,"CZK":22.8754905458,"IDR":14250.0,"DKK":6.6584909026,"NOK":8.6915804495,"HUF":288.9760970389,"GBP":0.7664109882,"MXN":18.9499643239,"THB":32.0246164823,"ISK":122.5472707813,"ZAR":14.4646806993,"BRL":3.9328398145,"SGD":1.3609525508,"PLN":3.8173385658,"INR":69.3738851231,"KRW":1163.1733856582,"RON":4.2439350696,"CNY":6.7345701035,"SEK":9.5299678915,"EUR":0.8919015341},
    "date":"2019-05-02"
   */

  private String mBase;
  private Map<String, Double> mRates;
  private LocalDate mDate;

  public String getBase() {
    return mBase;
  }

  public void setBase(String aBaseCurrencyCode) {
    mBase = aBaseCurrencyCode;
  }

  public Map<String, Double> getRates() {
    return mRates;
  }

  public void setRates(Map<String, Double> aRates) {
    mRates = aRates;
  }

  public LocalDate getDate() {
    return mDate;
  }

  public void setDate(LocalDate aDateObtained) {
    mDate = aDateObtained;
  }



}
