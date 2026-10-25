package com.crewManagement.crew.Repo;

import com.crewManagement.crew.entity.CrewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository<CrewEntity, Long> {

}
