package com.epam.oreshkevich.entity;

import com.epam.oreshkevich.calculation.PlaneCalculation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denis Areshkevich on 06.06.2017.
 */
public class PlaneWithOxyAxeAngleModel implements Observable {


    private Plane plane;
    private double angleWithOxy;
    private Map<Plane, Observer> observerMap;


    private static PlaneWithOxyAxeAngleModel instance;

    private PlaneWithOxyAxeAngleModel() {
        observerMap = new HashMap<>();
    }

    public static PlaneWithOxyAxeAngleModel getInstance() {
        if (instance == null) {
            instance = new PlaneWithOxyAxeAngleModel();
        }
        return instance;
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer != null) {
            observerMap.put(plane, observer);
        }

    }

    @Override
    public void deleteObserver(Observer observer) {
        if (observer != null) {
            observerMap.remove(plane, observer);
        }
    }

    @Override
    public void notifyObservers() {
        PlaneCalculation planeCalculation = new PlaneCalculation();
        angleWithOxy = planeCalculation.calculateAngleWithOXY(plane);
        observerMap.entrySet().forEach(entry -> entry.getValue().update(angleWithOxy));
    }

    public void setAngleWithOxy(double angleWithOxy) {
        this.angleWithOxy = angleWithOxy;
        notifyObservers();
    }

}
