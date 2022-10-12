package mx.com.gapsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.gapsi.model.Proveedores;
import mx.com.gapsi.service.ProveedoresService;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class ProveedorController {

	@Autowired
	ProveedoresService proveedoresService;

	/**
	 * path utlizado para el inicio de sesion
	 * 
	 * @return
	 */
	@GetMapping("/home")
	public String initPage() {
		return "BIENVENIDO!!!!!!!";
	}

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/lista-proveedores/{pageNo}/{pageSize}")
	public List<Proveedores> listarProveedores(@PathVariable int pageNo, @PathVariable int pageSize) {
		return proveedoresService.listarProveedores(pageNo, pageSize);
	}

	/**
	 * 
	 * @param proveedores
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/agregar-proveedor")
	public ResponseEntity<?> agregarProveedor(@RequestBody Proveedores proveedores) throws Exception {

		return new ResponseEntity<>(proveedoresService.agregarProveedores(proveedores), HttpStatus.OK);

	}

	/**
	 * 
	 * @param nombreProveedor
	 * @return
	 */
	@DeleteMapping("/eliminar-proveedor/{nombreProveedor}")
	public ResponseEntity<?> eliminarProveedor(@PathVariable String nombreProveedor) {

		if (proveedoresService.eliminarProveedores(nombreProveedor)) {
			return new ResponseEntity<>("Proveedor Eliminado", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("El proveedor no existe para eliminar", HttpStatus.CONFLICT);
		}

	}

}
