package mx.com.gapsi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import mx.com.gapsi.model.Proveedores;
import mx.com.gapsi.repository.ProveedoresRepository;

@Service
public class ProveedoresService {

	@Autowired
	ProveedoresRepository proveedoresRepository;

	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Proveedores> listarProveedores(int pageNo, int pageSize) {

		PageRequest paging = PageRequest.of(pageNo, pageSize);
		Page<Proveedores> pageResult = proveedoresRepository.findAll(paging);

		return pageResult.toList();
	}

	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public Boolean eliminarProveedores(String nombre) {

		Optional<Proveedores> exist = proveedoresRepository.findById(nombre);

		if (exist.isPresent()) {
			proveedoresRepository.deleteById(nombre);
			;
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 
	 * @param proveedores
	 * @return
	 * @throws Exception
	 */
	public Proveedores agregarProveedores(Proveedores proveedores) throws Exception {

		Optional<Proveedores> exist = proveedoresRepository.findById(proveedores.getNombre());

		if (exist.isPresent()) {
			throw new Exception("Proveedor ya registrado");
		} else {
			return proveedoresRepository.save(proveedores);
		}

	}
}
