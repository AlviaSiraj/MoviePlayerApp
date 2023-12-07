package dev.alviamovies.movieplayer.controllers;

import dev.alviamovies.movieplayer.services.ReviewService;
import dev.alviamovies.movieplayer.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")

public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String>payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("imdbId"),payload.get("reviewBody")), HttpStatus.CREATED);
    }
    @GetMapping("/{imdbId}")
    public ResponseEntity<List<Review>> getMovieReview(@PathVariable String imdbId) {
        return new ResponseEntity<List<Review>>(reviewService.getMovieReviews(imdbId), HttpStatus.OK);
    }

}
