package ff.dao;

import java.util.List;
import ff.entity.Hero;
public interface HeroDAO {
	
	public List<Hero> getHeroes();

	public void saveHero(Hero hero);

}
