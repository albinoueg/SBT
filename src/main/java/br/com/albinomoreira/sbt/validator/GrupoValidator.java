package br.com.albinomoreira.sbt.validator;

import br.com.albinomoreira.sbt.domain.Funcionario;
import br.com.albinomoreira.sbt.domain.GrupoLancamento;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class GrupoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {

        return GrupoLancamento.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {

        GrupoLancamento f = (GrupoLancamento) object;

    }

}
