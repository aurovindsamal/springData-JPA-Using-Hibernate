package com.aurovind.springdata.filedata.repos;

import org.springframework.data.repository.CrudRepository;

import com.aurovind.springdata.filedata.entity.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
