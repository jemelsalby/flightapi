package com.nestdigital.flightbackendapp.controller;


import com.nestdigital.flightbackendapp.dao.FlightDao;
import com.nestdigital.flightbackendapp.model.FlightModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/flightAdd",consumes = "application/json",produces = "application/json")
    public  String flightAdd(@RequestBody FlightModel flight){
        System.out.println(flight.toString());
        dao.save(flight);
        return "{status:success}";
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/viewflight")
    public List<FlightModel> viewFlight(){
        return (List<FlightModel>) dao.findAll();
    }

}
