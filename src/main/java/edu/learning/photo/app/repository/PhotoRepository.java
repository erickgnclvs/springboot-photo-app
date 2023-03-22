package edu.learning.photo.app.repository;

import edu.learning.photo.app.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {

}
