package com.example.conflict_tracker.web;

import com.example.conflict_tracker.service.ConflictService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conflicts")
public class ConflictController {
    private final ConflictService conflictService;
    public ConflictController(ConflictService conflictService) {
        this.conflictService = conflictService;
    }

    @GetMapping
    public List<ConflictDto> getAllConflicts() {
        return conflictService.findAll();
    }
    @GetMapping("/{id}")
    public ConflictDto getConflictById(@PathVariable int id) {
        return conflictService.findById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConflictDto createConflict(@RequestBody ConflictDto conflictDto) {
        return conflictService.create(conflictDto);
    }
    @PutMapping("/{id}")
    public ConflictDto updateConflict(@PathVariable int id, @RequestBody ConflictDto conflictDto) {
        return conflictService.update(id, conflictDto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConflict(@PathVariable int id) {
        conflictService.delete(id);
    }
}
