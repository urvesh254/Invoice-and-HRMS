package com.itaims.ihs.service;

import com.itaims.ihs.dao.JwtInvalidTokenDao;
import com.itaims.ihs.entity.JwtInvalidToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class JwtInvalidTokenService {

    @Autowired
    private JwtInvalidTokenDao jwtInvalidTokenDao;

    @Transactional
    public List<JwtInvalidToken> getAll() {
        return jwtInvalidTokenDao.getAll();
    }


    @Transactional
    public JwtInvalidToken get(long primaryKey) {
        return jwtInvalidTokenDao.get(primaryKey);
    }

    @Transactional
    public JwtInvalidToken getByToken(String token){
        return jwtInvalidTokenDao.getByToken(token);
    }

    @Transactional
    public void save(JwtInvalidToken object) {
        jwtInvalidTokenDao.save(object);
    }

    @Transactional
    public void delete(long primaryKey) {
        JwtInvalidToken jwtInvalidToken = jwtInvalidTokenDao.get(primaryKey);
        if (jwtInvalidToken != null)
            jwtInvalidTokenDao.delete(jwtInvalidToken);
    }
}
