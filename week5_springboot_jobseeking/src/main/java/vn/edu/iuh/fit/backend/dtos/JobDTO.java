

package vn.edu.iuh.fit.backend.dtos;
/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.backend.enums.SkillLevel;

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
