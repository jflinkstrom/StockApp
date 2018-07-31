package com.origamisoftware.teach.advanced.util;

import org.hibernate.Session;
import org.junit.Test;
import java.sql.Connection;
import java.sql.Statement;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 *  Tests for the DatabaseUtils class
 */
public class DatabaseUtilsTest {

    @Test(expected = DatabaseInitializationException.class)
    public void testInitializeDatabaseFails() throws Exception {
        DatabaseUtils.initializeDatabase("test");
    }

        @Test
        public void testGetSessionFactory () {
            Session session = DatabaseUtils.getSessionFactory().openSession();
            assertTrue("Session is open", session.isOpen());
        }
    }
