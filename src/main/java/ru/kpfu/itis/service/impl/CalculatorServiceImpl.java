package ru.kpfu.itis.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.kpfu.itis.model.Oper;
import ru.kpfu.itis.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    private float lastResult;

    private void setLastResult(float value) {
        this.lastResult = value;
    }

    @Override
    public float doMath(Oper oper) {
        String act = oper.getOperation();
        float result = 0;
        switch (act) {
            case "+":
                result = add(oper);
                break;
            case "-":
                result = sub(oper);
                break;
            case "*":
                result = mul(oper);
                break;
            case "/":
                result = div(oper);
                break;
        }

        setLastResult(result);
        return this.lastResult;
    }

    private float add(Oper oper) {
        return oper.getFirstNumber() + oper.getSecondNumber();
    }
    private float sub(Oper oper) {
        return oper.getFirstNumber() - oper.getSecondNumber();
    }
    private float div(Oper oper) {
        return oper.getFirstNumber() / oper.getSecondNumber();
    }
    private float mul(Oper oper) {
        return oper.getFirstNumber() * oper.getSecondNumber();
    }

    public float getLastResult() {
        return this.lastResult;
    }
}
