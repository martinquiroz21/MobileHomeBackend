package mobilehome.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mobilehome.excepciones.ResourceNotFoundException;
import mobilehome.modelo.Servicio;
import mobilehome.repositorio.ServicioRepositorio;

@RestController
@RequestMapping("/api-backend/")
@CrossOrigin(origins = "http://localhost:4200")
public class ServicioControlador {
	
	@Autowired
	private ServicioRepositorio servicioRepositorio;
	
	// Trae una lista de todos los servicios
	@GetMapping("/servicios")
	public List<Servicio> listarServicios() {
		return servicioRepositorio.findAll();
	}
	
	// Obtiene un servicio por id
	@GetMapping("/servicios/{id}")
	public ResponseEntity<Servicio> obtenerServicioPorID(@PathVariable Long id) {
		Servicio servicio = servicioRepositorio.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("No existe el servicio con el ID : " + id));
		return ResponseEntity.ok(servicio);
	}

}
