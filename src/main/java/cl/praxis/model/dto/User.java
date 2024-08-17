package cl.praxis.model.dto;

public class User {
	private int id;
	private String correo;
	private String nombre;
	private String nick;
	private String password;
	private String peso;
	
	public User(int id, String correo, String nombre, String nick, String password, String peso) {
		super();
		this.id = id;
		this.correo = correo;
		this.nombre = nombre;
		this.nick = nick;
		this.password = password;
		this.peso = peso;
	}
	
	public User(String correo, String nombre, String nick, String password, String peso) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.nick = nick;
		this.password = password;
		this.peso = peso;
	}

	public int getId() {
		return id;
	}

	public String getCorreo() {
		return correo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNick() {
		return nick;
	}

	public String getPassword() {
		return password;
	}

	public String getPeso() {
		return peso;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", correo=" + correo + ", nombre=" + nombre + ", nick=" + nick + ", password="
				+ password + ", peso=" + peso + "]";
	}
}
