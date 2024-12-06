

package vn.edu.iuh.fit.backend.dtos;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.backend.models.SkillLevel;

import java.util.List;
import java.util.Map;


@Getter
@Setter
public class JobDTO {
    private Long jobId;
    private String jobName;
    private String jobDesc;
    private Long companyId;
    private List<Long> skillIds;
}
