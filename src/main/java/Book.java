import java.util.Objects;

/*
 * Denna klass ska förberedas för att kunna användas som nyckel i en hashtabell.
 * Du får göra nödvändiga ändringar även i klasserna MyString och ISBN10.
 *
 * Hashkoden ska räknas ut på ett effektivt sätt och följa de regler och
 * rekommendationer som finns för hur en hashkod ska konstrueras. Notera i en
 * kommentar i koden hur du har tänkt när du konstruerat din hashkod.
 */
public class Book {
    private MyString title;
    private MyString author;
    private ISBN10 isbn;
    private MyString content;
    private int price;

    public Book(String title, String author, String isbn, String content, int price) {
        this.title = new MyString(title);
        this.author = new MyString(author);
        this.isbn = new ISBN10(isbn);
        this.content = new MyString(content);
        this.price = price;
    }

    public MyString getTitle() {
        return title;
    }

    public MyString getAuthor() {
        return author;
    }

    public ISBN10 getIsbn() {
        return isbn;
    }

    public MyString getContent() {
        return content;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    // hash koden är baserad på ISBN kod eftersom det är ett unikt till en bok.
    // Övriga attributer såsom titel t.ex kan vara att det finns andra böcker med samma titel
    // eller samma författare osv.

    @Override
    public boolean equals(Object o) {
        return o instanceof Book && isbn.toString().equals(((Book)o).getIsbn().toString());
    }

    @Override
    public int hashCode() {
        int hashVal = 0;
        for (int i = 0; i < isbn.toString().length(); i++)
            hashVal = 37 * hashVal + isbn.toString().charAt(i);
        return hashVal;
    }








    @Override
    public String toString() {
        return String.format("\"%s\" by %s Price: %d ISBN: %s lenght: %s", title, author, price, isbn,
                content.length());
    }

}
