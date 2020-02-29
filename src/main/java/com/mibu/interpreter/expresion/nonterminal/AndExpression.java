package com.mibu.interpreter.expresion.nonterminal;

import com.mibu.interpreter.Context;
import com.mibu.interpreter.expresion.Expression;

public class AndExpression extends ComparisonExpression {

    public AndExpression(Expression expressionA, Expression expressionB) {
        super(expressionA, expressionB);
    }

    @Override
    public void interpret(Context context) {
        expressionA.interpret(context);
        expressionB.interpret(context);
        Boolean result =
                new Boolean(
                        ((Boolean) context.get(expressionA)).booleanValue() && ((Boolean) context.get(expressionB)).booleanValue()
                );
        context.addVariable(this, result);
    }
}
