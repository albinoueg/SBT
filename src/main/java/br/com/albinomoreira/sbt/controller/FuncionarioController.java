package br.com.albinomoreira.sbt.controller;

import br.com.albinomoreira.sbt.domain.Cargo;
import br.com.albinomoreira.sbt.domain.Departamento;
import br.com.albinomoreira.sbt.domain.Funcionario;
import br.com.albinomoreira.sbt.enums.UF;
import br.com.albinomoreira.sbt.service.CargoService;
import br.com.albinomoreira.sbt.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private CargoService cargoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario funcionario){
        return "/funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("funcionarios", funcionarioService.buscarTodos());
        return "/funcionario/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Funcionario funcionario, RedirectAttributes attr){
        funcionarioService.salvar(funcionario);
        attr.addFlashAttribute("success", "Funcionário inserido com sucesso.");
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        return "/funcionario/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Funcionario funcionario, RedirectAttributes attr){
        funcionarioService.editar(funcionario);
        attr.addFlashAttribute("success", "Funcionário editado com sucesso.");
        return "redirect:/funcionarios/cadastrar";
    }

    @ModelAttribute("cargos")
    public List<Cargo> getCargos(){
        return cargoService.buscarTodos();
    }

    @ModelAttribute("ufs")
    public UF[] getUFs(){
        return UF.values();
    }
}
