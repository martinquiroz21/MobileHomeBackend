package mobilehome.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Servicios")
public class Servicio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "titulo")
    private String titulo;
    
    @Column(name = "descripcion", length = 1000)
    private String descripcion;
    
    @Column(name = "imagen")
    private String imagen;
    
    public Servicio() {}

	public Servicio(Long id, String titulo, String descripcion, String imagen) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
