package com.damienrubio.skrib.repository;


import com.damienrubio.skrib.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by damien on 09/01/2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
