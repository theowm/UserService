package me.theowm.usermicroservice.services;

import me.theowm.usermicroservice.entities.Like;
import me.theowm.usermicroservice.entities.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface LikeServiceInterface {
    List<Like> fetchAllLikes();
    Like addNewLike(Like like);
    Like updateLike(UUID id, Like like);
    void deleteLike(UUID id);
    public List<UUID> getLikesForUser(UUID userId);
    public Map<String, List<UUID>> getUserLikes(UUID userId);
}
