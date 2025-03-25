import java.util.ArrayList;
import java.util.Objects;

public class Library {

    private ArrayList<Book> books;
    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(Book book) throws InvalidBookException{
        if (Objects.isNull(book))
            throw new InvalidBookException("Book should not be null.");
        books.add(book);
    }
    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    public void borrowBook(String title) throws BookNotFoundException, EmptyLibraryException {
        if (books.isEmpty()) {
            throw new EmptyLibraryException("Library is empty, no books to borrow");
        }
        if (Objects.isNull(findBook(title))) {
            throw new BookNotFoundException("Book with title " + title + " not found.");
        }
        System.out.println(title + " borrowed successfully from the library.");
    }
    public void returnBook(String title)throws BookNotFoundException {
        for (Book book : books) {
            if (Objects.equals(findBook(title), book.getTitle())) {
                System.out.println(title + " returned successfully from the library.");
                return;
            }
        }
        throw new BookNotFoundException("Book wih title " + title + "not found, Cannot return.");
    }
    public void listBooks() throws EmptyLibraryException {
        if (books.isEmpty())
            throw new EmptyLibraryException("Library is empty.");
        System.out.println("Books in the library :");
        for (Book book : books)
            System.out.println(book.toString());
    }
}