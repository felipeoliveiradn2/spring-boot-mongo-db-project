package com.felipeoliveira.mongodbproject.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.felipeoliveira.mongodbproject.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);	
	
	//query methods, faz o spring data criar uma consulta, nesse caso do título
	List<Post> findByTitleContainingIgnoreCase(String text);
	
}
