package main.service;

import main.model.TestModel;
import main.repository.TestModelRepository;
import main.util.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void addNewTestModel(TestModel testModel) throws InvalidDataException {
        Optional<TestModel> testModelOptional = this.testModelRepository.findTestModelByEmail(testModel.getEmail());
        if (testModelOptional.isPresent()) {
            throw new InvalidDataException("email taken");
        }
        this.testModelRepository.save(testModel);
    }

    public void deleteTestModel (Long testModelId) {
        boolean exists = this.testModelRepository.existsById(testModelId);
        if (!exists) {
            throw new IllegalStateException("test model with id " + testModelId + " does not exist");
        }
        this.testModelRepository.deleteById(testModelId);
    }

    @Transactional
    public void updateTestModel (Long testModelId, String name, String email) {
        TestModel testModel = this.testModelRepository.findById(testModelId).orElseThrow(() -> new IllegalStateException("test model with id " + testModelId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(testModel.getName(), name)) {
            testModel.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(testModel.getEmail(), email)) {
            Optional<TestModel> testModelOptional = this.testModelRepository.findTestModelByEmail(email);
            if (testModelOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            testModel.setEmail(email);
        }
    }
}
