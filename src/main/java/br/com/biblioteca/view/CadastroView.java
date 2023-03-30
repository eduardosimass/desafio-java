package br.com.biblioteca.view;

import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@CrossOrigin
@Controller
@RequestMapping("/cadastro")
public class CadastroView {

    @Autowired
    private ProjetoRepository projetoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cadastro() {
        List < Projeto > cadastro = projetoRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("cadastro", cadastro);
        return modelAndView;
    }

}