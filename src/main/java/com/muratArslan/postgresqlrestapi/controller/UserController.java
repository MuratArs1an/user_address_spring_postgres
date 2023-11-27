package com.muratArslan.postgresqlrestapi.controller;

import com.muratArslan.postgresqlrestapi.dto.UserDto;
import com.muratArslan.postgresqlrestapi.entity.Address;
import com.muratArslan.postgresqlrestapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Api(value="User API Documentation")
public class  UserController {
    private final UserService userService;

    @PostMapping
    @ApiOperation(value = "Add new User")
    public ResponseEntity<UserDto> add(@RequestBody @ApiParam  UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }
    @GetMapping
    @ApiOperation(value="List of All Users")
    public ResponseEntity<List<UserDto>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
}
