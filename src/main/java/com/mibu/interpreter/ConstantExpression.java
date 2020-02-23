package com.mibu.interpreter;

public class ConstantExpression implements Expression {

    private Object value;

    public ConstantExpression(Object newValue) {
        this.value = newValue;
    }

    @Override
    public void interpret(Context context) {
        context.addVariable(this, value);
    }

}
