package org.library;

/**
 * **********************************************************************+
 * Package Name          :org.library
 * Author                :ochwada
 * Name of the Project   :LibraryCatalogManager
 * Date                  :Friday,09. May.2025 at 14:25
 * Description           :Building a Library Catalog System where
 *  *                       Each genre (e.g., Fiction, History, Science) is stored in a Binary Tree.
 *  *                       Each genre node contains books sorted by author name using a TreeMap.
 *  *                       You must support adding genres, adding books to a genre, and printing all books in alphabetical
 *  *                              order by genre and then by author.
 * Objective             :Build a structured Library Catalog System using a Binary Tree for genre categorization and a TreeMap
 *                        for author-based book sorting within each genre, enabling efficient insertion and alphabetical retrieval of library data.
 * /** ***********************************************************************+
 */
public class LibraryCatalogManager {


    static class GenreNode{ // FolderNode
        // Genre name
        String genreName;

        // Left and right child genre folders (subfolders) in the binary tree (BST links)
        GenreNode left, right;



    }

}
