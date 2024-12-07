package mobilehome.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Productos")
public class Producto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name = "titulo")
    private String titulo;
    
    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "descripcion", length = 1000)
    private String descripcion;
    
    @Column(name = "precio")
    private Double precio;
    
    @Column(name = "imagen")
    private String imagen;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "estilo_id")
    private Estilo estilo;
    
    @Column(name = "paleta_colores")
    private PaletaColores paletaColores;
    
    @Column(name = "esPersonalizado")
    private Boolean esPersonalizado;
    
    public Producto() {}

	public Producto(Long id, String titulo, String categoria, String descripcion, Double precio, String imagen, 
			Estilo estilo, PaletaColores paletaColores, Boolean esPersonalizado) {
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		this.estilo = estilo;
		this.paletaColores = paletaColores;
		this.esPersonalizado = esPersonalizado;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public PaletaColores getPaletaColores() {
		return paletaColores;
	}

	public void setPaletaColores(PaletaColores paletaColores) {
		this.paletaColores = paletaColores;
	}

	public Boolean getEsPersonalizado() {
		return esPersonalizado;
	}

	public void setEsPersonalizado(Boolean esPersonalizado) {
		this.esPersonalizado = esPersonalizado;
	}
	
}
