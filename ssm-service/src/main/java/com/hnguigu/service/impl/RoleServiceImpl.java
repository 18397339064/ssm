package com.hnguigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.hnguigu.dao.RoleDao;
import com.hnguigu.service.RoleService;
import com.hnguigu.vo.PageVo;
import com.hnguigu.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    //通过条件查询
    @Override
    public PageVo<Role> queryRoleCount(Role role, int page, int rows) {
        PageVo<Role> pageVo = new PageVo<>();
        //放在 查询代码的前面
        PageHelper.startPage(page,rows);
        pageVo.setRows(roleDao.queryRole(role));

        pageVo.setTotal(roleDao.queryRoleCount(role));

        return pageVo;
    }

    //添加
    @Override
    public int addRole(Role role) {
        return roleDao.addRole(role);
    }

    //修改
    @Override
    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    //批量删除
    @Override
    public int deletePLRole( String[] roleid) {
        return roleDao.deletePLRole(roleid);
    }

    //删除
    @Override
    public int deleteRole(int roleid) {
        return roleDao.deleteRole(roleid);
    }

    @Override
    public List<Role> queryFenPeiRole() {
        List<Role> list=roleDao.queryRole(new Role());
        for (Role r:list) {
            r.setId(r.getRoleid());
            r.setLabel(r.getRolename());
        }
        return list;
    }


}
