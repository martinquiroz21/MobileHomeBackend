package mobilehome.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mobilehome.modelo.Servicio;

@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio, Long> {

}
