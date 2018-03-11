package ru.kpfu.itis.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.itis.model.Oper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcValidator implements Validator {

    static Pattern p = Pattern.compile("([*]|[/]|[-]|[+])");

    @Override
    public boolean supports(Class<?> aClass) {
        return Oper.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Oper oper = (Oper)o;
        Float num = oper.getFirstNumber();
        if (num.isNaN()) {
            errors.rejectValue("firstNumber", "", "Пожалуйста, введите вещественное число");
        }
        num = oper.getSecondNumber();
        if (num.isNaN()) {
            errors.rejectValue("secondNumber", "", "Пожалуйста, введите вещественное число");
        }
        String act = oper.getOperation();

        Matcher m = p.matcher(act);
        if (!m.matches()) {
            errors.rejectValue("operation","", "Введите простую мат. операцию (*, /, -, +)");
        }

        if (act.equals("/") & num == 0) {
            errors.rejectValue("operation", "", "Вы не можете делить на ноль");
        }
    }
}
