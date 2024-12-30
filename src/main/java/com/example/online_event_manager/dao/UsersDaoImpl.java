package com.example.online_event_manager.dao;

import com.example.online_event_manager.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao{

    private final EntityManager entityManager;

    @Autowired
    public UsersDaoImpl(EntityManager manager){
        this.entityManager=manager;
    }
    @Override
    public List<Users> findAll() {
        TypedQuery<Users> query=entityManager.createQuery("from Users",Users.class);
        return query.getResultList();
    }

    @Override
    public Users findById(int theId) {
        return entityManager.find(Users.class,theId);
    }

    @Override
    public Users save(Users theUser) {
        return entityManager.merge(theUser);
    }

    @Override
    public void deleteById(int theId) {
        Users user = entityManager.find(Users.class,theId);
        if(user!=null){
            entityManager.remove(user);
        }
    }

    @Override
    public Users findByEmail(String email) {
        TypedQuery<Users> query = entityManager.createQuery("from Users u where u.email = :email",Users.class);
        query.setParameter("email",email);
        List<Users> results=query.getResultList();
        return results.isEmpty() ? null: results.get(0);
    }

    @Override
    public List<Users> findByRole(String role) {
        TypedQuery<Users> query = entityManager.createQuery(
                "from Users u where u.role= :role", Users.class
        );
        query.setParameter("role",role);
        return query.getResultList();
    }
}
