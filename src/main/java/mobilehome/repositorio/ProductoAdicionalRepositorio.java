package mobilehome.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mobilehome.modelo.Producto;
import mobilehome.modelo.Producto_Adicional;

@Repository
public interface ProductoAdicionalRepositorio extends JpaRepository<Producto_Adicional, Long> {
	
	List<Producto_Adicional> findByProducto(Producto producto);
	
}
