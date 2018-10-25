package com.marcelolfranca.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.marcelolfranca.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	//abaixo o regex: ?0 serve para pegar o primeiro parâmetro (variável) da função. No caso, a variável text
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle (String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
