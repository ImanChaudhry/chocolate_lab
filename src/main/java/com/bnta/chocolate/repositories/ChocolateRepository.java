package com.bnta.chocolate.repositories;

import com.bnta.chocolate.models.Chocolate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ChocolateRepository extends JpaRepository<Chocolate, Long> {

    List<Chocolate> findChocolateByType(String type);
}
