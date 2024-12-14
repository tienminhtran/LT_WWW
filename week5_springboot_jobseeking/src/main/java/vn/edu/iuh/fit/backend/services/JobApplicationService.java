/*
 * @ {#} JobApplicationService.java   1.0     08/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.models.JobSkill;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Service
public class JobApplicationService {
    @Autowired
    private JavaMailSender mailSender;
    // Gửi email ứng tuyển công việc
    public void sendApplication(String jobId, String applicantName, String email, String messageContent, Job job, Candidate candidate) throws MessagingException {
        // Lấy email của nhà tuyển dụng
        String toEmail = job.getCompany().getEmail();
        String subject = "New Job Application for Job ID: " + jobId;

        // Tạo nội dung email
        StringBuilder body = new StringBuilder();
        body.append("<html>")
                .append("<head>")
                .append("<style>")
                .append("body { font-family: Arial, sans-serif; line-height: 1.6; margin: 20px; }")
                .append("h3, h4 { color: #2c3e50; }")
                .append("p { margin: 5px 0; }")
                .append("ul { margin: 10px 0; padding-left: 20px; }")
                .append("</style>")
                .append("</head>")
                .append("<body>")
                .append("<h3>Job Application Details</h3>")
                .append("<p><strong>Applicant Name:</strong> ").append(candidate.getFullName()).append("</p>")
                .append("<p><strong>Email:</strong> ").append(candidate.getEmail()).append("</p>")
                .append("<p><strong>Phone:</strong> ").append(candidate.getPhone()).append("</p>")
                .append("<p><strong>Date of Birth:</strong> ").append(candidate.getDob()).append("</p>")
                .append("<h4>Candidate Address</h4>")
                .append("<p>").append(candidate.getAddress().getAddress()).append("</p>")
                .append("<h4>Job Details</h4>")
                .append("<p><strong>Job Name:</strong> ").append(job.getJobName()).append("</p>")
                .append("<p><strong>Job Description:</strong></p>")
                .append("<p>").append(job.getJobDesc()).append("</p>")
                .append("<h4>Required Skills</h4>")
                .append("<ul>");
        for (JobSkill jobSkill : job.getJobSkills()) {
            body.append("<li>")
                    .append(jobSkill.getSkill().getSkillName())
                    .append(" - Level: ").append(jobSkill.getSkillLevel())
                    .append("</li>");
        }
        body.append("</ul>")
                .append("<h4>Company Information</h4>")
                .append("<p><strong>Company Name:</strong> ").append(job.getCompany().getCompName()).append("</p>")
                .append("<p><strong>About:</strong> ").append(job.getCompany().getAbout()).append("</p>")
                .append("<p><strong>Email:</strong> ").append(job.getCompany().getEmail()).append("</p>")
                .append("<p><strong>Phone:</strong> ").append(job.getCompany().getPhone()).append("</p>")
                .append("<p><strong>Website:</strong> <a href=\"").append(job.getCompany().getWebUrl()).append("\">")
                .append(job.getCompany().getWebUrl()).append("</a></p>")
                .append("<p><strong>Address:</strong> ").append(job.getCompany().getAddress().getAddress()).append("</p>")
                .append("<h4>Message:</h4>")
                .append("<p>").append(messageContent).append("</p>")
                .append("</body>")
                .append("</html>");

        // Tạo MimeMessage
        MimeMessage message = mailSender.createMimeMessage();
        message.setHeader("Content-Type", "text/html; charset=UTF-8");
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(body.toString(), true); // Set to true to indicate that the content is HTML

        // Gửi email
        mailSender.send(message);
    }

}
