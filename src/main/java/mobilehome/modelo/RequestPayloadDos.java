package mobilehome.modelo;

import java.util.List;

public class RequestPayloadDos {
	
    private Usuario usuario;
    private Producto producto;
    private List<Adicional> adicionales;
    
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
	public List<Adicional> getAdicionales() {
		return adicionales;
	}
	public void setAdicionales(List<Adicional> adicionales) {
		this.adicionales = adicionales;
	}

}