package com.revolv3r.tddmoneyexercise;

import com.revolv3r.tddmoneyexercise.domain.*;
import com.revolv3r.tddmoneyexercise.services.interfaces.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class CurrencyController
{
  @Resource
  private CurrencyService mService;

  public CurrencyController()
  {
  }

  private Map<String, CurrencyIO> mUnitStore = new HashMap<>();

  @RequestMapping({"/"})
  public String convert(Model model) {
    getQuotes(model,"USD");

    return "converter";
  }

  private void getQuotes(Model aModel, String aBaseCurrency)
  {
    RestTemplate restTemplate = new RestTemplate();
    CurrencyIO currencyQuotes = restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base="+aBaseCurrency, CurrencyIO.class);

    Map<String, Double> treeMap = new TreeMap<>(currencyQuotes.getRates());

    aModel.addAttribute("quotes", treeMap);
    aModel.addAttribute("baseCurrency", currencyQuotes.getBase());
    aModel.addAttribute("dateOfRetrieval", currencyQuotes.getDate());
  }

//  @RequestMapping(
//    value = {"/convertInput"},
//    method = {RequestMethod.GET}
//  )
//  @ResponseBody
//  public double[] convert(Model aModel, @RequestParam String input, @RequestParam String unit) {
//    double[] results = new double[3];
//    MonetaryUnit monetaryUnit = null;
//    double doubleValue = Double.valueOf(input);
//    Currency currUnit = Currency.valueOf(unit.toUpperCase());
//    switch(currUnit) {
//    case DOLLAR:
//      monetaryUnit = new Dollar(doubleValue);
//      break;
//    case EURO:
//      monetaryUnit = new Euro(doubleValue);
//      break;
//    case POUND:
//      monetaryUnit = new Pound(doubleValue);
//    }
//
//    results[0] = ((MonetaryUnit)monetaryUnit).convertToCurrency(Currency.DOLLAR);
//    results[1] = ((MonetaryUnit)monetaryUnit).convertToCurrency(Currency.EURO);
//    results[2] = ((MonetaryUnit)monetaryUnit).convertToCurrency(Currency.POUND);
//
//    getQuotes(aModel, currUnit.getCurrencyCode());
//
//    return results;
//  }

//  @RequestMapping(
//    value = {"/addInput"},
//    method = {RequestMethod.GET}
//  )
//  @ResponseBody
//  public double[] add(@RequestParam String input, @RequestParam String unit, @RequestParam String addInput, @RequestParam String addUnit) {
//    double[] results = new double[3];
//    MonetaryUnit monetaryUnit = null;
//    double doubleValue = Double.valueOf(input);
//    double doubleAddValue = Double.valueOf(addInput);
//    Currency currUnit = Currency.valueOf(unit.toUpperCase());
//    Currency currAddUnit = Currency.valueOf(addUnit.toUpperCase());
//    switch(currUnit) {
//    case DOLLAR:
//      monetaryUnit = new Dollar(doubleValue);
//      break;
//    case EURO:
//      monetaryUnit = new Euro(doubleValue);
//      break;
//    case POUND:
//      monetaryUnit = new Pound(doubleValue);
//    }
//
//    ((MonetaryUnit)monetaryUnit).add(doubleAddValue, currAddUnit);
//    results[0] = ((MonetaryUnit)monetaryUnit).convertToCurrency(Currency.DOLLAR);
//    results[1] = ((MonetaryUnit)monetaryUnit).convertToCurrency(Currency.EURO);
//    results[2] = ((MonetaryUnit)monetaryUnit).convertToCurrency(Currency.POUND);
//    return results;
//  }

  @RequestMapping(value = {"/convertChosenInput"}, method = {RequestMethod.GET})
  @ResponseBody public double convertInput(@RequestParam String input, @RequestParam String unit, @RequestParam String destUnit)
  {
    double doubleValue = Double.valueOf(input);
    double multiplier =1d;
    CurrencyIO cr;

    if (!mUnitStore.containsKey(unit))
    {
      cr = mService.getConversionRates(unit);
      mUnitStore.put(unit, cr);
    }
    else
    {
      cr = mUnitStore.get(unit);
    }

    if (cr.getRates().containsKey(destUnit))
      multiplier = cr.getRates().get(destUnit);

    return doubleValue * multiplier;
  }
}
