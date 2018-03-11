package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.Oper;
import ru.kpfu.itis.service.CalculatorService;
import ru.kpfu.itis.util.CalcValidator;

@Controller
@RequestMapping(value = "/calc")
public class CalculatorController {

    @Autowired
    CalculatorService service;

    CalcValidator validator = new CalcValidator();

    @RequestMapping(value = "")
    public String showCalculator(Model model) {
        Oper oper = new Oper();
        model.addAttribute("newOper", oper);
        return "calculate";
    }

    @RequestMapping(value = "/do_math", method = RequestMethod.POST)
    public String calculate(@ModelAttribute("newOper") Oper newOper, BindingResult result, Model model) {
        validator.validate(newOper, result);

        if (result.hasErrors()) {
            model.addAttribute("result", service.getLastResult());
            return "calculate";
        } else {
            Float res = service.doMath(newOper);
            model.addAttribute("result", res);
            return "calculate";
        }
    }

}
