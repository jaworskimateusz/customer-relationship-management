package ff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ff.entity.Hero;
import ff.service.HeroService;

@Controller
@RequestMapping("/heroes")
public class HeroController {
	
	@Autowired
	private HeroService heroService;
	
	@GetMapping("/list")
	public String showList(Model model) {
		List<Hero> heroes = heroService.getHeroes();
		model.addAttribute("heroes", heroes);
		return "list-characters";
	}
	
	@GetMapping("/add")
	public String showFormForAdd(Model model) {
		model.addAttribute("hero", new Hero());
		return "add-hero";
	}
	
	@PostMapping("/saveHero")
	public String saveHero(@ModelAttribute("hero") Hero hero) {
		heroService.saveHero(hero);
		return "redirect:/heroes/list";
	}
	
	@GetMapping("/update")
	public String updateHero(@RequestParam("heroId") int id, Model model) {
		Hero hero = heroService.getHero(id);
		model.addAttribute("hero",hero);
		return "add-hero";
	}

}
