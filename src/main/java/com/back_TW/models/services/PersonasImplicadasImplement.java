package com.back_TW.models.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back_TW.models.entity.PersonasImplicadas;
import com.back_TW.models.repository.PersonasImplicadasRepository;

@Service
public class PersonasImplicadasImplement implements IPersonasImplicadasServices  {

	@Autowired
	private PersonasImplicadasRepository pi;	
	@Override
	public void guardar(PersonasImplicadas p) {
	 pi.save(p);
		
	}
	@Override
	public long buscarId(long idPrestador, long idCliente) 
	{
		List<PersonasImplicadas> perimp = (List<PersonasImplicadas>) pi.findAll();
		for (int i = 0; i < perimp.size(); i++) 
		{
			if(perimp.get(i).getEmpleadosDe_idEmpleadosDe() == idPrestador && perimp.get(i).getPersonas_idpersonas() == idCliente) 
			{
				return perimp.get(i).getIdpersonas_implicadas();
			}
		}	
		
		return -1;
	}
	@Override
	public PersonasImplicadas persoObject(long id) {
		Optional<PersonasImplicadas> p = pi.findById(id);
		
		
		return p.get();
	}


}
