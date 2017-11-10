package br.gov.sp.sessp.api.repository.servidor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.gov.sp.sessp.api.dto.ServidorDTO;

public interface ServidorRepositoryCustom {

	public Page<ServidorDTO> filtrar(ServidorFilter filter,Pageable pageable);
}
