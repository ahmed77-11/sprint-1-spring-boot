package com.ahmed.motos.restcontrollers;

import com.ahmed.motos.entities.Model;
import com.ahmed.motos.repos.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mod")
@CrossOrigin(origins = "http://localhost:4200/")
public class ModelRESTController {
    @Autowired
    ModelRepository modelRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Model> getAllModels(){
        return modelRepository.findAll();
    }
    @RequestMapping(value = "/{id}",method =RequestMethod.GET)
    public Model getModelById(@PathVariable("id") Long id){
        return modelRepository.findById(id).get();
    }
}

