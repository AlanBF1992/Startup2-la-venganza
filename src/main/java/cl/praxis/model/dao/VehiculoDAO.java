package cl.praxis.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.praxis.model.connection.Conexion;
import cl.praxis.model.dto.Vehiculo;

public class VehiculoDAO {

	public Vehiculo read(int id) {		
		List<Vehiculo> vehiculos = read();
		Vehiculo v = vehiculos.stream().filter(x -> x.getId() == id).findAny().orElse(null);
		return v;
	}
	
	public List<Vehiculo> read() {
		List<Vehiculo> veh = new ArrayList<Vehiculo>();
		
		try {
			Connection c = Conexion.getConnection();
			
			Statement s = c.createStatement();
			String query = "SELECT V.id, V.nombre, V.placa, U.nombre FROM public.startup_vehiculos as V LEFT JOIN public.startup_user as U on V.usuario_id = U.id";
			
			ResultSet rs = s.executeQuery(query);
			
			while (rs.next()) {
				veh.add(new Vehiculo(
						rs.getInt("V.id"),
						rs.getString("V.nombre"),
						rs.getString("V.placa"),
						rs.getString("U.nombre")
						));
			}
			
		} catch (SQLException ex){
			System.out.println("Error en método read()");
			ex.printStackTrace();
		}
		
		
		return veh;
	}	
}
