package org.library;


import java.util.*;

/**
 * **********************************************************************+
 * Package Name          :org.library
 * Author                :ochwada
 * Name of the Project   :LibraryCatalogManager
 * Date                  :Friday,09. May.2025 at 14:25
 * Description           :Building a Library Catalog System where
 * *                       Each genre (e.g., Fiction, History, Science) is stored in a Binary Tree.
 * *                       Each genre node contains books sorted by author name using a TreeMap.
 * *                       You must support adding genres, adding books to a genre, and printing all books in alphabetical
 * *                      order by genre and then by author.
 * Objective             :Build a structured Library Catalog System using a Binary Tree for genre categorization and a TreeMap
 * for author-based book sorting within each genre, enabling efficient insertion and alphabetical retrieval of library data.
 * /** ***********************************************************************+
 */
public class LibraryCatalogManager {

    // --------------------------------Nested Class -----------------------------

    /**
     * Represents a genre in the catalog.
     * Acts as a node in the Binary Search Tree (BST).
     */
    static class GenreNode { // FolderNode

        /**
         * Name of the genre (e.g., Fiction, History, Science)
         */
        String genreName;

        /**
         * Left and right child genre folders (subfolders) in the binary tree (BST links)
         */
        GenreNode left;
        GenreNode right;

        /**
         * Stores books grouped and sorted by author name.
         * Each key is an author's name, and the value is a list of book titles by that author.
         * TreeMap ensures author names are kept in alphabetical order.
         */
        //TreeMap<String, List<String>> booksByAuthor;
        Map<String, Set<String>> booksByAuthor = new HashMap<>();

        /**
         * Constructs a new Genre folder with the given name and initializes the book storage map.
         *
         * @param genreName the name of the genre
         */
        public GenreNode(String genreName) {
            this.genreName = genreName;
            this.booksByAuthor = new TreeMap<>();
            this.left = null;
            this.right = null;
        }

        /**
         * Adds a new book to the genre folder under the specified author.
         * <p>
         * If the author does not already exist in the map, a new entry is created
         * with the author's name and an empty list, which the book is then added to.
         *
         * @param author the name of the author
         * @param book   the title of the book to add
         */
        public void addBook(String author, String book) {
            // Ensure the author has a book list
            //booksByAuthor.putIfAbsent(author, new ArrayList<>());
            booksByAuthor.computeIfAbsent(author, key -> new TreeSet<>()).add(book);


            // Add the new book to the List
            booksByAuthor.get(author).add(book);
        }

        /**
         * Prints all books in the genre, grouped by author.
         * <p>
         * The output is organized as follows:
         * <ul>
         *   <li>Genre name (folder title) as a header</li>
         *   <li>List of authors and their corresponding books</li>
         *   <li>If no books are available, a message indicating the folder is empty is displayed</li>
         * </ul>
         */
        public void printBooksGroupedByAuthor() {
            System.out.println("==== \uD83D\uDCDA " + genreName + " Genre ==== ");

            if (booksByAuthor.isEmpty()) {
                System.out.println(" (No books yet)");
            }

            this.booksByAuthor.forEach(
                    (author, books) -> {
                        System.out.println("Books by \uD83D\uDC64 " + author);
                        books.forEach(book -> System.out.println(" -" + book));
                    }
            );
            System.out.println();
        }

    }
    // ----------------------------------------------------------------------------------
    // ----------------------------------------------------------------------------------
    /**
     * The root node of the binary search tree (BST) representing the top-level genre folder.
     * All genres are organized beneath this node in alphabetical order.
     * <p>
     * Each GenreNode represents a genre section in the library
     * It holds books organized by authors using a TreeMap
     */
    private GenreNode root;

    public void addGenre(String genreName) {
        root = insertGenre(root, genreName);
    }

    /**
     * Recursively inserts a new genre folder into the catalog's binary search tree (BST).
     * <p>
     * Genres are inserted based on alphabetical order to maintain the BST structure.
     *
     * @param node      the current node in the BST traversal
     * @param genreName the name of the genre to insert
     * @return the updated GenreNode after insertion
     */
    private GenreNode insertGenre(GenreNode node, String genreName) {

        if (node == null) {
            return new GenreNode(genreName);
        }

        if (genreName.compareTo(node.genreName) < 0) {
            node.left = insertGenre(node.left, genreName);
        } else {
            node.right = insertGenre(node.right, genreName);
        }
        return node;

    }

    /**
     * Searches the catalog for a genre folder with the given name.
     *
     * @param genreName the name of the genre to search for
     * @return the {@code GenreNode} if found, or {@code null} if not present in the catalog
     */
    public GenreNode searchGenre(String genreName) {
        return searchGenreRecursively(root, genreName);
    }

    /**
     * Recursively searches the binary search tree for a genre folder with the specified name.
     *
     * @param node      the current node being checked in the BST
     * @param genreName the name of the genre to search for
     * @return the {@code GenreNode} if found; otherwise, {@code null}
     */
    private GenreNode searchGenreRecursively(GenreNode node, String genreName) {
        if (node == null) {
            return null;
        }

        if (genreName.equals(node.genreName)) {
            return node;
        }
        if (genreName.compareTo(node.genreName) < 0) {
            return searchGenreRecursively(node.left, genreName);
        } else {
            return searchGenreRecursively(node.right, genreName);
        }
    }

    /**
     * Adds a book to the author's list under the specified genre.
     *
     * @param genreName the name of the genre to search for
     * @param author the author's name to which the book should be added
     * @param book the title of the book to be added
     *
     * If the genre is found in the tree, the book is added to the corresponding author's list.
     * If the genre does not exist, an error message is printed to the console.
     */
    public  void addBookToAuthorList(String genreName, String author, String book ){
        GenreNode genre = searchGenre(genreName);

        if (genre !=null){
            genre.addBook(author, book);
        }else {
            System.out.println("❗Genre \"" + genreName + "\" not found. Book not added.");
        }
    }


    /**
     * Lists all books in the system, grouped by genre and then by author.
     *
     * This method traverses the genre tree in-order and prints books grouped by author
     * for each genre using {@code printBooksGroupedByAuthor()} in each GenreNode.
     */
    public void listAllBooks(){
        listAllBooksInOrder(root);
    }

    /**
     * Recursively traverses the genre binary tree in in-order fashion
     * to print books grouped by author for each genre node.
     *
     * @param node the current GenreNode in the traversal
     *
     * This is a private utility used by {@code listAllBooks()} to ensure sorted genre output.
     */
    private void listAllBooksInOrder(GenreNode node){
        if (node == null) return;

        listAllBooksInOrder(node.left);
        node.printBooksGroupedByAuthor();
        listAllBooksInOrder(node.right);
    }



}
