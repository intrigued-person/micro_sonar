package com.shakeel.repoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shakeel.model.UserReg;
import com.shakeel.repo.UserRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

@Repository
@CrossOrigin("http://localhost:3000/")
public class UserRepoImp implements UserRepo {

	@Autowired
	EntityManager em;

	@Override
	public void addUser(UserReg user) {
		em.persist(user);

	}

	@Override
	public UserReg studentLogin(String email, String password) {

		Query q = em.createQuery("from UserReg log where log.email =?1 and log.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		return (UserReg) q.getSingleResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserReg> getAllUsers() {

		return em.createQuery("from UserReg").getResultList();
	}

	@Override
	public boolean updateUser(UserReg user) {
		em.merge(user);
		return true;
	}

	@Override
	public UserReg findById(int userId) {
		
		Query q = em.createQuery("from UserReg log where log.userId =?1");
		q.setParameter(1, userId);
		
		return (UserReg) q.getSingleResult();

	}

}
