package com.fpt.edu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpt.edu.dao.TicketDao;

/**
 * Servlet implementation class TicketDashBoadTopMovie
 */
@WebServlet("/TicketDashBoadTopMovie")
public class TicketDashBoadTopMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TicketDao ticketDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketDashBoadTopMovie() {
        super();
        // TODO Auto-generated constructor stub
        ticketDao = new TicketDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		
		if(start == null || end == null) {
			response.getWriter().append("yêu cầu nhập parameter ngày start và end");
		} else {
			request.setAttribute("topMovies", ticketDao.findAllTopMovieByCreate(start,end));
			request.getRequestDispatcher("TicketListTopMovie.jsp").forward(request, response);
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
