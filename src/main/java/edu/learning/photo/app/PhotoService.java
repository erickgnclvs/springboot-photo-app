package edu.learning.photo.app;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotoService {

    private Map<String, Photo> db =new HashMap<>() {{
        put("1", new Photo("1", "hello.jpg"));
    }};

    public Collection<Photo> getPhotos() {
        return db.values();
    }

    public Photo getPhotoById(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo save(String fileName, byte[] data) {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFilename(fileName);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }
}
