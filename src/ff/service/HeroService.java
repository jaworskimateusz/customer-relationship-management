package ff.service;

import java.util.List;

import ff.entity.Hero;

public interface HeroService {
	
	public List<Hero> getHeroes();

	public void saveHero(Hero hero);

	public Hero getHero(int id);

}
