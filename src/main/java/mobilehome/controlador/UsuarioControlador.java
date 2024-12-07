package mobilehome.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mobilehome.modelo.Usuario;
import mobilehome.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/api-backend/")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioControlador {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}
	
	@PostMapping("/usuarios/registro")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}

}
