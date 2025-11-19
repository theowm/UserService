package me.theowm.usermicroservice.services;

import me.theowm.usermicroservice.DTOs.UserLikesResponseDTO;
import me.theowm.usermicroservice.entities.Like;
import me.theowm.usermicroservice.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LikeService implements LikeServiceInterface {

    private final LikeRepository likeRepository;

    @Autowired
    public LikeService(LikeRepository repository) {
        this.likeRepository = repository;
    }


    @Override
    public List<Like> fetchAllLikes() {
        return likeRepository.findAll();
    }

    @Override
    public Like addNewLike(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public Like updateLike(UUID id, Like like) {
        return likeRepository.save(like);
    }

    @Override
    public void deleteLike(UUID id) {
        likeRepository.deleteById(id);
    }

    public UserLikesResponseDTO getLikesForUser(UUID userId) {
        List<Like> likes = likeRepository.findByUserUuid(userId);

        List<UUID> mediaIds = likes.stream()
                .map(Like::getMediaUuid)
                .toList();

        return new UserLikesResponseDTO(userId, mediaIds);
    }
}
