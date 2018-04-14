/*
 * Name: Michal Drahorat, Brody Gartner
 * Description: The Geographic Area Data Servlet
 * Date: February 11th, 2018
 */

package prog3060.bgmd.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prog3060.bgmd.beans.ConnectionBean;
import prog3060.bgmd.beans.EntityManagerFactoryListener;
import prog3060.bgmd.entities.CensusYear;
import prog3060.bgmd.entities.GeographicArea;
import prog3060.bgmd.beans.TotalIncomeBeanLocal;

/**
 * Servlet implementation class GeographicAreaServlet
 */
@WebServlet(name = "GeographicAreas", urlPatterns = { "/GeographicArea" })
public class GeographicAreaServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() { 
		
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("username");
		String pass = (String) session.getAttribute("password");
		ConnectionBean cb = (ConnectionBean) session.getAttribute("connectionbean");
		if(ConnectionBean.isConnected()){
			try {
				List<GeographicArea> areas = cb.getAllGeoAreas(user, pass);
				request.setAttribute("areas", areas);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("./geographicareas.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("./login.jsp").forward(request, response);
		}
	} 
	
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }

}
