package me.theowm.usermicroservice.services;

import me.theowm.usermicroservice.entities.Like;
import me.theowm.usermicroservice.entities.MediaType;
import me.theowm.usermicroservice.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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

    @Override
    public List<UUID> getLikesForUser(UUID userId) {
        return likeRepository.findByUserUuid(userId)
                .stream()
                .map(Like::getMediaUuid)
                .toList();
    }

    @Override
    public Map<String, List<UUID>> getUserLikes(UUID userId) {
        List<Like> likes = likeRepository.findByUserUuid(userId);

        return Map.of(
                "music", likes.stream().filter(l -> l.getMediaType() == MediaType.MUSIC).map(Like::getMediaUuid).toList(),
                "video", likes.stream().filter(l -> l.getMediaType() == MediaType.VIDEO).map(Like::getMediaUuid).toList(),
                "podcast", likes.stream().filter(l -> l.getMediaType() == MediaType.PODCAST).map(Like::getMediaUuid).toList()
        );
    }
}
