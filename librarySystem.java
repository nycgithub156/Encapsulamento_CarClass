class BookClass {
    private String isbn;
    private String title;
    private String author;
    private int yearPublication;
    private boolean isBorrowed;

    public BookClass(String isbn, String title, String author, int yearPublication) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearPublication = yearPublication;
        this.isBorrowed = false;
    } 

    public BookClass(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public void lend() {
        if (isBorrowed == false) {
            isBorrowed = true;
        } else {
            System.out.println("This book is already borrowed.");
        }
    }

    public void giveBack() {
        if (isBorrowed == true) {
            isBorrowed = false;
        } else {
            System.out.println("This book has already been returned.");
        }
    }

    public boolean isAvailable() {
        if (isBorrowed == false) {
            return true;
        } else {
            return false;
        }
    }

    public void infoBook() {
        System.out.println("===== Book Informations =====");
        System.out.println("[ISBN: " + isbn + "]");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + yearPublication);
        System.out.println("Status: " + (isAvailable() ? "Available" : "Borrowed"));
        System.out.println("============================");
    }
}

class UserClass {
    private String id;
    private String name;
    private BookClass borrowedBook;

    public UserClass(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean borrow(BookClass book) {
        if(book == null) {
            System.out.println("There is no this book.");
            return false;
        }
        
        if(this.borrowedBook != null) {
            System.out.println("User already have a borrowed book");
            return false;
        }
        
        if(!book.isAvailable()) {
            System.out.println("Book unavailable");
            return false;
        }
        
        this.borrowedBook = book;
        book.lend();
        System.out.println(name + " pegou emprestado: " + book.getTitle());
        return true;
    }

    public boolean giveBack() {
        if (this.borrowedBook == null) {
            System.out.println("Erro: " + this.name + " have no book to give back");
            return false;
        }
        
        if (!this.borrowedBook.getIsBorrowed()) {
            System.out.println("Erro: the book " + this.borrowedBook.getTitle() + " was already available");
            return false;
        }
        
        BookClass bookToReturn = this.borrowedBook;
        this.borrowedBook = null; 
        bookToReturn.giveBack(); 
        
        System.out.println(this.name + " devolveu o livro: " + bookToReturn.getTitle());
        return true;
    }

    public void infoUser() {
        System.out.println("=====User Info=====");
        System.out.println("[ID:" + id + "]");
        System.out.println("Name: " + name);
        System.out.println("-- Book Borrowed Info --");
        if (this.borrowedBook != null) {
            System.out.println("Title: " + borrowedBook.getTitle());
            System.out.println("Author: " + borrowedBook.getAuthor());
            System.out.println("ISBN: " + borrowedBook.getIsbn());
            System.out.println("Status: Borrowed");
        } else {
            System.out.println("No books currently borrowed");
        }
        System.out.println("====================");
    }
}

public class librarySystem {
    public static void main(String[] args) {
        BookClass stBook = new BookClass("1236477", "A metamorfose", "Franz Kafka");
        BookClass ndBook = new BookClass("4467810", "Memórias póstumas de Brás Cubas", "Machado de Assis");
        BookClass rdBook = new BookClass("7893348", "Animal Farm", "George Orwell", 1945);

        UserClass stUser = new UserClass("300", "Jorge Henrique Nogueira Santos");
        UserClass ndUser = new UserClass("301", "Carlos James August");

        stBook.infoBook();
        ndBook.infoBook();
        rdBook.infoBook();

        stUser.infoUser();
        stUser.borrow(ndBook);
        stUser.infoUser();

        ndUser.infoUser();
        ndUser.borrow(stBook);
        ndUser.infoUser();

    }
}