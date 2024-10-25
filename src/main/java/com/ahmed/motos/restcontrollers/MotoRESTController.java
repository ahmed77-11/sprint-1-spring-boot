package com.ahmed.motos.restcontrollers;

import java.util.List;

import com.ahmed.motos.dto.MotoDTO;
import com.ahmed.motos.entities.Moto;
import com.ahmed.motos.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MotoRESTController {

    @Autowired
    MotoService motoService;

    @RequestMapping(path = "/all",method = RequestMethod.GET)
    public List<Moto> getAllMotos(){
        return motoService.getAllMotos();
    }
    @RequestMapping(value="/getbyid/{id}",method=RequestMethod.GET)
    public Moto getMotoById(@PathVariable("id") Long id){
        return motoService.getMoto(id);
    }
    @RequestMapping(path = "/addmoto",method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Moto createMoto(@RequestBody(required = false) Moto moto) {
        System.out.println("added");
        return motoService.saveMoto(moto);
    }
    @RequestMapping(path = "/updatemoto",method = RequestMethod.PUT)
    public Moto updateProduit(@RequestBody Moto moto) {
    	return motoService.updateMoto(moto);
    }

    @RequestMapping(value = "/delmoto/{id}",method = RequestMethod.DELETE)
    public void deleteMoto(@PathVariable("id") long id){
        motoService.deleteMotoById(id);
    }
    @RequestMapping(value="/motosmod/{idModel}",method = RequestMethod.GET)
    public List<Moto> getMotosByModelId(@PathVariable("idModel") Long idModel){
        return motoService.findByModelIdModel(idModel);
    }
    @RequestMapping(value ="/motosByMarque/{marque}",method = RequestMethod.GET)
    public List<Moto> findByMarqueMotoContains(@PathVariable("marque") String marque){
        return motoService.findByMarqueMotoContains(marque);
    }
}
