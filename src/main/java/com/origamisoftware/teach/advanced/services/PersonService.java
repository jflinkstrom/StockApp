package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.DatabaseAccessObjects.Person;
import com.origamisoftware.teach.advanced.model.DatabaseAccessObjects.Quotes;

import java.util.List;

public interface PersonService {

    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     * @throws  PersonServiceException if a service can not read or write the requested data
     *      *                                    or otherwise perform the requested operation.
     */
    List<Person> getPerson() throws PersonServiceException;

    /**
     * Add a new person or update an existing Person's data
     *
     * @param person a person object to either update or create
     * @throws //if a service can not read or write the requested data
     *      *                                    or otherwise perform the requested operation.
     */
    void addOrUpdatePerson(Person person) throws PersonServiceException;

    /**
     * Get a list of all a person's stock data.
     *
     * @return a list of Quotes instances
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    List<Quotes> getQuotes (Person person) throws PersonServiceException;

    /**
     * Assign quote data to a person.
     *
     * @param quote  The hobby to assign
     * @param person The person to assign the hobby too.
     * @throws PersonServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    void addQuotesToPerson(Quotes quote, Person person) throws PersonServiceException;
}
