package br.com.albinomoreira.sbt.controller;

import br.com.albinomoreira.sbt.domain.Estado;
import br.com.albinomoreira.sbt.domain.Pais;
import br.com.albinomoreira.sbt.service.EstadoService;
import br.com.albinomoreira.sbt.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;
    @Autowired
    private PaisService paisService;

    @GetMapping("/cadastrar")
    public String cadastrar(Estado estado){
        return "/configuracoes/estado/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("estados", estadoService.buscarTodos());
        return "/configuracoes/estado/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Estado estado, RedirectAttributes attr){

        if(estado.getPais() == null){
            attr.addFlashAttribute("fail", "Selecione uma país.");
            return "redirect:/estados/cadastrar";
        }
        estadoService.salvar(estado);
        attr.addFlashAttribute("success", "Estado inserido com sucesso.");
        return "redirect:/estados/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("estado", estadoService.buscarPorId(id));
        return "/configuracoes/estado/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Estado estado, RedirectAttributes attr) {
        estadoService.editar(estado);
        attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
        return "redirect:/estados/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        if (estadoService.estadoTemCidade(id)) {
            attr.addFlashAttribute("fail", "Estado não excluido. Tem cidade(s) vinculada(s).");
        } else {
            estadoService.excluir(id);
            attr.addFlashAttribute("success", "Estado excluido com sucesso.");
        }
        return "redirect:/estados/listar";
    }

    @ModelAttribute("paises")
    public List<Pais> listaDePaises(){
        return paisService.buscarTodos();
    }
}
