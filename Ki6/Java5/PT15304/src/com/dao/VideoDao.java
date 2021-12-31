package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.entity.User;
import com.entity.Video;
import com.utils.HibernateUtils;

public class VideoDao {
	private Session hSession;

	public VideoDao() {
		this.hSession = HibernateUtils.getSession();

	}

	public List<Video> paginate(int offset, int perPage) {
		String hql = "FROM Video";
		
		Query query = this.hSession.createQuery(hql);

		query.setFirstResult(offset);
		query.setMaxResults(offset + perPage);
		List<Video> result = query.getResultList();
		return result;
	}
	
	public Video store(Video entity) {
		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		entity.setId(id);
		this.hSession.getTransaction().commit();
		return entity;
	}
	public Video finById(int id) {
		Video entity = this.hSession.get(Video.class, id);
		return entity;

	}

	public void update(Video entity) {

		try {
			this.hSession.clear();
			this.hSession.beginTransaction();
			this.hSession.update(entity);
			this.hSession.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.hSession.getTransaction().rollback();
		}
//		User entity = this.hSession.get(User.class, id);
//		return entity;

	}
	public void delete(Video entity) {
		{
			try {
				this.hSession.clear();
				this.hSession.beginTransaction();

				this.hSession.delete(entity);

				this.hSession.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();

				this.hSession.getTransaction().rollback();
			}
		}
	}
}
