package cl.praxis.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.model.connection.Conexion;

public class UserRolesDAO {

	public List<Integer> getRoles(int id) {
		List<Integer> roles = new ArrayList<Integer>();

		try {
			Connection c = Conexion.getConnection();
			
			Statement s = c.createStatement();
			String query = "SELECT rol_id FROM public.startup_roles_usuario WHERE usuario_id = " + id;
			
			ResultSet rs = s.executeQuery(query);
			
			while (rs.next()) {
				roles.add(rs.getInt("rol_id"));
			}
			
		} catch (SQLException ex){
			System.out.println("Error en método read()");
			ex.printStackTrace();
		}
		return roles;
	}
}
