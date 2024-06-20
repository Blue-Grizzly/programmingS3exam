package grizzly.programmings3exam.security.repository;

import grizzly.programmings3exam.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
