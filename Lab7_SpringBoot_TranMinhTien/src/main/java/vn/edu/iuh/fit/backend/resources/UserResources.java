package vn.edu.iuh.fit.backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.repositores.UserReositores;
import vn.edu.iuh.fit.backend.services.UserServices;

import java.util.List;

@RestController()
@RequestMapping("/api/user")
public class UserResources {
    @Autowired
    private UserServices userServices;

    @Autowired
    private UserReositores userReositores;

    @GetMapping("")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userServices.getAll_Nopaing());
    }
}
