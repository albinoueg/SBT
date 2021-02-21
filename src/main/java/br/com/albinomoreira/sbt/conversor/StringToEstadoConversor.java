package br.com.albinomoreira.sbt.conversor;

import br.com.albinomoreira.sbt.domain.Estado;
import br.com.albinomoreira.sbt.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToEstadoConversor implements Converter<String, Estado> {

	@Autowired
	private EstadoService service;
	
	@Override
	public Estado convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
