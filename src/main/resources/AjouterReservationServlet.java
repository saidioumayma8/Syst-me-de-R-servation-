import java.util.Date;
import java.text.SimpleDateFormat;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/reservation/controller/AjouterReservationServlet")
public class AjouterReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String patientName = request.getParameter("PatientName");
        String patientPhone = request.getParameter("PatientPhone");
        int patientID = -1;

        try (Connection connection = DatabaseConnection.getConnection()) {
            PatientDAO patientDAO = new PatientDAO(connection);
            ReservationDAO reservationDAO = new ReservationDAO(connection);

            if (patientName != null && !patientName.isEmpty()) {
                patientID = patientDAO.ajouterPatient(patientName, patientPhone);
            } else {
                patientID = Integer.parseInt(request.getParameter("PatientID"));
            }

            int MedID = 1; // 🔹 Fixed MedID
            String Status = request.getParameter("Status");
            String Motif = request.getParameter("Motif");

            // Get dateReservation from form OR use today's date
            String dateString = request.getParameter("dateReservation");
            Date dateReservation;
            if (dateString != null && !dateString.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                dateReservation = sdf.parse(dateString);
            } else {
                dateReservation = new Date(); // 🔹 Default to today
            }

            Reservation reservation = new Reservation(patientID, Status, Motif, dateReservation);
            reservationDAO.ajouterReservation(reservation, MedID);

            response.sendRedirect("liste-reservations.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}

