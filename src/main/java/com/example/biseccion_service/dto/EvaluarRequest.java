package com.example.biseccion_service.dto;


import lombok.Data;

@Data
public class EvaluarRequest {
    private double x1;
    private double x2;
    private String funcion;
}
