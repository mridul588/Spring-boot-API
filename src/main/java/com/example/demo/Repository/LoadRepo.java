package com.example.demo.Repository;

import com.example.demo.model.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoadRepo extends JpaRepository<Load, String> {

    Optional<Load> findByShipperId(String shipperId);

    // Add more custom query methods as needed
    // For example:
    // List<Load> findBySomeOtherProperty(String someOtherProperty);
}
