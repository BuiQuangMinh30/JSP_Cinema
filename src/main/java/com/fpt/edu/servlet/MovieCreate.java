package com.fpt.edu.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpt.edu.dao.MovieDao;
import com.fpt.edu.dao.TypeMovieDao;
import com.fpt.edu.entity.Movie;

/**
 * Servlet implementation class create
 */
@WebServlet("/MovieCreate")
public class MovieCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieDao movieDao;
	TypeMovieDao typeMovieDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieCreate() {
        super();
        // TODO Auto-generated constructor stub
        movieDao = new MovieDao();
        typeMovieDao = new TypeMovieDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("typeMovies", typeMovieDao.findAll());
		
		request.getRequestDispatcher("MovieCreate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		int year =  Integer.valueOf(request.getParameter("year"));
		int idTypeMovie = Integer.valueOf(request.getParameter("idTypeMovie"));
		String description = request.getParameter("description");

		LocalDateTime startTime =  LocalDateTime.parse(request.getParameter("startTime"));
		LocalDateTime endTime = LocalDateTime.parse(request.getParameter("endTime"));
		Movie movie = new Movie(name,year,idTypeMovie,description,startTime,endTime); 
		
		if(movieDao.save(movie)) {
			response.getWriter().append("Create movie success: ");
		} else {
			response.getWriter().append("Create movie false: ");
		}
	}

}
