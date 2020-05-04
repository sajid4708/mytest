package com.Rest.API.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Rest.API.model.Group;


public interface Grouprepos extends  JpaRepository<Group, Long> {

}
