package mobilehome.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "nombre")
    private String nombre;
	
	@Column(name = "apellido")
    private String apellido;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "contrasena")
    private String contrasena;
	
	public Usuario() {}

	public Usuario(Long id, String nombre, String apellido, String email, String contrasena) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
