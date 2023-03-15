package com.example.anycompany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Member, Long> {
}
