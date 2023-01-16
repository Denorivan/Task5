package ua.com.my.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.my.aop.exception.BranchNotFound;
import ua.com.my.entity.Branch;
import ua.com.my.repo.BranchRepo;

@Service
public class BranchService {
    @Autowired
    private BranchRepo branchRepo;

    public Branch findBranchById(Long id) {
        return branchRepo
                .findById(id)
                .orElseThrow(BranchNotFound::new);
    }

    public Branch saveBranch(Branch branch) {
        return branchRepo.save(branch);
    }
}
