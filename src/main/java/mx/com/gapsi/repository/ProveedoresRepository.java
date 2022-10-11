package mx.com.gapsi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import mx.com.gapsi.model.Proveedores;

@Repository
public interface ProveedoresRepository extends PagingAndSortingRepository<Proveedores, String> {

}
