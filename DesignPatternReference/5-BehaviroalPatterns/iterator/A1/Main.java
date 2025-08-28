package iterator.A1;

import java.util.Iterator;
import iterator.A1.Book;
import iterator.A1.BookShelf;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.apendBook(new Book("Around the World in 80 Days"));
        bookShelf.apendBook(new Book("Bible"));
        bookShelf.apendBook(new Book("Cinderella"));
        bookShelf.apendBook(new Book("Daddy-Long-Legs"));

        Iterator<Book> it = bookShelf.iterator();

        // Explicitly using iterator
        while(it.hasNext()){
            Book book = it.next();
            System.out.println(book.getName());
        }
        System.out.println();

        // Enhanced for-each loop
        for (Book book: bookShelf){
            System.out.println(book.getName());
        }
        System.out.println();
    }

}