package ua.com.my.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.my.entity.Worker;

import java.util.Optional;

@Repository
public interface WorkerRepo extends JpaRepository<Worker, Long> {
    Optional<Worker> findById(Long id);
}
