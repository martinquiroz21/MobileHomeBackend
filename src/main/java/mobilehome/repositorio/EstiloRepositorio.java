package mobilehome.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mobilehome.modelo.Estilo;

@Repository
public interface EstiloRepositorio extends JpaRepository<Estilo, Long> {
	
	
	
}
