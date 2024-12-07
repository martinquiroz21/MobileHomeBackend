package mobilehome.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mobilehome.modelo.Adicional;

@Repository
public interface AdicionalRepositorio extends JpaRepository<Adicional, Long> {
	
	
	
}
