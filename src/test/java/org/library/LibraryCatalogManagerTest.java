package org.library;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
/**
 * **********************************************************************+
 * Package Name          :org.library
 * Author                :ochwada
 * Name of the Project   :LibraryCatalogManager
 * Date                  :Friday,09. May.2025 at 16:06
 * Description           :
 * Objective             :
 * /** ***********************************************************************+
 */
public class LibraryCatalogManagerTest {

    private LibraryCatalogManager catalog;


    /**
     * Executed once before all test methods.
     * Useful for initializing shared resources.
     */
    @BeforeAll // JUnit runs this once before any test method in this class.
    static void beforeAllTests() {
        System.out.println("\uD83E\uDDFF Starting LibraryCatalogManager Tests...  ");
    }

    /**
     * Executed before each individual test method.
     * Useful for fresh object creation or resetting state.
     */
    @BeforeEach
    void setUp() {
        catalog = new LibraryCatalogManager();

        catalog.addGenre("Science");
        catalog.addGenre("Fiction");
        catalog.addGenre("History");
        System.out.println("\uD83D\uDD38 New Setup: create a new instance.");

    }

    /**
     * Executed after each test method completes.
     *
     * @param testInfo provides metadata such as the test display name
     */
    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("✔\uFE0FTest Passed: " + testInfo.getDisplayName() +  " (Test Name)");
    }

    /**
     * Executed once after all test methods in this class.
     * Useful for cleanup of shared resources.
     */
    @AfterAll
    static void afterAllTests() {
        System.out.println("✅  LibraryCatalogManager Tests Done");
    }


    // -----------------------------------------------------
    // TESTS
    // -----------------------------------------------------

    @Test
    @DisplayName("'Add and Search Genre' Test")
    void testAddGenreAndSearchGenre() {
        LibraryCatalogManager.GenreNode genre = catalog.searchGenre("Fiction");
        assertNotNull(genre);
        assertEquals("Fiction", genre.genreName);

        LibraryCatalogManager.GenreNode missingGenre = catalog.searchGenre("Fantasy");
        assertNull(missingGenre);
    }

//    @Test
//    @DisplayName("'Add Book To Existing Genre' Test")
//    void testAddBookToExistingGenre() {
//        catalog.addBookToAuthorList("Science", "Stephen Hawking", "A Brief History of Time");
//
//        LibraryCatalogManager.GenreNode genre = catalog.searchGenre("Science");
//        assertNotNull(genre);
//
//        TreeMap<String, List<String>> books = genre.booksByAuthor;
//        assertTrue(books.containsKey("Stephen Hawking"));
//        assertEquals(1, books.get("Stephen Hawking").size());
//        assertEquals("A Brief History of Time", books.get("Stephen Hawking").get(0));
//    }

    @Test
    @DisplayName("'Attempting to Add Book To  a Missing Genre' Test")
    void testAddBookToNonExistingGenre() {
        catalog.addBookToAuthorList("Fantasy", "J.R.R. Tolkien", "The Hobbit");

        LibraryCatalogManager.GenreNode genre = catalog.searchGenre("Fantasy");
        assertNull(genre);  // Genre wasn't added, so it should still be null
    }

//
//    @Test
//    @DisplayName("'Add Multiple Books Same Author' Test")
//    void testAddMultipleBooksSameAuthor() {
//        catalog.addBookToAuthorList("Fiction", "George Orwell", "1984");
//        catalog.addBookToAuthorList("Fiction", "George Orwell", "Animal Farm");
//
//        LibraryCatalogManager.GenreNode genre = catalog.searchGenre("Fiction");
//        assertNotNull(genre);
//
//        List<String> orwellBooks = genre.booksByAuthor.get("George Orwell");
//        assertEquals(2, orwellBooks.size());
//        assertTrue(orwellBooks.contains("1984"));
//        assertTrue(orwellBooks.contains("Animal Farm"));
//    }

}
