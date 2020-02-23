package com.mibu.interpreter;

public class Main {

    public static void main(String[] args) {
        ContactList candidates = makeContactList();
        Context ctx = new Context();

        System.out.println(candidates);
        System.out.println();

        //comparando
        Contact testContact = new Contact();
        VariableExpression varLastName = new VariableExpression(testContact, "getLastName");
        ConstantExpression searchValue = new ConstantExpression("a");
        ContainsExpression equalExpresion = new ContainsExpression(varLastName, searchValue);
        Object result = candidates.getContactMatchingExpression(equalExpresion, ctx, testContact);
        System.out.println(result);

        //lista de contactos que title tenga desarrollador

        VariableExpression varTitle = new VariableExpression(testContact, "getTitle");
        ConstantExpression searchValue2 = new ConstantExpression("desarrollador");
        EqualsExpression equalExpresion2 = new EqualsExpression(varTitle, searchValue2);
        Object result2 = candidates.getContactMatchingExpression(equalExpresion2, ctx, testContact);
        System.out.println(result2);


        //comparando AND
        VariableExpression variableExpression1 = new VariableExpression(testContact, "getFirstName");
        ConstantExpression searchValue3 = new ConstantExpression("rob");
        ContainsExpression equalExpresion3 = new ContainsExpression(variableExpression1, searchValue3);

        VariableExpression variableExpression2 = new VariableExpression(testContact, "getTitle");
        ConstantExpression searchValue4 = new ConstantExpression("desarrollador");
        ContainsExpression equalExpresion6 = new ContainsExpression(variableExpression2, searchValue4);


        AndExpression andExpression = new AndExpression(equalExpresion3, equalExpresion6);

        Object result3 = candidates.getContactMatchingExpression(andExpression, ctx, testContact);
        System.out.println(result3);
    }

    private static ContactList makeContactList() {
        ContactList contactList = new ContactList();
        contactList.addContact(new Contact("carlita", "bons", "contadria", "Madepa SA."));
        contactList.addContact(
                new Contact("verito", "rodriguez", "desarrollador", "Swissbytes Ltda."));
        contactList.addContact(
                new Contact("robert", "Cabrera", "desarrollador", "Swissbytes Ltda."));
        contactList.addContact(new Contact("brigitte", "patuju", "enfermera", "Oncologico"));
        contactList.addContact(new Contact("vanessa", "kantuta", "cantante", "New Bolivia Band"));
        contactList.addContact(new Contact("jorgito", "mejia", "ftbolista", "oriente petrolero"));
        return contactList;
    }
}
