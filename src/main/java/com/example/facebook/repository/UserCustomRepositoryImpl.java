package com.example.facebook.repository;

import com.example.facebook.entity.Post;
import com.example.facebook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserCustomRepositoryImpl implements UserCustomRepository{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<User> foundName(String userName) {


            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(User.class);

            Root<User> user = cq.from(User.class);

            Predicate userNamePredicate = cb.equal(user.get("userName"), userName);


            cq.where(userNamePredicate);

            TypedQuery<User> query = entityManager.createQuery(cq);

            return query.getResultList();
        }

    @Override
    public List<User> foundNameAsc() {
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery=criteriaBuilder.createQuery(User.class);

        Root<User> userRoot=criteriaQuery.from(User.class);

        criteriaQuery.orderBy(criteriaBuilder.asc(userRoot.get("userName")));

        List<User> users=entityManager.createQuery(criteriaQuery).getResultList();
        return users;
    }

    @Override
    public List<User> greaterThan(long id) {

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery=criteriaBuilder.createQuery(User.class);

        Root<User> userRoot=criteriaQuery.from(User.class);

        criteriaQuery.select(userRoot);

        Predicate lastPredicate = criteriaBuilder.ge(userRoot.get("id"),id);
        criteriaQuery.where(lastPredicate);

        TypedQuery<User> typedQuery= entityManager.createQuery(criteriaQuery);

        List<User> users=typedQuery.getResultList();
        return users;

    }

    @Override
    public List<User> likeBy(String userName) {

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery=criteriaBuilder.createQuery(User.class);

        Root<User> userRoot=criteriaQuery.from(User.class);

        criteriaQuery.select(userRoot);

        Predicate predicate= criteriaBuilder.like(userRoot.get("userName"),"%s%");

        criteriaQuery.where(predicate);

        TypedQuery<User> typedQuery= entityManager.createQuery(criteriaQuery);

        return typedQuery.getResultList();
    }



    @Override
    public List<User> orIdUserName(long id, String userName)
    {
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery=criteriaBuilder.createQuery(User.class);

        Root<User> userRoot=criteriaQuery.from(User.class);

        criteriaQuery.select(userRoot);

        Predicate predicateId= criteriaBuilder.equal(userRoot.get("id"), id);
        Predicate predicateuserName= criteriaBuilder.equal(userRoot.get("userName"), userName);

        Predicate idOrUserNamePredicate=criteriaBuilder.or(predicateId,predicateuserName);
        criteriaQuery.where(idOrUserNamePredicate);

        TypedQuery<User> typedQuery=entityManager.createQuery(criteriaQuery);

        List<User> userList=typedQuery.getResultList();

        return userList;


    }
}

