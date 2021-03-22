package br.com.albinomoreira.sbt.controller;

import br.com.albinomoreira.sbt.domain.Funcionario;
import br.com.albinomoreira.sbt.domain.GrupoLancamento;
import br.com.albinomoreira.sbt.service.GrupoService;
import br.com.albinomoreira.sbt.validator.FuncionarioValidator;
import br.com.albinomoreira.sbt.validator.GrupoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoService service;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new GrupoValidator());
    }

    @GetMapping
    public String listar(ModelMap model){
        model.addAttribute("grupos", service.buscarTodos());
        return "grupo/listar";
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(GrupoLancamento grupo){
        ModelAndView mv = new ModelAndView("/grupo/cadastroGrupo");
        mv.addObject("grupo", grupo);
        return mv;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@Valid @ModelAttribute("grupo") GrupoLancamento grupo, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("/grupo/cadastroGrupo");
            mv.addObject("grupo", grupo);
            return mv;
        }

        service.salvar(grupo);
        ModelAndView mv = new ModelAndView("redirect:/grupos");
        attr.addFlashAttribute("success", "Grupo inserido com sucesso.");
        return mv;
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("pais", service.buscarPorId(id));
        return "/configuracoes/pais/cadastro";
    }

    @PostMapping("/editar")
    public String editar(GrupoLancamento grupo, RedirectAttributes attr){
        service.editar(grupo);
        attr.addFlashAttribute("success", "País editado com sucesso.");
        return "redirect:/paises/cadastrar";
    }

/*    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        if(service.paisTemEstado(id)){
            model.addAttribute("fail", "País não removido. Possui estado(s) vinculado(s).");
        }else {
            service.excluir(id);
            model.addAttribute("success", "País excluído com sucesso.");
        }
        return listar(model);
    }*/
}
