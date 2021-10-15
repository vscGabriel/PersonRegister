package com.gvsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gvsc.models.PersonModel;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long>{

}
