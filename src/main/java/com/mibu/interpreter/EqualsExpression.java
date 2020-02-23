package com.mibu.interpreter;

public class EqualsExpression extends ComparisonExpression {

    public EqualsExpression(Expression expressionA, Expression expressionB) {
        super(expressionA, expressionB);
    }

    @Override
    public void interpret(Context context) {
        expressionA.interpret(context);
        expressionB.interpret(context);
        Boolean result = new Boolean((context.get(expressionA)).equals(context.get(expressionB)));

        context.addVariable(this, result);
    }
}
