package ua.com.my.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.my.aop.exception.WorkerNotFound;
import ua.com.my.entity.Branch;
import ua.com.my.entity.Worker;
import ua.com.my.repository.WorkerRepository;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private BranchService branchService;
    public Iterable<Worker> findAllEmployees() {
        return workerRepository.findAll();
    }
    public Worker findWorkerById(Long id) {
        return workerRepository
                .findById(id)
                .orElseThrow(WorkerNotFound::new);
    }

    public Worker saveWorker(Worker worker, Long department_id) {
        Branch branch = branchService.findBranchById(department_id);
        worker.setBranch(branch);
        return workerRepository.save(worker);
    }

    public void deleteWorkerById(Long id) {
        Worker worker = findWorkerById(id);
        workerRepository.delete(worker);
    }
}
