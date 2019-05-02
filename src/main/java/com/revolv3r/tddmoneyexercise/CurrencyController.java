package com.revolv3r.tddmoneyexercise;

import com.revolv3r.tddmoneyexercise.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CurrencyController
{
  @RequestMapping({"/"})
  public String convert(Model model)
  {
    return "converter";
  }


  @RequestMapping( value = "/convertInput", method = RequestMethod.GET)
  public @ResponseBody double[] Input(@RequestParam String input, @RequestParam String unit)
  {
    double[] results = new double[3];
    MonetaryUnit monetaryUnit = null;
    double doubleValue = Double.valueOf(input);
    Currency currUnit = Currency.valueOf(unit.toUpperCase());

    switch(currUnit)
    {
      case DOLLAR:
        monetaryUnit = new Dollar(doubleValue);
        break;

      case EURO:
        monetaryUnit = new Euro(doubleValue);
        break;

      case POUND:
        monetaryUnit = new Pound(doubleValue);
        break;
    }

    results[0] = monetaryUnit.convertToCurrency(Currency.DOLLAR);
    results[1] = monetaryUnit.convertToCurrency(Currency.EURO);
    results[2] = monetaryUnit.convertToCurrency(Currency.POUND);

    return results;
  }
}
