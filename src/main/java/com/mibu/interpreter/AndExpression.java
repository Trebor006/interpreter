package com.mibu.interpreter;

public class AndExpression extends CompoundExpression {

    public AndExpression(ComparisonExpression expressionA, ComparisonExpression expressionB) {
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
