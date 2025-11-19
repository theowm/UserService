package me.theowm.usermicroservice.DTOs;

import java.util.List;
import java.util.UUID;

public class UserDislikesResponseDTO {
    private UUID userId;
    private List<UUID> dislikedMedia;

    public UserDislikesResponseDTO(UUID userId, List<UUID> dislikedMedia) {
        this.userId = userId;
        this.dislikedMedia = dislikedMedia;
    }

    public UUID getUserId() {
        return userId;
    }

    public List<UUID> getDislikedMedia() {
        return dislikedMedia;
    }
}
