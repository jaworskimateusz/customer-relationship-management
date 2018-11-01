package crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
	}

	@Override
	public List<Customer> searchCustomers(String searchName) {
		Session session = sessionFactory.getCurrentSession();
		List<Customer> findedCustomers;
		if(searchName != null & isEmpty(searchName)) {
			findedCustomers = session
			.createQuery("from Customer where lower(firstName) like :searchName" +
			"or lower(lastName) like :searchName", Customer.class)
			.getResultList();
		} else {
			findedCustomers = this.getCustomers();
		}
		return findedCustomers;
	}
	
	private boolean isEmpty(String searchName) {
		if(searchName.trim().length() > 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
