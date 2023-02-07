package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.List;

import com.mjc.stage2.Observable;
import com.mjc.stage2.Observer;
import com.mjc.stage2.event.RectangleEvent;

public class Rectangle implements Observable
{
    private int id;
    private double sideA;
    private double sideB;
    private List<Observer> observers = new ArrayList<>();

    public Rectangle(int id, double sideA, double sideB) {
        this.id = id;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
        notifyObserver();
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
        notifyObserver();
    }

    @Override
    public void addObserver(final Observer o)
    {
        observers.add(o);
    }

    @Override
    public void removeObserver(final Observer o)
    {
        observers.remove(o);
    }

    @Override
    public void notifyObserver()
    {
        RectangleEvent rectangleEvent = new RectangleEvent(this);
        observers.forEach(observer -> observer.handleEvent(rectangleEvent));
    }

    @Override
    public String toString()
    {
        return "Rectangle{" +
                "id=" + id +
                ", sideA=" + sideA +
                ", sideB=" + sideB +
                '}';
    }
}
