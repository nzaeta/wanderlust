package com.woderlust.controller;

import com.woderlust.NewDataPaymentRequest;
import com.woderlust.entities.DataPayment;
import com.woderlust.services.DataPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataPaymentController {
    private final DataPaymentService dataPaymentService;

    public DataPaymentController(DataPaymentService dataPaymentService) {
        this.dataPaymentService = dataPaymentService;
    }

    @GetMapping("/dataPayment/")
    public List<DataPayment> getAllDataPayment() { return dataPaymentService.getDataPayments();}

    @PostMapping("/dataPayment/")
    public void addDataPayment(@RequestBody NewDataPaymentRequest request) { dataPaymentService.addDataPayment(request); }

    @PutMapping("/dataPayment/{id}")
    public ResponseEntity<DataPayment> updateDataPayment(@RequestBody DataPayment dataPayment, @PathVariable Long id) { return dataPaymentService.updateDataPayment(id, dataPayment);}

    @DeleteMapping("/dataPayment/{id}")
    public void daleteDataPayment(@PathVariable Long id) { dataPaymentService.delete(id);}
}
