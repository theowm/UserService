package me.theowm.usermicroservice.repositories;

import me.theowm.usermicroservice.entities.Dislike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DislikeRepository extends JpaRepository<Dislike, UUID> {
    List<Dislike> findByUserUuid(UUID userUuid);
}
