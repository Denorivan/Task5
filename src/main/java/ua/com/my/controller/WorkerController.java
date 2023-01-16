package ua.com.my.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.my.entity.Worker;
import ua.com.my.service.WorkerService;

@RestController
@RequestMapping("api/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @GetMapping
    public ResponseEntity<Iterable<Worker>> getAllWorkers() {
        return new ResponseEntity<>(workerService.findAllEmployees(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorker(@PathVariable("id") Long id) {
        return new ResponseEntity<>(workerService.findWorkerById(id), HttpStatus.FOUND);
    }

    @PostMapping("/{branch_id}")
    public ResponseEntity<Worker> createEmployee(
            @RequestBody @Valid Worker worker,
            @PathVariable("branch_id") Long id) {
        return new ResponseEntity<>(workerService.saveWorker(worker, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
