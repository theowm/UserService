package me.theowm.usermicroservice.services;

import me.theowm.usermicroservice.entities.Dislike;
import me.theowm.usermicroservice.entities.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface DislikeServiceInterface {
    List<Dislike> fetchAllDislikes();
    Dislike addNewDislike(Dislike dislike);
    Dislike updateDislike(UUID id, Dislike dislike);
    void deleteDislike(UUID id);
    public List<UUID> getDislikesForUser(UUID userId);
    public Map<String, List<UUID>> getUserDislikes(UUID userId);
}
