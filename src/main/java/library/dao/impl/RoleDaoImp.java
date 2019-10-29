package library.dao.impl;

import library.dao.RoleDao;
import library.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImp implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }
}
