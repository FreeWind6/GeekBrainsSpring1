package ru.geekbrains.sample.dao;

import org.springframework.stereotype.Repository;
import ru.geekbrains.sample.persistence.entity.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CarRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Car> findAllCar() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> root = criteriaQuery.from(Car.class);
        CriteriaQuery<Car> all = criteriaQuery.select(root);
        return entityManager.createQuery(all).getResultList();
    }
}
