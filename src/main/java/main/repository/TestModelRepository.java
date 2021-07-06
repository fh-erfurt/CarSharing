package main.repository;

import main.model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestModelRepository
        extends JpaRepository<TestModel, Long> {

    @Query("SELECT tm FROM TestModel tm WHERE tm.email = ?1")
    Optional<TestModel> findTestModelByEmail(String email);
}
