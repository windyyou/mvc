package com.clear.service;

import com.clear.entity.AdminUser;

public interface FirstService extends BaseService {

    public boolean checkPwd(String pwd);
    
    public boolean saveUser(AdminUser user);
}
