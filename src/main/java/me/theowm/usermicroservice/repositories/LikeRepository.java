package me.theowm.usermicroservice.repositories;

import me.theowm.usermicroservice.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LikeRepository extends JpaRepository<Like, UUID> {
    List<Like> findByUserUuid(UUID userUuid);
}
