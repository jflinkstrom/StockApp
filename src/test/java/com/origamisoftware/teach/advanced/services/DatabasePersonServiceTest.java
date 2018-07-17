// package com.origamisoftware.teach.advanced.services;

// import com.origamisoftware.teach.advanced.model.DatabaseAccessObjects.Person;
// import com.origamisoftware.teach.advanced.model.DatabaseAccessObjects.PersonTest;
// import com.origamisoftware.teach.advanced.model.DatabaseAccessObjects.Quotes;
// import com.origamisoftware.teach.advanced.util.DatabaseUtils;
// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
// import java.sql.Timestamp;
// import java.util.Calendar;
// import java.util.List;
// import static org.junit.Assert.*;

// /**
//  * Unit tests for DatabasePersonService
//  */
// public class DatabasePersonServiceTest {
//     private DatabasePersonService databasePersonService;

//     private void initDb() throws Exception {
//         DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
//     }

//     @Before
//     public void setUp() throws Exception {
//         initDb();
//         databasePersonService = ServiceFactory.getPersonServiceInstance();
//     }

//     @After
//     public void tearDown() throws Exception {
//         initDb();
//     }

//     @Test
//     public void getPerson() throws PersonServiceException {
//         List<Person> peopleList = databasePersonService.getPerson();
//         assertFalse("Make sure we get some Person objects from service", peopleList.isEmpty());
//     }

//     @Test
//     public void addOrUpdatePerson() throws PersonServiceException {
//         Person newPerson = PersonTest.createPerson();
//         databasePersonService.addOrUpdatePerson(newPerson);
//         List<Person> personList = databasePersonService.getPerson();
//         boolean found = false;
//         for (Person person : personList) {
//             Timestamp returnedBirthDate = person.getBirthDate();
//             Calendar returnCalendar = Calendar.getInstance();
//             returnCalendar.setTimeInMillis(returnedBirthDate.getTime());
//             if (returnCalendar.get(Calendar.MONTH) == PersonTest.birthDayCalendar.get(Calendar.MONTH)
//                     &&
//                     returnCalendar.get(Calendar.YEAR) == PersonTest.birthDayCalendar.get(Calendar.YEAR)
//                     &&
//                     returnCalendar.get(Calendar.DAY_OF_MONTH) == PersonTest.birthDayCalendar.get(Calendar.DAY_OF_MONTH)
//                     &&
//                     person.getLastName().equals(PersonTest.lastName)
//                     &&
//                     person.getFirstName().equals(PersonTest.firstName)) {
//                 found = true;
//             }else{
//                 found = false;
//                 }
//             }
//         assertTrue("Found the person we added", found);
//     }

//     @Test
//     public void addQuotesToPersonTest(){
//         Person person = PersonTest.createPerson();
//         List<Quotes> quotes = databasePersonService.getQuotes(person);
//         for (Quotes quote : quotes) {
//             databasePersonService.addQuotesToPerson(quote, person);
//         }
//         List<Quotes> quotesList = databasePersonService.getQuotes(person);
//         System.out.println(quotes);
//         for (Quotes quote : quotes) {
//             boolean removed = quotesList.remove(quote);
//             assertTrue("Verify that the quote was found on the list", removed);
//         }
//         System.out.println(quotesList);
//         assertTrue("Verify the list of returned quotes match what was expected ", quotesList.isEmpty());
//     }
// }
