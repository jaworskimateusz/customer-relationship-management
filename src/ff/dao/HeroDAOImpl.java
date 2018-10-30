package ff.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ff.entity.Hero;

@Repository
public class HeroDAOImpl implements HeroDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Hero> getHeroes() {
		Session session = sessionFactory.getCurrentSession();
		Query<Hero> query = session.createQuery("from Hero", Hero.class);
		List<Hero> heroes = query.getResultList();
		return heroes;
	}

}
