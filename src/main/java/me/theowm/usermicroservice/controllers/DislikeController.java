package me.theowm.usermicroservice.controllers;

import me.theowm.usermicroservice.DTOs.UserDislikesResponseDTO;
import me.theowm.usermicroservice.entities.Dislike;
import me.theowm.usermicroservice.entities.Like;
import me.theowm.usermicroservice.services.DislikeService;
import me.theowm.usermicroservice.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dislikes")
public class DislikeController {

    private final DislikeService dislikeService;

    @Autowired
    public DislikeController(DislikeService dislikeService) {
        this.dislikeService = dislikeService;
    }

    @GetMapping("/alldislikes")
    public ResponseEntity<List<Dislike>> getAllDislikes() {
        return ResponseEntity.ok(dislikeService.fetchAllDislikes());
    }

    @PostMapping("/adddislike")
    public ResponseEntity<Dislike> addNewDislike(@RequestBody Dislike dislike) {
        return new ResponseEntity<>(dislikeService.addNewDislike(dislike), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletedislike/{dislikeId}")
    public ResponseEntity<String> deleteDislikeById(@PathVariable UUID dislikeId) {
        dislikeService.deleteDislike(dislikeId);
        return ResponseEntity.ok("Dislike with id " + dislikeId + " was deleted successfully");
    }

    @PutMapping("/updatedislike/{dislikeId}")
    public ResponseEntity<Dislike> updateDislike(@PathVariable UUID dislikeId, @RequestBody Dislike dislike) {
        return ResponseEntity.ok(dislikeService.updateDislike(dislikeId, dislike));
    }

    @GetMapping("/userdislikes/{userId}")
    public ResponseEntity<UserDislikesResponseDTO> getDislikesForUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(dislikeService.getDislikesForUser(userId));
    }

}
