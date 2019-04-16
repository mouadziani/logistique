package org.logistique.dao.repositories;

import org.logistique.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
