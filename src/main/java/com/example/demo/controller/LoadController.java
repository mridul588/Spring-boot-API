package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Load;
import com.example.demo.Repository.LoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class LoadController {

    @Autowired
    private LoadRepo loadRepo;

    @GetMapping("/loads")
    public List<Load> getAllLoad() {
        return this.loadRepo.findAll();
    }

    @GetMapping("/loads/{shipperId}")
    public ResponseEntity<Load> getLoadByShipperId(@PathVariable(value = "shipperId") String shipperId)
            throws ResourceNotFoundException {
        Load load = loadRepo.findByShipperId(shipperId)
                .orElseThrow(() -> new ResourceNotFoundException("not found for this shipperId :: " + shipperId));
        return ResponseEntity.ok().body(load);
    }

    @PostMapping("/loads")
    public Load createLoad(@RequestBody Load load) {
        return this.loadRepo.save(load);
    }

    @PutMapping("/loads/{shipperId}")
    public ResponseEntity<Load> updateLoad(@PathVariable(value = "shipperId") String shipperId,
                                           @RequestBody Load loadDetails) throws ResourceNotFoundException {
        Load load = loadRepo.findByShipperId(shipperId)
                .orElseThrow(() -> new ResourceNotFoundException("not found for this shipperId :: " + shipperId));

        load.setLoadinPoint(loadDetails.getLoadinPoint());
        load.setUnloadingPoint(loadDetails.getUnloadingPoint());
        load.setProductType(loadDetails.getProductType());
        load.setTruckType(loadDetails.getTruckType());
        load.setNoOfTrucks(loadDetails.getNoOfTrucks());
        load.setWeight(loadDetails.getWeight());
        load.setOptional(loadDetails.getOptional());
        load.setDate(loadDetails.getDate());

        return ResponseEntity.ok(this.loadRepo.save(load));
    }

    @DeleteMapping("/loads/{shipperId}")
    public Map<String, Boolean> deleteLoad(@PathVariable(value = "shipperId") String shipperId)
            throws ResourceNotFoundException {
        Load load = loadRepo.findByShipperId(shipperId)
                .orElseThrow(() -> new ResourceNotFoundException("not found for this shipperId :: " + shipperId));

        this.loadRepo.delete(load);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
