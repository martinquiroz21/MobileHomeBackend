package mobilehome.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="producto_adicional")
public class Producto_Adicional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name = "producto_id")
	private Producto producto;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name = "adicional_id")
	private Adicional adicional;
	
	public Producto_Adicional() {}

	public Producto_Adicional(Long id, Producto producto, Adicional adicional) {
		this.id = id;
		this.producto = producto;
		this.adicional = adicional;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Adicional getAdicional() {
		return adicional;
	}

	public void setAdicional(Adicional adicional) {
		this.adicional = adicional;
	}

}
