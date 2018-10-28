package ff.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ff.entity.Character;

@Repository
public class CharacterDAOImpl implements CharacterDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Character> getCharacters() {
		Session session = sessionFactory.getCurrentSession();
		Query<Character> query = session.createQuery("FROM Character", Character.class);
		List<Character> characters = query.getResultList();
		return characters;
	}

}
