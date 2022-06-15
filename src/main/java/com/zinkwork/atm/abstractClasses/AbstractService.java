package com.zinkwork.atm.abstractClasses;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<L extends Long, T extends AbstractModel, U extends AbstractInterface<T, L>> {

    @Autowired
    private U repository;

    public T save(T object){
        if(object.getCreationDate() == null){
            object.setCreationDate(LocalDateTime.now());
        }
        object.setUpdateDate(LocalDateTime.now());
        repository.save(object);
        return object;
    }

    public Optional<T> findById(L id){return repository.findById(id);}

    public void delete(L id){repository.deleteById(id);}

    public List<T> list(){return repository.findAll();}

}
