package com.origamisoftware.teach.advanced.model.DatabaseAccessObjects;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for the PersonQuotes model
 */
public class PersonQuotesTest {
    public static final int id = 111;

    public static PersonQuotes createPersonQuotes(){
        Person person = PersonTest.createPerson();
        Quotes quotes = QuotesTest.createQuotes();

        return new PersonQuotes(person, quotes);
    }

    @Test
    public void testPersonQuotesGettersandSetters(){
        Person person = PersonTest.createPerson();
        Quotes quotes = QuotesTest.createQuotes();
        PersonQuotes personQuotes = new PersonQuotes();
        personQuotes.setId(id);
        personQuotes.setPerson(person);
        personQuotes.setQuotes(quotes);
        assertEquals("id matches", id, personQuotes.getId());
        assertEquals("person matches", person, personQuotes.getPerson());
        assertEquals("quotes matches", quotes, personQuotes.getQuotes());
    }
}