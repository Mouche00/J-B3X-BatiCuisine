package services.implementations;

import models.Material;
import models.Workforce;
import repositories.interfaces.ComponentRepository;
import services.interfaces.ComponentService;

import java.sql.SQLException;
import java.util.Optional;

public class WorkforceServiceImpl implements ComponentService<Workforce> {
    private final ComponentRepository<Workforce> repository;
    public WorkforceServiceImpl(ComponentRepository<Workforce> repository) {
        this.repository = repository;
    }

    @Override
    public boolean delete(String id) {
        try {
            return repository.delete(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Optional<Workforce> save(Workforce workforce) {
        try {
            return repository.save(workforce);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }
}
