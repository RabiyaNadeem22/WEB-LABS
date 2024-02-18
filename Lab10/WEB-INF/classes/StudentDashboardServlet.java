import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/student_dashboard")
public class StudentDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserProfile userProfile = (UserProfile) session.getAttribute("userProfile");

        if (userProfile != null && userProfile.getUserType() == 1) {
            request.setAttribute("userProfile", userProfile);
            request.getRequestDispatcher("student_dashboard.html").forward(request, response);
        } else {
            response.sendRedirect("login.html");
        }
    }
}