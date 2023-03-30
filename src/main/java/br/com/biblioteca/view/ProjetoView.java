package br.com.biblioteca.view;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@CrossOrigin
@Controller
@RequestMapping("/projetos")
public class ProjetoView {
    @Autowired
    private ProjetoRepository projetoRepository;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List < Projeto > projetos = projetoRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("projetos");
        modelAndView.addObject("projetos", projetos);
        return modelAndView;
    }
}