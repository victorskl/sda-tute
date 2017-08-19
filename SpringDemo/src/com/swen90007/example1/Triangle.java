package com.swen90007.example1;

public class Triangle {
    
    private String type;
    
    private Point p1;
    private Point p2;
    private Point p3;
    
    public Triangle() {}    
    
    public Triangle(String type) {
        this.type = type;
    }

    public void draw(String n) {
        System.out.println("Triangle drawn: " + n + ". Type is: " + type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }
}