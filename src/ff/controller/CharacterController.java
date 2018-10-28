package ff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ff.dao.CharacterDAO;
import ff.entity.Character;

@Controller
@RequestMapping("/characters")
public class CharacterController {
	
	@Autowired
	private CharacterDAO characterDAO;
	
	@RequestMapping("/list")
	public String showList(Model model) {
		List<Character> characters = characterDAO.getCharacters();
		model.addAttribute("characters", characters);
		return "list-characters";
	}

}
