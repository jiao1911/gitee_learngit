package com.test.jiao.repository;


import com.test.jiao.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByUsername(String username);
    List<User> findByUsernameAndPassword(String username, String password);

    @Query("from User u where u.username=:username")
    List<User> findUsername(@Param("username") String username);


    //List<User> selectUserById(Long id);
    //@Query("select u.id,u.username,u.password  from User u where u.id=:id")
    //Optional<User> findById(@Param("id") Long id);


//    @Modifying
//    @Transactional
//    @Query(value = "delete from User u where u.userId = ?1")
//    void deleteById(Long id);

}



