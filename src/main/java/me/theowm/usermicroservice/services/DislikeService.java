package me.theowm.usermicroservice.services;

import me.theowm.usermicroservice.DTOs.UserDislikesResponseDTO;
import me.theowm.usermicroservice.DTOs.UserLikesResponseDTO;
import me.theowm.usermicroservice.entities.Dislike;
import me.theowm.usermicroservice.entities.Like;
import me.theowm.usermicroservice.entities.User;
import me.theowm.usermicroservice.repositories.DislikeRepository;
import me.theowm.usermicroservice.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DislikeService implements DislikeServiceInterface {

    private final DislikeRepository dislikeRepository;

    @Autowired
    public DislikeService(DislikeRepository repository) {
        this.dislikeRepository = repository;
    }


    @Override
    public List<Dislike> fetchAllDislikes() {
        return dislikeRepository.findAll();
    }

    @Override
    public Dislike addNewDislike(Dislike dislike) {
        return dislikeRepository.save(dislike);
    }

    @Override
    public Dislike updateDislike(UUID id, Dislike dislike) {
        return dislikeRepository.save(dislike);
    }

    @Override
    public void deleteDislike(UUID id) {
        dislikeRepository.deleteById(id);
    }

    public UserDislikesResponseDTO getDislikesForUser(UUID userId) {
        List<Dislike> dislikes = dislikeRepository.findByUserUuid(userId);

        List<UUID> mediaIds = dislikes.stream()
                .map(Dislike::getMediaUuid)
                .toList();

        return new UserDislikesResponseDTO(userId, mediaIds);
    }
}
