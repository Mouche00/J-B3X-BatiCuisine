package services.implementations;

import models.Material;
import repositories.interfaces.ClientRepository;
import repositories.interfaces.ComponentRepository;
import services.interfaces.ComponentService;

import java.sql.SQLException;
import java.util.Optional;

public class MaterialServiceImpl implements ComponentService<Material> {
    private final ComponentRepository<Material> repository;
    public MaterialServiceImpl(ComponentRepository<Material> repository) {
        this.repository = repository;
    }

    @Override
    public boolean update(Material material) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Optional<Material> save(Material material) {
        try {
            return repository.save(material);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }
}
