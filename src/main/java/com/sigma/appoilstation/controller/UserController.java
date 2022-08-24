package com.sigma.appoilstation.controller;

import com.sigma.appoilstation.entity.User;
import com.sigma.appoilstation.mapper.UserMapper;
import com.sigma.appoilstation.payload.UserDTO;
import com.sigma.appoilstation.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepo userRepo;

    private final UserMapper userMapper;

    @GetMapping("/{page}/{size}")
    public Map<String,Object> getAll(@PathVariable int page, @PathVariable int size) {
        Pageable pageable = PageRequest.of(page,size,Sort.by("startDate").descending());
//        Pageable pageable = PageRequest.of(start, end,Sort.by("firstname"));
        Page<User> all = userRepo.findAll(pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("materials", all.toList());
        response.put("currentPage", all.getNumber());
        response.put("totalItems", all.getTotalElements());
        response.put("totalPages", all.getTotalPages());
        return response;
    }

//    @GetMapping("/findIsActive")
//    public List<User> find()
//    {
//        return userRepo.findAllByActiveFalse();
//    }

    @GetMapping
    public List<User> getOneHour(){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        return userRepo.getAllByStartDateBetween(new Timestamp(timestamp.getTime()-2678400000L),timestamp,Sort.by("startDate").descending());
    }

    @PostMapping
    public User create(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setLastname(userDTO.getLastname());
        user.setFirstname(userDTO.getFirstname());
        user.setAge(userDTO.getAge());
        user.setActive(true);

        return userRepo.save(user);

    }

    @PutMapping("/{id}")
    public User edit(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        Optional<User> optionalUser = userRepo.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            userMapper.update(userDTO,user);

            userRepo.save(user);

            return user;
        }

        return new User();
    }

//    @PutMapping("/{id}")
//    public User edit(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
//        Optional<User> optionalUser = userRepo.findById(id);
//
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//
//            user.setLastname(userDTO.getLastname());
//            user.setFirstname(userDTO.getFirstname());
//            user.setAge(userDTO.getAge());
//
//            userRepo.save(user);
//
//            return user;
//        }
//
//        return new User();
//    }
}
