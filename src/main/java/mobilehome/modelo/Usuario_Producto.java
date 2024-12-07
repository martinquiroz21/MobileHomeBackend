package mobilehome.modelo;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="usuario_producto")
public class Usuario_Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	@Column(name = "fecha_compra")
	private LocalDate fechaCompra;
	
	public Usuario_Producto() {}

	public Usuario_Producto(Long id, Usuario usuario, Producto producto, LocalDate fechaCompra) {
		this.id = id;
		this.usuario = usuario;
		this.producto = producto;
		this.fechaCompra = fechaCompra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
}
