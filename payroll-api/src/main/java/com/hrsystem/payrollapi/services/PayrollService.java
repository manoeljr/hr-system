package com.hrsystem.payrollapi.services;

import com.hrsystem.payrollapi.domain.Payroll;
import com.hrsystem.payrollapi.feignClients.UserFeign;
import com.hrsystem.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class PayrollService {

    private final Environment env;
    private final UserFeign feign;

    public Payroll getPayment(Long workerId, Payroll payroll) {
        log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
        try {
            var user = feign.findById(workerId).getBody();
            if (Objects.nonNull(user)) {
                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkerHours(),
                        payroll.getWorkerHours() * user.getHourlyPrice()
                );
            }
        } catch (FeignException.FeignClientException.NotFound ex) {
            throw new ObjectNotFoundException("Object not found");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }
}
