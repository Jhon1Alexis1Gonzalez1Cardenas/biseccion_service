package com.example.biseccion_service.service;

import BiseLibJava.BiseLibJava;
import org.springframework.stereotype.Service;

@Service
public class BiseccionService {

    private final BiseLibJava mibiseLibJava;
    public BiseccionService() {
        this.mibiseLibJava = new BiseLibJava();
    }
    public double[] biseccion(double x1, double x2, String funcion) {
        return mibiseLibJava.bisecionjava(x1, x2, funcion);
    }

}
