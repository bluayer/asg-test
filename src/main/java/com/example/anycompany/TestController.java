package com.example.anycompany;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class TestController {
    private final TestService memberService;

    @GetMapping("")
    public ResponseEntity<List<Member>> getMember () {
        val members = memberService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(members);
    }

    @PostMapping("")
    public ResponseEntity<Member> createMember () {
        val member = memberService.createUser();
        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }
}
