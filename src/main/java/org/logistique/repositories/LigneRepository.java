package org.logistique.repositories;

import org.logistique.entities.Ligne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneRepository extends JpaRepository<Ligne, Long> {

}
