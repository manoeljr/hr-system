package com.hrsystem.payrollapi.resources;

import com.hrsystem.payrollapi.domain.Payroll;
import com.hrsystem.payrollapi.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/payments")
@RequiredArgsConstructor
public class PayrollResource {

    private final PayrollService service;

    @GetMapping(value = "{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment) {
        return ResponseEntity.ok().body(service.getPayment(workerId, payment));
    }

}
