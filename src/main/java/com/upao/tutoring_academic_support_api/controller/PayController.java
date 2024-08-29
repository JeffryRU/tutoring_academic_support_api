package com.upao.tutoring_academic_support_api.controller;

import com.upao.tutoring_academic_support_api.domain.Pay;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/pagos")
public class PayController {

    private List<Pay> pagos = new ArrayList<>(); // Lista simulada

    @GetMapping
    public List<Pay> getAllPay() {
        return pagos;
    }

    @GetMapping("/{id}")
    public Pay getPayById(@PathVariable Long id) {
        return pagos.stream()
                .filter(pago -> pago.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Pay createPay(@RequestBody Pay pago) {
        pagos.add(pago);
        return pago;
    }

    @PutMapping("/{id}")
    public Pay updatePay(@PathVariable Long id, @RequestBody Pay pagoDetalles) {
        Pay pago = getPayById(id);
        if (pago != null) {
            pago.setMonto(pagoDetalles.getMonto());
            pago.setFecha(pagoDetalles.getFecha());
        }
        return pago;
    }

    @DeleteMapping("/{id}")
    public String deletePay(@PathVariable Long id) {
        Pay pago = getPayById(id);
        if (pago != null) {
            pagos.remove(pago);
            return "Pago eliminado";
        }
        return "Pago no encontrado";
    }
}