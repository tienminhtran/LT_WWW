

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.Skill;

import java.util.List;
import java.util.Optional;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Optional<Candidate> findByEmail(String email);
    // Tìm các ứng viên có ít nhất một trong các kỹ năng được truyền vào
    @Query("SELECT c FROM Candidate c JOIN c.candidateSkills cs WHERE cs.skill IN :skills")
    List<Candidate> findCandidatesWithSkills(@Param("skills") List<Skill> skills);
}
