package main.controller;

import main.model.TestModel;
import main.service.TestModelService;
import main.util.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "models")
public class TestModelController {

    private final TestModelService testModelService;

    @Autowired
    public TestModelController(TestModelService testModelService) {
        this.testModelService = testModelService;
    }

    @GetMapping
    public List<TestModel> getTestModels () {
        return this.testModelService.getTestModels();
    }

    @PostMapping
    public void registerNewTestModel (@RequestBody TestModel testModel) throws InvalidDataException {
        this.testModelService.addNewTestModel(testModel);
    }

    @DeleteMapping(path = "{testModelId}")
    public void deleteTestModel (@PathVariable("testModelId") Long testModelId) {
        this.testModelService.deleteTestModel(testModelId);
    }

    @PutMapping(path = "{testModelId}")
    public void updateTestModel (
            @PathVariable("testModelId") Long testModelId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        this.testModelService.updateTestModel(testModelId, name, email);
    }
}
