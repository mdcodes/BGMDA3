package prog3060.bgmd.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prog3060.bgmd.beans.ConnectionBean;
import prog3060.bgmd.beans.TotalIncomeBeanLocal;
import prog3060.bgmd.entities.CensusYear;
import prog3060.bgmd.entities.GeographicArea;
import prog3060.bgmd.entities.Household;

/**
 * Servlet implementation class HouseholdServlet
 */
@WebServlet("/HouseholdData")
public class HouseholdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	TotalIncomeBeanLocal totalIncomeBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouseholdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("username");
		String pass = (String) session.getAttribute("password");
		ConnectionBean cb = (ConnectionBean) session.getAttribute("connectionbean");
		if(ConnectionBean.isConnected()) {
			
			try {
				List<Household> list = cb.getHouseholdData(user, pass);
				request.setAttribute("houseData", list);
				request.getRequestDispatcher("./household.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			request.getRequestDispatcher("./login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
