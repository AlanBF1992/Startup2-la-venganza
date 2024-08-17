package cl.praxis.model.dto;

public class Vehiculo {
	int id;
	String nombre;
	String placa;
	String user;
	
	public Vehiculo(int id, String nombre, String placa, String user) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.placa = placa;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPlaca() {
		return placa;
	}

	public String getUser() {
		return user;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
