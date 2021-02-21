package br.com.albinomoreira.sbt.controller;

import br.com.albinomoreira.sbt.domain.Cidade;
import br.com.albinomoreira.sbt.domain.Estado;
import br.com.albinomoreira.sbt.service.CidadeService;
import br.com.albinomoreira.sbt.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;
    @Autowired
    private EstadoService estadoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Cidade cidade){
        return "/configuracoes/cidade/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("cidades", cidadeService.buscarTodos());
        return "/configuracoes/cidade/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Cidade cidade, RedirectAttributes attr){

        if(cidade.getUfCidade() == null){
            attr.addFlashAttribute("fail", "Selecione um estado.");
            return "redirect:/cidades/cadastrar";
        }
        cidadeService.salvar(cidade);
        attr.addFlashAttribute("success", "Cidade inserida com sucesso.");
        return "redirect:/cidades/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cidade", cidadeService.buscarPorId(id));
        return "/configuracoes/cidade/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Cidade cidade, RedirectAttributes attr) {
        cidadeService.editar(cidade);
        attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
        return "redirect:/cidades/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        cidadeService.excluir(id);
        attr.addFlashAttribute("success", "Cidade excluida com sucesso.");
        return "redirect:/cidades/listar";
    }

    @ModelAttribute("estados")
    public List<Estado> listaDeEstados(){
        return estadoService.buscarTodos();
    }
}
