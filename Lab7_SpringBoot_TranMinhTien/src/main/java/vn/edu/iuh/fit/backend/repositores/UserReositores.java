package vn.edu.iuh.fit.backend.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.User;

@Repository
public interface UserReositores extends JpaRepository<User, Long> {
}
