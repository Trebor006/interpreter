package com.mibu.interpreter.contact;

import com.mibu.interpreter.Context;
import com.mibu.interpreter.expresion.Expression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactList {

    private List contacts;

    public ContactList() {
        contacts = new ArrayList();
    }

    public List getContactMatchingExpression(Expression expression, Context context, Object key) {
        List results = new ArrayList();

        Iterator elements = contacts.iterator();

        while (elements.hasNext()) {
            Object currentElement = elements.next();
            context.addVariable(key, currentElement);
            expression.interpret(context);

            Object interpreterResult = context.get(expression);

            if ((interpreterResult != null) && (interpreterResult.equals(Boolean.TRUE))) {
                results.add(currentElement);
            }
        }
        return results;
    }

    public List getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact element) {
        if (!contacts.contains(element)) {
            contacts.add(element);
        }
    }

    public void removeContact(Contact element) {
        contacts.remove(element);
    }

    @Override
    public String toString() {
        return contacts.toString();
    }
}
