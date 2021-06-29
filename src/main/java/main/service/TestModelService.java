package main.service;

import main.model.TestModel;
import main.repository.TestModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestModelService {

    private final TestModelRepository testModelRepository;

    @Autowired
    public TestModelService(TestModelRepository testModelRepository) {
        this.testModelRepository = testModelRepository;
    }

    public List<TestModel> getTestModels () {
        return this.testModelRepository.findAll();
    }
}
