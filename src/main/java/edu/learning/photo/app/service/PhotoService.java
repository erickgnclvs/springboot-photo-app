package edu.learning.photo.app.service;

import edu.learning.photo.app.model.Photo;
import edu.learning.photo.app.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }


    public Iterable<Photo> getPhotos() {
        return photoRepository.findAll();
    }

    public Optional<Photo> getPhotoById(Integer id) {
        return photoRepository.findById(id);
    }

    public void remove(Integer id) {
        photoRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFilename(fileName);
        photo.setData(data);
        photoRepository.save(photo);
        return photo;
    }
}
