package org.library;

/** ***********************************************************************+
* Package Name          :org.library       
* Author                :ochwada               
* Name of the Project   :LibraryCatalogManager       
* Date                  :Friday,09. May.2025 at 14:22
* Description           :
* Objective             :
/** ***********************************************************************+
*/
public class App {
    public static void main(String[] args) {
        LibraryCatalogManager catalogManager = new LibraryCatalogManager();

        // add Genre
        catalogManager.addGenre("History");
        catalogManager.addGenre("Science");
        catalogManager.addGenre("Fiction");
        catalogManager.addGenre("Contemporary Issues");

        // Add books to Genre
        catalogManager.addBookToAuthorList("Fiction", "J.K Rowling", "Harry Potter and the Chamber of Secrets");
        catalogManager.addBookToAuthorList("Fiction", "J.K Rowling", "Harry Potter and the Prisoner of Azkaban");
        catalogManager.addBookToAuthorList("Fiction", "George Orwell", "1984");
        catalogManager.addBookToAuthorList("Fiction", "George Orwell", "Animal Farm");
        catalogManager.addBookToAuthorList("History", "Yuval Harari", "Sapiens");
        catalogManager.addBookToAuthorList("Contemporary Issues", "Yuval Harari", "21 Lessons for the 21st Century");
        catalogManager.addBookToAuthorList("Science", "Stephen Hawking", "The Universe in a Nutshell");
        catalogManager.addBookToAuthorList("Science", "Stephen Hawking", "Black Holes and Baby Universes");
        catalogManager.addBookToAuthorList("Science", "Stephen Hawking", "Brief Answers to the Big Questions");


        // List all books in all genres (sorted by folder names)
        System.out.println("\n \uD83D\uDCDA Listing all Books by Authors\n");
        catalogManager.listAllBooks();

    }

}

