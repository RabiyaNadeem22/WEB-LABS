import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.ArrayList;




class Book {
    private String title;
    private String author;
    private String ISBN;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}


public class BookServlet extends HttpServlet {
    private ArrayList<Book> bookCollection;

    @Override
    public void init() throws ServletException {
        bookCollection = new ArrayList<>();
        bookCollection.add(new Book("Java how to program", "Deitel", "9780136053064"));
        bookCollection.add(new Book("Head First C#", "Andrew Stellman", "9781491976708"));
        bookCollection.add(new Book("C#", "Svetlin Nakov", "9789544007737"));
    }

    @Override    
public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Book Collection</title></head><body>");
        out.println("<h1>Book Collection</h1>");

        out.println("<table border=\"1\">");
        out.println("<tr><th>Title</th><th>Author</th><th>ISBN</th></tr>");
        for (Book book : bookCollection) {
            out.println("<tr>");
            out.println("<td>" + book.getTitle() + "</td>");
            out.println("<td>" + book.getAuthor() + "</td>");
            out.println("<td>" + book.getISBN() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");

        out.println("</body></html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("create")) {
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                String isbn = request.getParameter("isbn");

                Book newBook = new Book(title, author, isbn);
                bookCollection.add(newBook);
            } else if (action.equals("update")) {
                String isbn = request.getParameter("isbn");
                String newTitle = request.getParameter("newTitle");
                String newAuthor = request.getParameter("newAuthor");

                for (Book book : bookCollection) {
                    if (book.getISBN().equals(isbn)) {
                        book.setTitle(newTitle);
                        book.setAuthor(newAuthor);
                        break;
                    }
                }
            } else if (action.equals("delete")) {
                String isbn = request.getParameter("isbn");

                bookCollection.removeIf(book -> book.getISBN().equals(isbn));
            }
        }

        response.sendRedirect(request.getContextPath() + "/books");
    }
}