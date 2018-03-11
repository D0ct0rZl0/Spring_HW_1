package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Oper;

public interface CalculatorService {
    float doMath(Oper oper);
    float getLastResult();
}
