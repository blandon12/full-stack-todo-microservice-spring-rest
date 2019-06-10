package com.fullstack.restfulwebservices.repository;

import com.fullstack.restfulwebservices.domain.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

    Iterable<Todo> getAllByUid(Long uid);
}
