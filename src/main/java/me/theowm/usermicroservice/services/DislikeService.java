package me.theowm.usermicroservice.services;

import me.theowm.usermicroservice.entities.Dislike;
import me.theowm.usermicroservice.entities.Like;
import me.theowm.usermicroservice.entities.MediaType;
import me.theowm.usermicroservice.repositories.DislikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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

    @Override
    public List<UUID> getDislikesForUser(UUID userId) {
        return dislikeRepository.findByUserUuid(userId)
                .stream()
                .map(Dislike::getMediaUuid)
                .toList();
    }

    @Override
    public Map<String, List<UUID>> getUserDislikes(UUID userId) {
        List<Dislike> dislikes = dislikeRepository.findByUserUuid(userId);

        return Map.of(
                "music", dislikes.stream().filter(l -> l.getMediaType() == MediaType.MUSIC).map(Dislike::getMediaUuid).toList(),
                "video", dislikes.stream().filter(l -> l.getMediaType() == MediaType.VIDEO).map(Dislike::getMediaUuid).toList(),
                "podcast", dislikes.stream().filter(l -> l.getMediaType() == MediaType.PODCAST).map(Dislike::getMediaUuid).toList()
        );
    }

}
