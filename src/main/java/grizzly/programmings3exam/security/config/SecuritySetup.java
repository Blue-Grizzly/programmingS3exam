package grizzly.programmings3exam.security.config;

import grizzly.programmings3exam.security.entity.Role;
import grizzly.programmings3exam.security.repository.RoleRepository;
import grizzly.programmings3exam.security.repository.SpecialUserRepository;
import grizzly.programmings3exam.security.repository.UserWithRolesRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecuritySetup implements ApplicationRunner {

    final UserWithRolesRepository userWithRolesRepository;
    final RoleRepository roleRepository;

    public SecuritySetup(UserWithRolesRepository userWithRolesRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, SpecialUserRepository specialUserRepository) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.roleRepository = roleRepository;
    }

    public void run(ApplicationArguments args) {
        setupAllowedRoles();
    }

    private void setupAllowedRoles() {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
    }
}
