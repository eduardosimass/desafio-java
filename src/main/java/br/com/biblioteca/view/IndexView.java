package br.com.biblioteca.view;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
@Controller
public class IndexView {
	@GetMapping("/")
	public String home(Model model, HttpServletRequest httpServletRequest) {
		return "index";
	}
}