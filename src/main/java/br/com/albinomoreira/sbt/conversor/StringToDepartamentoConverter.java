package br.com.albinomoreira.sbt.conversor;

import br.com.albinomoreira.sbt.domain.Departamento;
import br.com.albinomoreira.sbt.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

    @Autowired
    private DepartamentoService service;

    @Override
    public Departamento convert(String source) {
        if(source.isEmpty()){
            return null;
        }
        Long id = Long.valueOf(source);
        return service.buscarPorId(id);
    }
}
