package ff.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ff.entity.Hero;

@Repository
public class HeroDAOImpl implements HeroDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Hero> getHeroes() {
		Session session = sessionFactory.getCurrentSession();
		Query<Hero> query = session.createQuery("from Hero order by firstName", Hero.class);
		List<Hero> heroes = query.getResultList();
		return heroes;
	}

	@Override
	public void saveHero(Hero hero) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(hero);
	}

	@Override
	public Hero getHero(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Hero.class,id);
	}

}
