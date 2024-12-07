package mobilehome.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mobilehome.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	

}
