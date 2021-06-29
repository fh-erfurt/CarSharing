package main.controller;

import main.model.TestModel;
import main.service.TestModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
