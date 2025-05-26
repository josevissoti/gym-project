package com.project.services;

import com.project.domains.User;
import com.project.domains.dtos.UserDTO;
import com.project.repositories.UserRepository;
import com.project.services.exceptions.DataIntegrityViolationException;
import com.project.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("User not found. ID: " + id));
    }

    public User findByCpf(String cpf) {
        Optional<User> obj = userRepository.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("User not found. CPF: " + cpf));
    }

    public User findByEmail(String email) {
        Optional<User> obj = userRepository.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("User not found. Email: " + email));
    }

    public User create(UserDTO dto) {
        dto.setIdPerson(null);
        User obj = new User(dto);
        return userRepository.save(obj);
    }

    public User update(Long id, UserDTO objDto) {
        objDto.setIdPerson(id);
        User oldObj = findById(id);
        cpfAndEmailValidation(objDto);
        oldObj = new User(objDto);
        return userRepository.save(oldObj);
    }

    public void delete(Long id) {
        User obj = findById(id);
        if (!obj.getOrders().isEmpty()) {
            throw new DataIntegrityViolationException("User cannot be Deleted because has linked Orders");
        }
        userRepository.deleteById(id);
    }

    private void cpfAndEmailValidation(UserDTO dto) {
        Optional<User> obj = userRepository.findByCpf(dto.getCpf());
        if (obj.isPresent() && obj.get().getIdPerson() != dto.getIdPerson()) {
            throw new DataIntegrityViolationException("CPF already registered");
        }

        obj = userRepository.findByEmail(dto.getEmail());
        if (obj.isPresent() && obj.get().getIdPerson() != dto.getIdPerson()) {
            throw new DataIntegrityViolationException("Email already registered");
        }
    }

}
