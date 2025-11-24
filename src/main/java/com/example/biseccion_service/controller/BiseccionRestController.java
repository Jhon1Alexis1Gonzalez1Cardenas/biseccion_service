package com.example.biseccion_service.controller;


import com.example.biseccion_service.dto.EvaluarRequest;
import com.example.biseccion_service.service.BiseccionService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/biseccion_service")
public class BiseccionRestController {

    private final BiseccionService biseccionService;
    public BiseccionRestController(BiseccionService biseccionService) {
        this.biseccionService = biseccionService;
    }

    @PostMapping("Evaluar")
    public double[] biseccion(@RequestBody EvaluarRequest request) {
        return biseccionService.biseccion(request.getX1(), request.getX2(), request.getFuncion());
    }
}
