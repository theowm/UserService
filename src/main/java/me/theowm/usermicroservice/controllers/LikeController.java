package me.theowm.usermicroservice.controllers;

import me.theowm.usermicroservice.DTOs.UserLikesResponseDTO;
import me.theowm.usermicroservice.entities.Like;
import me.theowm.usermicroservice.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("/alllikes")
    public ResponseEntity<List<Like>> getAllLikes() {
        return ResponseEntity.ok(likeService.fetchAllLikes());
    }

    @PostMapping("/addlike")
    public ResponseEntity<Like> addNewLike(@RequestBody Like like) {
        return new ResponseEntity<>(likeService.addNewLike(like), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletelike/{likeId}")
    public ResponseEntity<String> deleteLikeById(@PathVariable UUID likeId) {
        likeService.deleteLike(likeId);
        return ResponseEntity.ok("LIKE with id " + likeId + " was deleted successfully");
    }

    @PutMapping("/updatelike/{likeId}")
    public ResponseEntity<Like> updateLike(@PathVariable UUID likeId, @RequestBody Like like) {
        return ResponseEntity.ok(likeService.updateLike(likeId, like));
    }

    @GetMapping("/userlikes/{userId}")
    public ResponseEntity<UserLikesResponseDTO> getLikesForUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(likeService.getLikesForUser(userId));
    }

}
