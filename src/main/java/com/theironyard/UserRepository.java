package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jack on 12/10/15.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
