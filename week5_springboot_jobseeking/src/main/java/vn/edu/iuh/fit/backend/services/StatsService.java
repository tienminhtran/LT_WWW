/*
 * @ {#} StatsService.java   1.0     08/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.backend.repositories.JobSkillRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Service
public class StatsService {
    @Autowired
    private JobSkillRepository jobSkillRepository;

    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    // Lấy ra top kỹ năng được yêu cầu nhiều nhất trong các công việc
    public Map<String, Long> getTopSkillsInJobs() {
        List<Object[]> results = jobSkillRepository.findTopSkillsInJobs();
        return results.stream()
                .sorted((o1, o2) -> Long.compare((Long) o2[1], (Long) o1[1])) // Sắp xếp giảm dần theo số lượng
                .collect(Collectors.toMap(
                        obj -> (String) obj[0],
                        obj -> (Long) obj[1],
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new // Giữ thứ tự đã sắp xếp
                ));
    }
    // Lấy ra top kỹ năng mà ứng viên có nhiều nhất
    public Map<String, Long> getTopSkillsInCandidates() {
        List<Object[]> results = candidateSkillRepository.findTopSkillsInCandidates();
        return results.stream()
                .sorted((o1, o2) -> Long.compare((Long) o2[1], (Long) o1[1])) // Sắp xếp giảm dần theo số lượng
                .collect(Collectors.toMap(
                        obj -> (String) obj[0],
                        obj -> (Long) obj[1],
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new // Giữ thứ tự đã sắp xếp
                ));
    }
}
