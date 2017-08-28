package io.prajwala.controller;

import io.prajwala.entity.Alert;
import io.prajwala.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/alerts")
public class AlertController {

    @Autowired
    AlertService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Alert> findAllAlerts(){return service.findAllAlerts();}

    @RequestMapping(method = RequestMethod.GET, value = "/high")
    public List<Alert> highAlerts(){return service.highAlerts();}

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public List<Alert> alertsByVin(@PathVariable("vin") String vin){return service.alertsByVin(vin);}

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}/high")
    public List<Alert> highAlertsByVin(@PathVariable("vin") String vin){return service.highAlertsByVin(vin);}



}
