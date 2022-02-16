package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

@RestController
@RequestMapping(value = "/api")

public class Controller {
    @Autowired
    private StackRepository list;
    private QRepository list2;

    @GetMapping(value = "/getall")
    public List<StackEntity> findAll() {
        return list.findAll();
    }

    @GetMapping(value = "/getlistQ")
    public List<Stackmini> getAll() {
        return list2.findAllProjectsMini();
    }


    @GetMapping("/getid")
        public ResponseEntity<List<StackEntity>> getByid(@RequestParam Long id) {
            return new ResponseEntity<List<StackEntity>>(list.findByid(id), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public StackEntity add(@RequestBody StackEntity StackEntity) {
        return list.save(StackEntity);
    }
    @Deprecated
    @PutMapping(value = "/edit")
    public StackEntity edit(@RequestBody StackEntity newInfoStackEntity) {
        StackEntity original = list.getOne(newInfoStackEntity.getId());

        if (original != null) {
            original.setInfo(newInfoStackEntity);
            return list.save(original);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Long id) {
        list.deleteById(id);
    }

    }
