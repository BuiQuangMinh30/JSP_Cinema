package com.fpt.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fpt.edu.entity.MovieDetail;
import com.fpt.edu.entity.Ticket;
import com.fpt.edu.entity.TicketDashBoadTop;




public class TicketDao {
	public List<Ticket> findAll() {
		List<Ticket> listAll = new ArrayList<>();
		String query = "SELECT * FROM tickets";
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()){
                int id = rs.getInt("id");
                int idMovieDetail = rs.getInt("idMovieDetail");
                int idShowTime = rs.getInt("idShowTime");
                double price = rs.getDouble("price");
                int status = rs.getInt("status");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                Ticket obj = new Ticket(id,idMovieDetail,idShowTime,price,status,createdAt);
                listAll.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAll;
	}
	
	public List<TicketDashBoadTop> findAllTopMovieByCreate(String start, String end) {
		List<TicketDashBoadTop> listAll = new ArrayList<>();
		String query = String.format("SELECT movies.name, TopMovieDay.num\r\n"
				+ "FROM movies JOIN (SELECT movie_details.idMovie, COUNT(movie_details.id) AS num FROM `tickets` JOIN `movie_details` ON tickets.idMovieDetail = movie_details.id\r\n"
				+ "WHERE tickets.status = 2 AND tickets.createdAt BETWEEN '%s 00:00:00' AND '%s 00:00:00'\r\n"
				+ "GROUP BY movie_details.idMovie\r\n"
				+ "ORDER BY num DESC) as TopMovieDay ON movies.id = TopMovieDay.idMovie "
				+ "ORDER BY TopMovieDay.num DESC",start,end);
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()){
                String name = rs.getString("name");
                int num = rs.getInt("num");
                TicketDashBoadTop obj = new TicketDashBoadTop(name,num);
                listAll.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAll;
	}
	
	public List<TicketDashBoadTop> findAllTopShowTime() {
		List<TicketDashBoadTop> listAll = new ArrayList<>();
		String query = String.format("SELECT showtimes.name, COUNT(tickets.idShowTime) as countShowTime\r\n"
				+ "FROM tickets JOIN showtimes ON tickets.id = showtimes.id\r\n"
				+ "GROUP BY tickets.idShowTime\r\n"
				+ "ORDER By countShowTime DESC");
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()){
                String name = rs.getString("name");
                int num = rs.getInt("countShowTime");
                TicketDashBoadTop obj = new TicketDashBoadTop(name,num);
                listAll.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAll;
	}
	
	public Ticket findById(int idTicket) {
		Ticket ticket = null;
		String query = String.format("SELECT * FROM `tickets` Where id = %d",idTicket);
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()){
				int id = rs.getInt("id");
                int idMovieDetail = rs.getInt("idMovieDetail");
                int idShowTime = rs.getInt("idShowTime");
                double price = rs.getDouble("price");
                int status = rs.getInt("status");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                ticket = new Ticket(id,idMovieDetail,idShowTime,price,status,createdAt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
	}
	
	public boolean buyTicket(int ticketId) {
		String query = String.format("update tickets set status = 2 where id = %d", ticketId);
		try {
			Connection cnn = UserDao.getConnection();
			if (cnn == null){
                throw new SQLException("Can't open connection!");
            }
			PreparedStatement preparedStatement = cnn.prepareStatement(query);
			    
            if(preparedStatement.executeUpdate()>0) {
            	return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}
	
	public boolean save(int idRoom,int idMovie,Ticket obj) {
		String query1 = "INSERT INTO movie_details (idRoom,idMovie) VALUES (?,?)";
		String query2 = "INSERT INTO tickets (idMovieDetail,idShowTime,price,createdAt) VALUES (?,?,?,?)";
		try {
			Connection cnn = UserDao.getConnection();
            if (cnn == null){
                return false;
            }
            PreparedStatement preparedStatement = cnn.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, idRoom);
            preparedStatement.setInt(2, idMovie);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            int idMovieDetail = 0;
            if (rs.next()){
                idMovieDetail = rs.getInt(1);
            }
            
			PreparedStatement preparedStatement2 = cnn.prepareStatement(query2);
            preparedStatement2.setInt(1, idMovieDetail);
            preparedStatement2.setInt(2, obj.getIdShowTime());
            preparedStatement2.setDouble(3, obj.getPrice());
            preparedStatement2.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			if(preparedStatement2.executeUpdate()>0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
