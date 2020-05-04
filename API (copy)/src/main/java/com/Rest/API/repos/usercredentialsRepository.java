package com.Rest.API.repos;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Rest.API.model.usercredentials;
@Repository
public interface usercredentialsRepository extends JpaRepository<usercredentials, Long> {
	@Query("Select Count(*) from usercredentials where email=?1 ")
	 Long findbyemail(String email);
	
	
}