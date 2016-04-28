package com.clear.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clear.dao.BaseDao;
import com.clear.entity.AdminUser;
import com.clear.service.FirstService;

@Service(value = "firstServiceImpl")
public class FirstServiceImpl extends BaseServiceImpl implements FirstService {
    
//    @Resource(name ="userDao")
//    UserDao UserDaoImpl;
    
//    @Resource(name ="UserServiceImpl")
//    UserService UserServiceImpl;
    
    @Autowired
    private BaseDao baseDao;
    
    @Override
    public boolean checkPwd(String pwd) {
        if (pwd.endsWith("123")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean saveUser(AdminUser user) {
        
        baseDao.save(user);
//        UserServiceImpl.insert(user);
        
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("Class Not Found Exception . ");
//        }
//        // 连接URL
//        String url = "jdbc:mysql://localhost:3306/first";
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            conn = DriverManager.getConnection(url, "root", "mysql");
//            stmt = conn.createStatement();
//            // SQL语句
//            String sql = "select * from user where name='" + user.getName()
//                    + "' and psw= '" + user.getPwd() + "'";
//            rs = stmt.executeQuery(sql);// 返回查询结果
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        
//        request.getSession().setAttribute("user", user);
        return false;
    }

}
