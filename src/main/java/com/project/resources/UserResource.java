package com.project.resources;

import com.project.domains.User;
import com.project.domains.dtos.UserDTO;
import com.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        User obj = this.userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<UserDTO> findByCpf(@PathVariable String cpf) {
        User obj = this.userService.findByCpf(cpf);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<UserDTO> findByEmail(@PathVariable String email) {
        User obj = this.userService.findByEmail(email);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

}
