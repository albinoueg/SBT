package br.com.albinomoreira.sbt.conversor;

import br.com.albinomoreira.sbt.domain.Pais;
import br.com.albinomoreira.sbt.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToPaisConversor implements Converter<String, Pais> {

	@Autowired
	private PaisService service;
	
	@Override
	public Pais convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
