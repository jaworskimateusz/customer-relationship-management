package ff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ff.dao.HeroDAO;
import ff.entity.Hero;

@Controller
@RequestMapping("/heroes")
public class HeroController {
	
	@Autowired
	private HeroDAO heroDAO;
	
	@GetMapping("/list")
	public String showList(Model model) {
		List<Hero> heroes = heroDAO.getHeroes();
		model.addAttribute("heroes", heroes);
		return "list-characters";
	}
	
	@GetMapping("/add")
	public String showFormForAdd(Model model) {
		model.addAttribute("hero", new Hero());
		return "add-hero";
	}

}
