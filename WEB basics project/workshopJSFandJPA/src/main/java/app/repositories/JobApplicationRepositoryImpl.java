package app.repositories;

import app.domain.entities.JobApplication;
import app.repositories.base.JobApplicationRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class JobApplicationRepositoryImpl implements JobApplicationRepository {

    private final EntityManager entityManager;

    @Inject
    public JobApplicationRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(JobApplication job) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(job);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List<JobApplication> findAll() {
        this.entityManager.getTransaction().begin();
        List<JobApplication> all = this.entityManager.createQuery("select j from JobApplication j", JobApplication.class)
                .getResultList();
        this.entityManager.getTransaction().commit();
        return all;
    }

    @Override
    public void deleteById(String id) {
        this.entityManager.getTransaction().begin();
        this.entityManager.createQuery("delete from JobApplication j where j.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        this.entityManager.getTransaction().commit();
    }

    @Override
    public JobApplication findById(String id) {
        return this.entityManager.createQuery("select j from JobApplication j where j.id = :id", JobApplication.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
