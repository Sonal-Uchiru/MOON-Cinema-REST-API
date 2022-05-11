package com.github.vlsidlyarevich.service;

import com.github.vlsidlyarevich.model.User;
import com.github.vlsidlyarevich.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class BasicUserService implements UserService {

    private final UserRepository repository;

    @Autowired
    public BasicUserService(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(final User user) throws Exception {
        final User dbUserByUsername  = this.findByUsername(user.getUsername());
        final User dbUserByEmail = this.findByEmail(user.getEmail());
        if(dbUserByUsername == null && dbUserByEmail == null){
            user.setPassword(hashPassword(user.getPassword()));
            user.setCreatedAt(String.valueOf(LocalDateTime.now()));
            return repository.save(user);
        }else{
            throw new Exception("Conflict Exception");
        }

    }

    @Override
    public User find(final String id) {
        return repository.findOne(id);
    }

    @Override
    public User findByUsername(final String userName) {
        return repository.findByUsername(userName);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User update(final String id, final User user) {
        user.setId(id);

        final User saved = repository.findOne(id);

        if (saved != null) {
            user.setCreatedAt(saved.getCreatedAt());
            user.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        } else {
            user.setCreatedAt(String.valueOf(LocalDateTime.now()));
        }
        repository.save(user);
        return user;
    }

    @Override
    public void updatePassword(String email, String password) throws Exception {
        User user = findByEmail(email);
        if(user != null) {
            user.setPassword(hashPassword(password));
            user.setUpdatedAt(String.valueOf(LocalDateTime.now()));
            repository.save(user);
        }else{
            throw new Exception("User not found");
        }

    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public String delete(final String id) {
        repository.delete(id);
        return id;
    }

    public String hashPassword(final String password) {
        int strength = 10; // work factor of bcrypt
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(strength, new SecureRandom());
        return bCryptPasswordEncoder.encode(password);
    }
}
