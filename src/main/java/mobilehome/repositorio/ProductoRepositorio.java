package mobilehome.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mobilehome.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
	
	List<Producto> findByCategoria(String categoria);
	
}
