package com.javaii.carsharing.service;

import com.javaii.carsharing.api.request.AddBranchRequest;
import com.javaii.carsharing.model.Branch;

import java.util.List;

public interface BranchService {
    List<Branch> findAll();
    long addBranch(AddBranchRequest request);
    void deleteBranchById(long id);
    Branch getBranchById(long id);
}
