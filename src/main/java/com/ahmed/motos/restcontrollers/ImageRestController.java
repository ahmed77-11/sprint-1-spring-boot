package com.ahmed.motos.restcontrollers;

import com.ahmed.motos.entities.Image;
import com.ahmed.motos.entities.Moto;
import com.ahmed.motos.service.ImageService;
import com.ahmed.motos.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
    @Autowired
    ImageService imageService;

    @Autowired
    MotoService motoService;

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
    @RequestMapping(value = "/uploadFS/{id}",method = RequestMethod.POST)
    public void uploadImageFS(@RequestParam("image") MultipartFile file,@PathVariable("id") Long id) throws IOException {
        Moto m=motoService.getMoto(id);
        m.setImagePath(id+".jpg");
        Files.write(Paths.get(System.getProperty("user.home")+"/images111/"+m.getImagePath()), file.getBytes());
        motoService.saveMoto(m);
    }

    @RequestMapping(value = "/loadfromFS/{id}",method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {
        Moto m=motoService.getMoto(id);
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images111/"+m.getImagePath()));
    }
}
