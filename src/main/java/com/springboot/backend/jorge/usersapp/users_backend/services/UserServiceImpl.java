package com.springboot.backend.jorge.usersapp.users_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.jorge.usersapp.users_backend.entities.User;
import com.springboot.backend.jorge.usersapp.users_backend.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List) this.repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
