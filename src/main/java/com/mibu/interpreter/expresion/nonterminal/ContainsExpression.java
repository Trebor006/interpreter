package com.mibu.interpreter.expresion.nonterminal;

import com.mibu.interpreter.Context;
import com.mibu.interpreter.expresion.Expression;

public class ContainsExpression extends ComparisonExpression {

    public ContainsExpression(Expression expressionA, Expression expressionB) {
        super(expressionA, expressionB);
    }

    @Override
    public void interpret(Context context) {
        expressionA.interpret(context);
        expressionB.interpret(context);
        Object expAResult = context.get(expressionA);
        Object expBResult = context.get(expressionB);

        if ((expAResult instanceof String) && (expBResult instanceof String)) {
            if (((String) expAResult).indexOf((String) expBResult) != -1) {
                context.addVariable(this, Boolean.TRUE);
                return;
            }
        }

        context.addVariable(this, Boolean.FALSE);
        return;
    }
}
