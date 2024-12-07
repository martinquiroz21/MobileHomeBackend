package mobilehome.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mobilehome.modelo.Adicional;
import mobilehome.modelo.Estilo;
import mobilehome.repositorio.AdicionalRepositorio;
import mobilehome.repositorio.EstiloRepositorio;

@RestController
@RequestMapping("/api-backend/")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonalizaControlador {
	
	@Autowired
	private EstiloRepositorio estiloRepositorio;
	
	@Autowired
	private AdicionalRepositorio adicionalRepositorio;
	
	@GetMapping("/personalizar/estilos")
	public List<Estilo> listarEstilos() {
		return estiloRepositorio.findAll();
	}
	
	@GetMapping("/personalizar/adicionales")
	public List<Adicional> listarAdicionales() {
		return adicionalRepositorio.findAll();
	}

}
