import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Check if the user exists in the authentication table
        if (authenticationTable.containsKey(email) && authenticationTable.get(email).equals(password)) {
            UserProfile userProfile = profileTable.get(email);

            HttpSession session = request.getSession();
            session.setAttribute("userProfile", userProfile);

            if (userProfile.getUserType() == 1) {
                response.sendRedirect("student_dashboard");
            } else if (userProfile.getUserType() == 2) {
                response.sendRedirect("teacher_dashboard");
            }
        } else {
            request.setAttribute("error", "Invalid email or password.");
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }
}