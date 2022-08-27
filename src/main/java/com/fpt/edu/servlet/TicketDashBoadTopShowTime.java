package com.fpt.edu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpt.edu.dao.TicketDao;

/**
 * Servlet implementation class TicketDashBoadTopShowTime
 */
@WebServlet("/TicketDashBoadTopShowTime")
public class TicketDashBoadTopShowTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TicketDao ticketDao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketDashBoadTopShowTime() {
        super();
        // TODO Auto-generated constructor stub
        ticketDao = new TicketDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("topShowTimes", ticketDao.findAllTopShowTime());
		request.getRequestDispatcher("TicketListTop.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
