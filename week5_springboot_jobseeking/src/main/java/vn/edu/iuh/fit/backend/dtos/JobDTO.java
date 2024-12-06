/*
 * @ {#} JobDTO.java   1.0     08/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.dtos;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.backend.models.SkillLevel;

import java.util.List;
import java.util.Map;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   08/11/2024
 * @version:    1.0
 */
@Getter
@Setter
public class JobDTO {
    private Long jobId;
    private String jobName;
    private String jobDesc;
    private Long companyId;
    private List<Long> skillIds;
}
