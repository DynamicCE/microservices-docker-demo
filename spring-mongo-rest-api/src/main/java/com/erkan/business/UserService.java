package com.erkan.business;

import com.erkan.model.User;
import com.erkan.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public
class UserService {
    private
    UserRepo userRepo;

    public
    UserService ( UserRepo userRepo ) {
        this.userRepo = userRepo;
    }

    private static final Logger log = LoggerFactory.getLogger (UserService .class );


    public
    User save ( User user ) {
        if(user == null){
            throw new IllegalArgumentException ( "Kullanıcı bilgileri boş olamaz" );
        }
      try{
          return userRepo.save ( user );
      }catch (DataAccessException e){
          log.error("Kullanıcı kaydedilirken bir hata oluştu.", e);
          throw new RuntimeException ( "Kullanıcı kaydedilirken bir hata oluştu." );
      }
    }

    public List<User> findAll() {
        try {
            return userRepo.findAll();
        } catch (DataAccessException e) {
            log.error("Kullanıcılar getirilirken bir hata oluştu.", e);
            throw new RuntimeException("Kullanıcılar getirilirken bir hata oluştu.");
        }
    }
}
