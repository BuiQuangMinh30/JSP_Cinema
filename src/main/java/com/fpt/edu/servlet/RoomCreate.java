package com.fpt.edu.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpt.edu.dao.RoomDao;
import com.fpt.edu.dao.TypeRoomDao;
import com.fpt.edu.entity.Movie;
import com.fpt.edu.entity.Room;


/**
 * Servlet implementation class RoomCreate
 */
@WebServlet("/RoomCreate")
public class RoomCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RoomDao roomDao;
	TypeRoomDao typeRoomDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomCreate() {
        super();
        // TODO Auto-generated constructor stub
        roomDao = new RoomDao();
        typeRoomDao = new TypeRoomDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("typeRooms", typeRoomDao.findAll());
		
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("RoomCreate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name =  request.getParameter("name");
		int rowRoom =  Integer.valueOf(request.getParameter("rowRoom"));
		int columnRoom =  Integer.valueOf(request.getParameter("columnRoom"));
		int idTypeRoom = Integer.valueOf(request.getParameter("idTypeRoom"));
		
		try {
			for (int i = 1; i <= rowRoom; i++) {
				for (int j = 1; j <= columnRoom; j++) {
//					Room room = new Room(name,name+i+j,i,j,idTypeRoom); 	
					roomDao.save(room);
				}
			}
			response.getWriter().append("Create room success: ");
		} catch (Exception e) {
			response.getWriter().append("Create room false: ");
		}
	}

}
