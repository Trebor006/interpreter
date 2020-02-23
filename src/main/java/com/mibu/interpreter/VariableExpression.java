package com.mibu.interpreter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class VariableExpression implements Expression {

    private Object lookup;
    private String methodName;

    public VariableExpression(Object newLookup, String newMethodName) {
        this.lookup = newLookup;
        this.methodName = newMethodName;
    }

    @Override
    public void interpret(Context context) {
        try {
            Object source = context.get(lookup);
            if (Objects.nonNull(source)) {
                Method method = source.getClass().getMethod(methodName, null);
                Object result = method.invoke(source, null);
                context.addVariable(this, result);
            }
        } catch (NoSuchMethodException exc) {
        } catch (IllegalAccessException exc) {
        } catch (InvocationTargetException exc) {
        }
    }
}
