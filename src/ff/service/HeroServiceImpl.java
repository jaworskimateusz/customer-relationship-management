package ff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ff.dao.HeroDAO;
import ff.entity.Hero;

@Service
public class HeroServiceImpl implements HeroService {

	@Autowired
	private HeroDAO heroDAO;
	
	@Override
	@Transactional
	public List<Hero> getHeroes() {
		return heroDAO.getHeroes();
	}

	@Override
	@Transactional
	public void saveHero(Hero hero) {
		heroDAO.saveHero(hero);
	}

	@Override
	@Transactional
	public Hero getHero(int id) {
		return heroDAO.getHero(id);
	}

	@Override
	@Transactional
	public void deleteHero(int id) {
		heroDAO.deleteHero(id);
	}

}
