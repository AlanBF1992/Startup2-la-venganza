package cl.praxis.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.model.connection.Conexion;
import cl.praxis.model.dto.User;

public class UserDAO {

	public boolean create(User u) {
		try {
			if (read().stream().filter(x -> x.getCorreo() == u.getCorreo()).findAny().orElse(null) == null) {
				return false;
			}
			
			Connection c = Conexion.getConnection();
			
			//Quedaría mejor con un prepared statement
			Statement s = c.createStatement();
			
			
			LocalDateTime dt = LocalDateTime.now();

			String query =
					"INSERT INTO public.startup_user (correo, created_at, nick, nombre, password, peso, updated_at)"
					+ " VALUES ('"
					+ u.getCorreo() + "','"
					+ dt + "','"
					+ u.getNick() + "','"
					+ u.getNombre() + "','"
					+ u.getPassword() + "','"
					+ u.getPeso() + "','"
					+ dt  + "')";

			s.execute(query);
			return true;
			
		} catch (SQLException ex){
			System.out.println("Error en método create()");
			ex.printStackTrace();
			return false;
		}
	}
	
	public User read(String correo, String password) {		
		List<User> usuarios = read();
		User usuario = usuarios.stream().filter(x -> x.getCorreo().equalsIgnoreCase(correo) && x.getPassword().equalsIgnoreCase(password)).findAny().orElse(null);
		return usuario;
	}
	
	public User read(String correo) {		
		List<User> usuarios = read();
		User usuario = usuarios.stream().filter(x -> x.getCorreo().equalsIgnoreCase(correo)).findAny().orElse(null);
		return usuario;
	}
	
	public List<User> read() {
		List<User> usuarios = new ArrayList<User>();
		
		try {
			Connection c = Conexion.getConnection();
			
			Statement s = c.createStatement();
			String query = "SELECT id, correo, nick, nombre, password, peso FROM public.startup_user";
			
			ResultSet rs = s.executeQuery(query);
			
			while (rs.next()) {
				usuarios.add(new User(
						rs.getInt("id"),
						rs.getString("correo"),
						rs.getString("nombre"),
						rs.getString("nick"),
						rs.getString("password"),
						rs.getString("peso")
						));
			}
			
		} catch (SQLException ex){
			System.out.println("Error en método read()");
			ex.printStackTrace();
		}
		
		
		return usuarios;
	}
	
	public void update(User u) {
		try {
			Connection c = Conexion.getConnection();
			
			Statement s = c.createStatement();
			String query = "UPDATE public.startup_user SET "
					+ "correo = '" + u.getCorreo() + "',"
					+ "nombre = '" + u.getNombre() + "',"
					+ "nick = '" + u.getNick() + "',"
					+ "pasword = '" + u.getPassword() + "',"
					+ "peso = '" + u.getPeso() + "',"
					+ "updated_at = '" + LocalDateTime.now() + "' "
					+ "WHERE id = " + u.getId();
			
			s.execute(query);
		} catch (SQLException ex){
			System.out.println("Error en método update()");
			ex.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try {
			Connection c = Conexion.getConnection();
			
			Statement s = c.createStatement();
			String query = "DELETE FROM public.proveedores "
					+ "WHERE id = " + id;

			s.execute(query);
		} catch (SQLException ex){
			System.out.println("Error en método delete()");
			ex.printStackTrace();
		}
	}
}
