package com.nicoz.NZWanderlust.Controllers;

import com.nicoz.NZWanderlust.NewReputationScoreRequest;
import com.nicoz.NZWanderlust.Entities.ReputationScore;
import com.nicoz.NZWanderlust.Services.ReputationScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReputationScoreController {
    private final ReputationScoreService reputationScoreService;

    public ReputationScoreController(ReputationScoreService reputationScoreService) {
        this.reputationScoreService = reputationScoreService;
    }

    @GetMapping("/reputationScore/")
    public List<ReputationScore> getAllReputationScore() {
        return reputationScoreService.getReputationScore();
    }

    @PostMapping("/reputationScore/")
    public void addReputationScore(@RequestBody NewReputationScoreRequest request) {
        reputationScoreService.addReputationScore(request);
    }

    @PutMapping("/reputationScore/{id}")
    public ResponseEntity<ReputationScore> updateReputationScore(@RequestBody ReputationScore reputationScore, @PathVariable Long id) {
        return reputationScoreService.updateReputationScore(id, reputationScore);
    }

    @DeleteMapping("/reputationScore/{id}")
    public void deleteReputationScore(@PathVariable Long id) {
        reputationScoreService.delete(id);
    }
}