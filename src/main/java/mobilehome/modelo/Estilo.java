package mobilehome.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Estilos")
public class Estilo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "titulo")
    private String titulo;
    
    @Column(name = "descripcion", length = 1000)
    private String descripcion;
    
    @Column(name = "precio")
    private Double precio;
    
    @Column(name = "imagen")
    private String imagen;
    
    public Estilo() {}

	public Estilo(Long id, String titulo, String descripcion, Double precio, String imagen) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.precio = precio;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
