package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void regist(UserDto user) {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        String pw = user.getPassword();

        List<String> list = new ArrayList<>();
        String hash = null;

        for(char c : pw.toCharArray()) {

            int ascii = (int) c + randomNumber;
            System.out.println(ascii + "1");
            list.add(String.valueOf(ascii));
            System.out.println(randomNumber);

        }
        list.add(String.valueOf(randomNumber));
        hash = String.join("", list);

        User u = User.builder()
                .username(user.getUsername())
                .password(hash)
                .name(user.getName())
                .role(user.getRole())  // default role
                .build();

        userRepository.save(u);
    }

    @Override
    public UserDto getUser(UserDto user) {
        User u = new User();

        String username = user.getUsername();

        String pw = user.getPassword();

//        Optional<User> result =  userRepository.findByUsernameAndPassword(username, password);
        Optional<User> result =  userRepository.findById(username);
        System.out.println(result);
        if(result.isPresent()) {
            u = result.get();
        }

        String password = u.getPassword();

        char last = password.charAt(password.length() - 1);
        int lastNumber = Character.getNumericValue(last);
        System.out.println(last + "last");

        List<String> list = new ArrayList<>();

        for (char c : pw.toCharArray()) {
            int ascii = c + lastNumber;
            System.out.println(ascii + "1"  );
            list.add(String.valueOf(ascii));
            System.out.println(last);
        }

        list.add(String.valueOf(last));
        String hashf = String.join("", list);
        System.out.println(hashf);

        if(hashf.equals(u.getPassword())) {
            System.out.println(u + "user");
            return UserDto.builder()
                    .username(u.getUsername())
                    .password(u.getPassword())
                    .name(u.getName())
                    .role(u.getRole())
                    .build();// verify password and username){
        }

//        return user1;
//        Optional<User> result1 =  userRepository.findById(username);
//        System.out.println(result1);

        return null;
    }

}
