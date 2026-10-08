package hiber.dao;

import hiber.Exceptions.UserByCarNotFoundException;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Repository
public class CarDaoImp implements CarDao {

    private SessionFactory sessionFactory;
    @Autowired
    public CarDaoImp (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public User getUserByCar(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("from User where car.model = :model and car.series = :series", User.class);

        query.setParameter("model", model);
        query.setParameter("series", series);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new UserByCarNotFoundException("Ни один из пользователей не владеет указанным автомобилем");
        }
    }
}
