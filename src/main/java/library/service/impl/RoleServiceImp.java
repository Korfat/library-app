package library.service.impl;

import library.dao.RoleDao;
import library.entity.Role;
import library.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public void add(Role role) {
        roleDao.add(role);
    }
}
