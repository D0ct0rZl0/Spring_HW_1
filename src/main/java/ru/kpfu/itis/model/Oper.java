package ru.kpfu.itis.model;

public class Oper {
    private float firstNumber;
    private float secondNumber;
    private String operation;

    public void setFirstNumber(float firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(float secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public float getFirstNumber() {
        return firstNumber;
    }

    public float getSecondNumber() {
        return secondNumber;
    }

    public String getOperation() {
        return operation;
    }
}
