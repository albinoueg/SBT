package br.com.albinomoreira.sbt.controller;

import br.com.albinomoreira.sbt.domain.Pais;
import br.com.albinomoreira.sbt.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisService service;

    @GetMapping("/cadastrar")
    public String cadastrar(Pais pais){
        return "/configuracoes/pais/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("paises", service.buscarTodos());
        return "/configuracoes/pais/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Pais pais, RedirectAttributes attr){
        service.salvar(pais);
        attr.addFlashAttribute("success", "País inserido com sucesso.");
        return "redirect:/paises/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("pais", service.buscarPorId(id));
        return "/configuracoes/pais/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Pais pais, RedirectAttributes attr){
        service.editar(pais);
        attr.addFlashAttribute("success", "País editado com sucesso.");
        return "redirect:/paises/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model){
        if(service.paisTemEstado(id)){
            model.addAttribute("fail", "País não removido. Possui estado(s) vinculado(s).");
        }else {
            service.excluir(id);
            model.addAttribute("success", "País excluído com sucesso.");
        }
        return listar(model);
    }
}
