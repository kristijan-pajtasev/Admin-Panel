package com.kristijan.pajtasev.controller;

import com.kristijan.pajtasev.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kristijan on 26.11.14..
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
