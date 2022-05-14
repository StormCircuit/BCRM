package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import hibernate.entity.*;
import hibernate.controller.*;

/**
 * Servlet implementation class RegisterControl
 */
@WebServlet("/confirmation")
public class RegisterControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterControl() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		
		String[] values = request.getParameterValues("activities");
		if (values != null) {
			out.println("<h2>Billy Bronco - Thank you for your purchase!</h2>");
			out.println("<h3>Confirmation sent to bbronco@cpp.edu</h3>");
			out.println("<h3>Your selected activities:</h3>");
			
			out.println("<style>\n"
					+ ".center{\n"
					+ "  margin: 0;\n"
					+ "  position: absolute;\n"
					+ "  top: 30%;\n"
					+ "  left: 0.5%;\n"
					+ "  -ms-transform: translate(0%, 0%);\n"
					+ "  transform: translate(0%, 0%);\n"
					+ "}\n"
					+ ".column {\n"
					+ "  float: left;\n"
					+ "  width: 15%;\n"
					+ "}"
					+ "</style>");
			
			out.println("<div class=\"column\">");
			for(int i=0; i < values.length; i++) {
				 out.println("&emsp;&emsp;" + values[i] + "<br>");
			}
			out.println("</div>");
			
			out.println("<div class=\"column\">");
			for(int i=0; i < values.length; i++) {
				 out.println("$9.99<br>");
			}
			out.println("</div>");
			
			double subtotal = 9.99 * values.length;
			double total = subtotal - (subtotal * 0.2);
			
			out.println("<div class=\"center\">");
			out.printf("<h3>Total: &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp; $%.2f </h3>", total);
			out.println("</div>");
						
			DatabaseController db = new DatabaseController();
			
			db.CreateStudent(123456789, "bbronco", "123", "Billy Bronco", 
					"01/01/1999", "(909) 646-4098", "3801 W Temple Ave",
					"09/01/2019", "05/23/2023", "Computer Science", "none");
			
			Calendar c = Calendar.getInstance();
			Date date = c.getTime();
			
			Order order = new Order();
			
			for (int i=0; i< values.length; i++)
			{
				Activity activity = new Activity(values[i], 9.99);
				order.addProduct(activity);
			}
			
			
			List<Activity> items = order.getItems();
			db.CreateOrder(date, "online-pending", 123456789, items);
		}
		
		out.print("</body></html>");
		
		out.close();
				
	}

}
