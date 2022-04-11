package com.example.json_demo.services;

import com.example.json_demo.model.Entity.User;
import com.example.json_demo.model.dto.UserSeedDto;
import com.example.json_demo.repository.UserRepository;
import com.example.json_demo.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedUser() throws IOException {
        if(userRepository.count()==0) {
            Arrays.stream(gson.fromJson(Files.readString(Path.of("src/main/resources/files/users.json")), UserSeedDto[].class))
                    .filter(validationUtil::isValid).map(userSeedDto -> modelMapper.map(userSeedDto, User.class)).forEach(userRepository::save);
        }}

    @Override
    public User findRandomUser() {
        long randomId= ThreadLocalRandom.current().nextLong(1, userRepository.count()+1);
        return userRepository.findById(randomId).orElse(null);
    }
}
