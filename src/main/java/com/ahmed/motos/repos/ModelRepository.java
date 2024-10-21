package com.ahmed.motos.repos;

import com.ahmed.motos.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(path = "mod")
@CrossOrigin("http://localhost:4200/")
public interface ModelRepository extends JpaRepository<Model,Long> {

}
