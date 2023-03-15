package com.example.anycompany;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class TestService {
    private final TestRepository testRepository;

    @Transactional(readOnly = true)
    public List<Member> getAllUsers () {
        return testRepository.findAll();
    }

    private String randomStr (int targetStringLength) {
        val leftLimit = 97;
        val rightLimit = 122;
        val random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @Transactional
    public Member createUser() {
        return testRepository.save(Member.builder()
                        .email(randomStr(10) + "@" + "anycompany.com")
                        .name(randomStr(10))
                        .skill(randomStr(15))
                        .introduction("Hi, Anycompany : " + randomStr(10)).build());
    }
}
