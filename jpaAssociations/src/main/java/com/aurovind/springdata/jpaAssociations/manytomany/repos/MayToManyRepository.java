package com.aurovind.springdata.jpaAssociations.manytomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.aurovind.springdata.jpaAssociations.manytomany.entities.Programmer;

public interface MayToManyRepository extends CrudRepository<Programmer, Integer> {

}
