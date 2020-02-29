package com.mibu.interpreter.expresion.nonterminal;

import com.mibu.interpreter.Context;
import com.mibu.interpreter.expresion.Expression;

public class GreaterOrEqualToExpression extends ComparisonExpression {

  public GreaterOrEqualToExpression(Expression expressionA, Expression expressionB) {
    super(expressionA, expressionB);
  }

  @Override
  public void interpret(Context context) {
    expressionA.interpret(context);
    expressionB.interpret(context);
    Boolean result =
        new Boolean(
            ((Comparable) context.get(expressionA)).compareTo((Comparable) context.get(expressionB))
                >= 0);

    context.addVariable(this, result);
  }
}
