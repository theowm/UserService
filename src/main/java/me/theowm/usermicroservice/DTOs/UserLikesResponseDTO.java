package me.theowm.usermicroservice.DTOs;

import java.util.List;
import java.util.UUID;

public class UserLikesResponseDTO {
    private UUID userId;
    private List<UUID> likedMedia;

    public UserLikesResponseDTO(UUID userId, List<UUID> likedMedia) {
        this.userId = userId;
        this.likedMedia = likedMedia;
    }

    public UUID getUserId() {
        return userId;
    }

    public List<UUID> getLikedMedia() {
        return likedMedia;
    }
}
