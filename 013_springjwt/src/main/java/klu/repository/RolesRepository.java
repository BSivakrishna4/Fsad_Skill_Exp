package klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import klu.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

}
