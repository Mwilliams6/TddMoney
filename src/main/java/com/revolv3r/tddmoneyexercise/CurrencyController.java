package com.revolv3r.tddmoneyexercise;

import com.revolv3r.tddmoneyexercise.domain.Currency;
import com.revolv3r.tddmoneyexercise.domain.Dollar;
import com.revolv3r.tddmoneyexercise.domain.Euro;
import com.revolv3r.tddmoneyexercise.domain.MonetaryUnit;
import com.revolv3r.tddmoneyexercise.domain.Pound;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class CurrencyController {
  public CurrencyController() {
  }



  @RequestMapping({"/"})
  public String convert(Model model) {
    RestTemplate restTemplate = new RestTemplate();
    CurrencyIO currencyQuotes = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", CurrencyIO.class);

    initRates();

    return "converter";
  }

  @RequestMapping(
    value = {"/convertInput"},
    method = {RequestMethod.GET}
  )
  @ResponseBody
  public double[] convert(@RequestParam String input, @RequestParam String unit) {
    double[] results = new double[3];
    MonetaryUnit monetaryUnit = null;
    double doubleValue = Double.valueOf(input);
    Currency currUnit = Currency.valueOf(unit.toUpperCase());
    switch(currUnit) {
    case DOLLAR:
      monetaryUnit = new Dollar(doubleValue);
      break;
    case EURO:
      monetaryUnit = new Euro(doubleValue);
      break;
    case POUND:
      monetaryUnit = new Pound(doubleValue);
    }

    results[0] = ((MonetaryUnit)monetaryUnit).convertToCurrency(Currency.DOLLAR);
    results[1] = ((MonetaryUnit)monetaryUnit).convertToCurrency(Currency.EURO);
    results[2] = ((MonetaryUnit)monetaryUnit).convertToCurrency(Currency.POUND);
    return results;
  }

  @RequestMapping(
    value = {"/addInput"},
    method = {RequestMethod.GET}
  )
  @ResponseBody
  public double[] add(@RequestParam String input, @RequestParam String unit, @RequestParam String addInput, @RequestParam String addUnit) {
    double[] results = new double[3];
    MonetaryUnit monetaryUnit = null;
    double doubleValue = Double.valueOf(input);
    double doubleAddValue = Double.valueOf(addInput);
    Currency currUnit = Currency.valueOf(unit.toUpperCase());
    Currency currAddUnit = Currency.valueOf(addUnit.toUpperCase());
    switch(currUnit) {
    case DOLLAR:
      monetaryUnit = new Dollar(doubleValue);
      break;
    case EURO:
      monetaryUnit = new Euro(doubleValue);
      break;
    case POUND:
      monetaryUnit = new Pound(doubleValue);
    }

    ((MonetaryUnit)monetaryUnit).add(doubleAddValue, currAddUnit);
    results[0] = ((MonetaryUnit)monetaryUnit).convertToCurrency(Currency.DOLLAR);
    results[1] = ((MonetaryUnit)monetaryUnit).convertToCurrency(Currency.EURO);
    results[2] = ((MonetaryUnit)monetaryUnit).convertToCurrency(Currency.POUND);
    return results;
  }
}
