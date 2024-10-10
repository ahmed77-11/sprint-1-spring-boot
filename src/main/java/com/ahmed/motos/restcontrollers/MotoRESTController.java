package com.ahmed.motos.restcontrollers;

import java.util.List;

import com.ahmed.motos.dto.MotoDTO;
import com.ahmed.motos.entities.Moto;
import com.ahmed.motos.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.GET)
    public List<MotoDTO> getAllMotos(){
        return motoService.getAllMotos();
    }
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public MotoDTO getMotoById(@PathVariable("id") Long id){
        return motoService.getMoto(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public MotoDTO createMoto(@RequestBody(required = false) MotoDTO moto) {
         return motoService.saveMoto(moto);

    }
    @RequestMapping(method = RequestMethod.PUT)
    public MotoDTO updateProduit(@RequestBody MotoDTO moto) {
    	return motoService.updateMoto(moto);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
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
