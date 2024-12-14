package mobilehome.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mobilehome.excepciones.ResourceNotFoundException;
import mobilehome.modelo.Adicional;
import mobilehome.modelo.Estilo;
import mobilehome.modelo.Producto;
import mobilehome.modelo.Producto_Adicional;
import mobilehome.modelo.RequestPayloadDos;
import mobilehome.modelo.Usuario;
import mobilehome.modelo.Usuario_Producto;
import mobilehome.repositorio.AdicionalRepositorio;
import mobilehome.repositorio.EstiloRepositorio;
import mobilehome.repositorio.ProductoAdicionalRepositorio;
import mobilehome.repositorio.ProductoRepositorio;
import mobilehome.repositorio.UsuarioProductoRepositorio;
import mobilehome.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/api-backend/")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonalizaControlador {
	
	@Autowired
	private EstiloRepositorio estiloRepositorio;
	
	@Autowired
	private AdicionalRepositorio adicionalRepositorio;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	@Autowired
	private UsuarioProductoRepositorio usuarioProductoRepositorio;
	
	@Autowired
	private ProductoAdicionalRepositorio productoAdicionalRepositorio;
	
	@GetMapping("/personalizar/estilos")
	public List<Estilo> listarEstilos() {
		return estiloRepositorio.findAll();
	}
	
	@GetMapping("/personalizar/adicionales")
	public List<Adicional> listarAdicionales() {
		return adicionalRepositorio.findAll();
	}
	
	// Se registra la compra de un producto
	@PostMapping("/personalizar/compra")
	public ResponseEntity<Producto> registrarCompra(@RequestBody RequestPayloadDos payload) {
		// Se obtiene el usuario y se crea el producto nuevo
		Usuario usuario = usuarioRepositorio.findById(payload.getUsuario().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Error usuario!"));
		Producto productoPl = payload.getProducto();
		Estilo estilo = estiloRepositorio.findById(productoPl.getEstilo().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Error estilo!"));
		Producto producto = new Producto();
		producto.setTitulo(productoPl.getTitulo());
		producto.setCategoria(productoPl.getCategoria());
		producto.setDescripcion(productoPl.getDescripcion());
		producto.setPrecio(productoPl.getPrecio());
		producto.setImagen(productoPl.getImagen());
		producto.setEstilo(estilo);
		producto.setPaletaColores(productoPl.getPaletaColores());
		producto.setEsPersonalizado(productoPl.getEsPersonalizado());
		producto = productoRepositorio.save(producto);
		// Se guarda el registro de los adicionales que pertenecen al producto
		List<Adicional> adicionales = payload.getAdicionales();
		if (adicionales != null) {
			for (Adicional adicionalPl : adicionales) {
				Producto_Adicional productoAdicional = new Producto_Adicional();
				Adicional adicional = adicionalRepositorio.findById(adicionalPl.getId())
						.orElseThrow(() -> new ResourceNotFoundException("Error Adicional!"));
				productoAdicional.setAdicional(adicional);
				productoAdicional.setProducto(producto);
				productoAdicionalRepositorio.save(productoAdicional);
			}
		}
		// Se crea el registro de compra
		Usuario_Producto usuarioProducto = new Usuario_Producto();
		usuarioProducto.setUsuario(usuario);
		usuarioProducto.setProducto(producto);
		usuarioProducto.setFechaCompra(LocalDate.now());
		return ResponseEntity.ok(usuarioProductoRepositorio.save(usuarioProducto).getProducto());
	}

}
