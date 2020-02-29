package com.mibu.interpreter.expresion.terminal;

import com.mibu.interpreter.Context;
import com.mibu.interpreter.expresion.Expression;

public class ValueToFindExpression implements Expression {

    private Object value;

    public ValueToFindExpression(Object newValue) {
        this.value = newValue;
    }

    @Override
    public void interpret(Context context) {
        context.addVariable(this, value);
    }

}
