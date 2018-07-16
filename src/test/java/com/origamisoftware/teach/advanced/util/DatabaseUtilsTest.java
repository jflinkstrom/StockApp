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

    @Test
    public void testGoodInitFile() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    @Test(expected = DatabaseInitializationException.class)
    public void testInitializeDatabaseFails() throws Exception {
        DatabaseUtils.initializeDatabase("test");
    }

        @Test
        public void testGetSessionFactory () {
            Session session = DatabaseUtils.getSessionFactory().openSession();
            assertTrue("Session is open", session.isOpen());
        }

        @Test
        public void testGetConnection () throws Exception {
            Connection connection = DatabaseUtils.getConnection();
            assertNotNull("verify that we can get a connection ok", connection);
        }

        @Test
        public void testGetConnectionWorks () throws Exception {
            Connection connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();
            boolean execute = statement.execute("select * from quote");
            assertTrue("verify that we can execute a statement against quote table", execute);
            execute = statement.execute("select * from person");
            assertTrue("verify that we can execute a statement against person table", execute);
            execute = statement.execute("select * from stock_symbol");
            assertTrue("verify that we can execute a statement against stock_symbol table", execute);
            execute = statement.execute("select * from person_stocks");
            assertTrue("verify that we can execute a statement against person_stocks table", execute);
        }
    }
