package com.aurovind.springdata.jpaAssociations.OnetoOne.repos;

import org.springframework.data.repository.CrudRepository;

import com.aurovind.springdata.jpaAssociations.OnetoOne.entities.Person;

public interface OneToOneRepos extends CrudRepository<Person, Long>{

}
