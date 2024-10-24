package com.ahmed.motos.restcontrollers;

import com.ahmed.motos.entities.Image;
import com.ahmed.motos.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        return imageService.uploadImage(file);
    }

    @RequestMapping(value = "/get/info/{id}",method = RequestMethod.GET)
    public Image getImageDetails(@PathVariable("id") Long id) throws IOException{
        return imageService.getImageDetails(id);
    }
    @RequestMapping(value = "/load/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException{
        return imageService.getImage(id);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void deleteImage(@PathVariable("id") Long id){
        imageService.deleteImage(id);
    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Image updateImage(@RequestParam("image") MultipartFile file) throws IOException{
        return imageService.uploadImage(file);
    }
    @PostMapping(value = "/uploadImageMoto/{idMoto}")
    public Image uploadImageMoto(@RequestParam("image") MultipartFile file,@PathVariable("idMoto") Long idMoto) throws IOException {
        return imageService.uploadImageMoto(file,idMoto);
    }
    @RequestMapping(value = "/getImagesParMoto/{idMoto}",method = RequestMethod.GET)
    public List<Image> getImagesParMoto(@PathVariable("idMoto") Long idMoto){
        return imageService.getImagesParProd(idMoto);
    }
}
