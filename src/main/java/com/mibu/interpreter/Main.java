package com.mibu.interpreter;

import com.mibu.interpreter.contact.Contact;
import com.mibu.interpreter.contact.ContactList;
import com.mibu.interpreter.expresion.nonterminal.AndExpression;
import com.mibu.interpreter.expresion.nonterminal.ContainsExpression;
import com.mibu.interpreter.expresion.nonterminal.EqualsExpression;
import com.mibu.interpreter.expresion.nonterminal.OrExpression;
import com.mibu.interpreter.expresion.terminal.ValueToFindExpression;
import com.mibu.interpreter.expresion.terminal.MethodToFindExpression;

public class Main {

    public static void main(String[] args) {
        ContactList candidates = makeContactList();

        Context ctx = new Context();

        System.out.println(candidates);
        System.out.println();

        //comparando
        Contact testContact = new Contact();
        MethodToFindExpression varLastName = new MethodToFindExpression(testContact, "getLastName");
        ValueToFindExpression searchValue = new ValueToFindExpression("a");
        ContainsExpression equalExpresion = new ContainsExpression(varLastName, searchValue);

//        interpretar
        Object result = candidates.getContactMatchingExpression(equalExpresion, ctx, testContact);
        System.out.println(result);
//
//        //lista de contactos que title tenga desarrollador
//
//        MethodToFindExpression varTitle = new MethodToFindExpression(testContact, "getTitle");
//        ValueToFindExpression searchValue2 = new ValueToFindExpression("desarrollador");
//        EqualsExpression equalExpresion2 = new EqualsExpression(varTitle, searchValue2);
//        Object result2 = candidates.getContactMatchingExpression(equalExpresion2, ctx, testContact);
////        System.out.println(result2);


//        //comparando AND
//        MethodToFindExpression methodToFindExpression1 = new MethodToFindExpression(testContact, "getFirstName");
//        ValueToFindExpression searchValue3 = new ValueToFindExpression("rob");
//        ContainsExpression equalExpresion3 = new ContainsExpression(methodToFindExpression1, searchValue3);
//
//        MethodToFindExpression methodToFindExpression2 = new MethodToFindExpression(testContact, "getTitle");
//        ValueToFindExpression searchValue4 = new ValueToFindExpression("desarrollador");
//        ContainsExpression equalExpresion6 = new ContainsExpression(methodToFindExpression2, searchValue4);
//
//
//        AndExpression andExpression = new AndExpression(equalExpresion3, equalExpresion6);
//
////        Object result3 = candidates.getContactMatchingExpression(andExpression, ctx, testContact);
////        System.out.println(result3);
//
//
//
//
//
//        //comparando AND
//        MethodToFindExpression methodToFindExpression7 = new MethodToFindExpression(testContact, "getFirstName");
//        ValueToFindExpression searchValue7 = new ValueToFindExpression("brigitte");
//        EqualsExpression equalExpresion7 = new EqualsExpression(methodToFindExpression7, searchValue7);
//
//        MethodToFindExpression methodToFindExpression9 = new MethodToFindExpression(testContact, "getTitle");
//        ValueToFindExpression searchValue9 = new ValueToFindExpression("enfermeria");
//        EqualsExpression equalExpresion9 = new EqualsExpression(methodToFindExpression9, searchValue9);
//
//        AndExpression andExpressionX = new AndExpression(equalExpresion7, equalExpresion9);
//
//        OrExpression orExpression = new OrExpression(andExpression, andExpressionX);
//
//        Object result6 = candidates.getContactMatchingExpression(orExpression, ctx, testContact);
//        System.out.println(result6);
    }

    private static ContactList makeContactList() {
        ContactList contactList = new ContactList();
        contactList.addContact(new Contact("brigitte", "bons", "contadria", "Madepa SA."));
        contactList.addContact(
                new Contact("verito", "rodriguez", "desarrollador", "Swissbytes Ltda."));
        contactList.addContact(
                new Contact("robert", "Cabrera", "desarrollador", "Swissbytes Ltda."));
        contactList.addContact(new Contact("brigitte", "patuju", "enfermeria", "Oncologico"));
        contactList.addContact(new Contact("vanessa", "kantuta", "cantante", "New Bolivia Band"));
        contactList.addContact(new Contact("jorgito", "mejia", "ftbolista", "oriente petrolero"));
        return contactList;
    }
}
