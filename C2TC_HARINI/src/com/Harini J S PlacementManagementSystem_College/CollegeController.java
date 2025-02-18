package com.tns.collegeservice.controller;

import com.tns.collegeservice.model.College;
import com.tns.collegeservice.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping
    public List<College> getAllColleges() {
        try {
            return collegeService.getAllColleges();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching colleges", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
        try {
            return collegeService.getCollegeById(id)
                    .map(ResponseEntity::ok)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "College not found with id: " + id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching college by id", e);
        }
    }

    @PostMapping
    public ResponseEntity<College> addCollege(@RequestBody College college) {
        try {
            College savedCollege = collegeService.addCollege(college);
            return new ResponseEntity<>(savedCollege, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error saving college", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable Long id, @RequestBody College college) {
        try {
            College updatedCollege = collegeService.updateCollege(id, college);
            if (updatedCollege != null) {
                return ResponseEntity.ok(updatedCollege);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "College not found with id: " + id);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error updating college", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable Long id) {
        try {
            collegeService.deleteCollege(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting college", e);
        }
    }
}
