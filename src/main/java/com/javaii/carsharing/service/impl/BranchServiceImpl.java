package com.javaii.carsharing.service.impl;

import com.javaii.carsharing.api.request.AddBranchRequest;
import com.javaii.carsharing.model.Address;
import com.javaii.carsharing.model.Branch;
import com.javaii.carsharing.repository.AddressRepository;
import com.javaii.carsharing.repository.BranchRepository;
import com.javaii.carsharing.service.BranchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl  implements BranchService {

    private BranchRepository branchRepository;
    private AddressRepository addressRepository;

    public BranchServiceImpl(BranchRepository branchRepository, AddressRepository addressRepository) {
        this.branchRepository = branchRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Branch> findAll() {
        return this.branchRepository.findAll();
    }

    @Override
    public long addBranch(AddBranchRequest request) {
        Address address = this.addAddressToDataSource(request);
        Branch branch = new Branch();
        branch.setAddress(address);
        branch = branchRepository.save(branch);
        return branch.getId();
    }

    private Address addAddressToDataSource(AddBranchRequest request){
        Address address = new Address();
        address.setCity(request.getCity());
        address.setPostalCode(request.getPostalCode());
        address.setStreet(request.getStreet());
        address.setStreetNumber(request.getStreetNumber());
        return addressRepository.save(address);
    }

    @Override
    public void deleteBranchById(long id) {
        branchRepository.deleteById(id);
    }

    @Override
    public Branch getBranchById(long id) {
        return branchRepository.getById(id);
    }
}
