package com.fpt.edu.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpt.edu.dao.MovieDao;
import com.fpt.edu.dao.RoomDao;
import com.fpt.edu.dao.ShowTimeDao;
import com.fpt.edu.dao.TicketDao;
import com.fpt.edu.entity.Room;
import com.fpt.edu.entity.Ticket;

/**
 * Servlet implementation class TicketCreate
 */
@WebServlet("/TicketCreate")
public class TicketCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    RoomDao roomDao;
    MovieDao movieDao;
    ShowTimeDao showTimeDao;
    TicketDao ticketDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketCreate() {
        super();
        // TODO Auto-generated constructor stub
        roomDao= new RoomDao();
        movieDao = new MovieDao();
        showTimeDao = new ShowTimeDao();
        ticketDao = new TicketDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("rooms", roomDao.findAllGroupByName());
		request.setAttribute("movies", movieDao.findAll());
		request.setAttribute("showtimes", showTimeDao.findAll());
		request.getRequestDispatcher("TicketCreate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		int idRoom = Integer.valueOf(request.getParameter("idRoom"));
		int idMovie = Integer.valueOf(request.getParameter("idMovie"));
		int idShowTime = Integer.valueOf(request.getParameter("idShowTime"));
		double price =  Double.valueOf(request.getParameter("price"));
		
		Ticket ticket = new Ticket(idShowTime,price);
		Room room = roomDao.findById(idRoom);
		
		try {
			for (int i = 0; i < room.getNum(); i++) {
				ticketDao.save(idRoom, idMovie, ticket);
			}
			response.getWriter().append("Create ticket success: ");	
			
		} catch (Exception e) {
			response.getWriter().append("Create ticket false: ");
		}
	}

}
