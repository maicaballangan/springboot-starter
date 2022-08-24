package com.cordisys.web.repositories;

import java.util.List;
import java.util.Optional;

import com.cordisys.web.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService<U extends Model<U>> {

    @Autowired
    private ModelRepository<U> repository;

    public ModelService(ModelRepository<U> empRepo) {
        this.repository = empRepo;
    }

    public List<U> getAll() {
        return repository.findAll();
    }

    public void save(U model) {
        repository.save(model);
    }

    public U getById(Long id) {
        Optional<U> optional = repository.findById(id);
        U model = null;
        if (optional.isPresent())
            model = optional.get();
        else
            throw new RuntimeException(
                    "model not found for id : " + id);
        return model;
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
