
package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.repositories.CandidateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);
    }
    public Candidate findByEmail(String email) {
        return candidateRepository.findByEmail(email).orElse(null);
    }
    public List<Candidate> findCandidatesForJob(Job job) {
        List<Skill> requiredSkills = new ArrayList<>();

        for (JobSkill jobSkill : job.getJobSkills()) {
            requiredSkills.add(jobSkill.getSkill());
        }
        return candidateRepository.findCandidatesWithSkills(requiredSkills);
    }

    public Candidate findById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }
}
