package edu.learning.photo.app.web;

import edu.learning.photo.app.model.Photo;
import edu.learning.photo.app.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Optional;

@RestController
public class PhotoController {

    @Autowired
    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }


    @GetMapping("/")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/photos")
    public Iterable<Photo> getPhotos() {
        return photoService.getPhotos();
    }

    @GetMapping("/photos/{id}")
    public Optional<Photo> getPhoto(@PathVariable Integer id) {
        Optional<Photo> photo = photoService.getPhotoById(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable Integer id) {
        photoService.remove(id);
    }

    @PostMapping("/photos")
    public Photo createPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }


}
