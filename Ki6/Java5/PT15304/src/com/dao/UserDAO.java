package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.entity.User;
import com.utils.HibernateUtils;

public class UserDAO {
	private Session hSession;

	public UserDAO() {
		this.hSession = HibernateUtils.getSession();
	}

	public User store(User entity) {
		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		this.hSession.getTransaction().commit();

		entity.setId(id);
		return entity;
	}

	public List<User> paginate(int offset, int perPage) {
		String hql = "FROM User";
		Query query = this.hSession.createQuery(hql);

		query.setFirstResult(offset);
		query.setMaxResults(offset + perPage);

		List<User> result = query.getResultList();

		return result;
	}

	public User findById(int id) {
		User entity = this.hSession.get(User.class, id);

		return entity;
	}

	public void update(User entity) {
		try {
			this.hSession.clear();
			this.hSession.beginTransaction();
			this.hSession.update(entity);
			this.hSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.hSession.getTransaction().rollback();
		}
	}

	public void delete(User entity) {
		try {
			this.hSession.beginTransaction();

			this.hSession.delete(entity);

			this.hSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

			this.hSession.getTransaction().rollback();
		}
	}

	public User login(String email, String password) {
		String hql = "SELECT entity FROM User entity " + "WHERE entity.email = :email AND entity.password = :password "
				+ "AND entity.status = 1";

		Query query = this.hSession.createQuery(hql);

		query.setParameter("email", email);
		query.setParameter("password", password);

		try {
			User entity = (User) query.getSingleResult();

			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
