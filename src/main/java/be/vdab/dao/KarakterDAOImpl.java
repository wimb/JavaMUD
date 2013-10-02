package be.vdab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.vdab.entities.Gebruiker;
import be.vdab.entities.Karakter;
import be.vdab.entities.Lokatie;
import org.springframework.stereotype.Repository;

@Repository
public class KarakterDAOImpl implements KarakterDAO {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void create(Karakter karakter) {
		try {
			entityManager.persist(karakter);
		} catch (RuntimeException e) {
			entityManager.clear();
			throw e;
		}

	}

	@Override
	public Karakter read(long id) {
		return entityManager.find(Karakter.class, id);
	}

	@Override
	public void update(Karakter karakter) {
		try {
			entityManager.merge(karakter);
			entityManager.flush();
		} catch (RuntimeException e) {
			entityManager.clear();
			throw e;
		}

	}

	@Override
	public void delete(long id) {
		Karakter karakter = entityManager.find(Karakter.class, id);
		if (karakter != null) {
			entityManager.remove(karakter);
			entityManager.flush();
		}

	}

	@Override
	public List<Karakter> findByGebruiker(Gebruiker gebruiker) {
		TypedQuery<Karakter> query = entityManager.createNamedQuery(
				"findKarakterByGebruiker", Karakter.class);
		query.setParameter("id", gebruiker.getId());
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Karakter> findByLokatie(Lokatie lok) {
		TypedQuery<Karakter> query = entityManager.createNamedQuery(
				"findKarakterByLokatie", Karakter.class);
		query.setParameter("lokatieId", lok.getId());
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

}
