package edu.learning.photo.app;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class PhotoController {

    private Map<String, Photo> db =new HashMap<>() {{
        put("1", new Photo("1", "hello.jpg"));
    }};

    @GetMapping("/")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/photos")
    public Collection<Photo> getPhotos() {
        return db.values();
    }

    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable String id) {
        Photo photo = db.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable String id) {
        Photo photo = db.remove(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/photos")
    public Photo createPhoto(@RequestBody @Valid Photo photo) {
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
        return photo;
    }


}
