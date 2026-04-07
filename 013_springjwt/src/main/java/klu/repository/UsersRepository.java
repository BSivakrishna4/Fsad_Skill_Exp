package klu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import klu.model.Menus;
import klu.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
	@Query("SELECT U FROM Users U WHERE U.email=:email AND U.password=:password")
	public Users findByEmailandPassword(@Param("email") String email, @Param("password") String password);
	
	@Query("SELECT R.menu FROM RolesMapping R WHERE R.role=:role")
	public	List<Menus> getMenusByRole(@Param("role") Long role);
}
