package com.origamisoftware.teach.advanced.model.DatabaseAccessObjects;

import com.origamisoftware.teach.advanced.model.database.PersonDAO;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for the Person class
 */
public class PersonDAOTest extends AbstractBaseDAOTest{

    public static final String userName = "Jason";
    public static final int id = 1;

    /**
     * Testing helper method for generating Person test data
     *
     * @return a Person object that uses static constants for data.
     */
    public static PersonDAO createPerson() {
        PersonDAO person = new PersonDAO();
        person.setUserName("Jason");
        return person;
    }

    @Test
    public void testPersonGettersAndSetters() {
        PersonDAO person = createPerson();
        person.setId(id);
        assertEquals("name matches", userName, person.getUserName());
        assertEquals("id matches", id, person.getId());
    }

}