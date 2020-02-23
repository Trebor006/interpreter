package com.mibu.interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactList {

    private List contacts;

    public ContactList() {
        contacts = new ArrayList();
    }

    public Contact[] getContactAsArray() {
        return (Contact[]) (contacts.toArray(new Contact[1]));
    }

    public ArrayList getContactMatchingExpression(Expression expr, Context ctx, Object key) {

        ArrayList results = new ArrayList();

        Iterator elements = contacts.iterator();

        while (elements.hasNext()) {
            Object currentElement = elements.next();
            ctx.addVariable(key, currentElement);
            expr.interpret(ctx);

            Object interpreterResult = ctx.get(expr);

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
