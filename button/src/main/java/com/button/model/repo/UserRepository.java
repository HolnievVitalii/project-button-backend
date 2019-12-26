package com.button.model.repo;


import com.button.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(
        value = "SELECT * " +
            "FROM users " +
            "WHERE " +
            "   login = :login",
        nativeQuery = true
    )
    public User findUserByLogin(@Param("login") String login);
}
