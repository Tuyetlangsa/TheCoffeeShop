/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author long
 */
public class Ingredient implements Comparable<Ingredient>, Serializable  {
    private String code;
    private String name;
    private Unit unit;

    public Ingredient(String code, String name, Unit unit) {
        this.code = code;
        this.name = name;
        this.unit = unit;
    }

    public Ingredient(String code, String name, String type, int weight, String measure) {
        this.code = code;
        this.name = name;
        this.unit = new Unit(type, weight,measure);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Unit getUnit() {
        return unit;
    }
        public String getUnitType() {
        return unit.getType();
    }
        public int getUnitWeight() {
        return unit.getWeight();
    }
                public String getUnitMeasure() {
        return unit.getMeasure();
    }
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
        public void setUnitType(String type) {
        this.unit.setType(type);
    }
        public void setUnitWeight(int weight) {
        this.unit.setWeight(weight);
    }
        public void getUnitMeasure(String measure) {
        this.unit.setMeasure(measure);
    }
    @Override
    public String toString() {
        return "Ingredient{" + "code=" + code + ", name=" + name + ", unit=" + unit + '}';
    }

    @Override
    public int compareTo(Ingredient o) {
        if(this.getName().compareToIgnoreCase(o.getName())>0) {
            return 1;
        }
        else if(this.getName().compareToIgnoreCase(o.getName())<0)
            return -1;
        else return this.getCode().compareToIgnoreCase(o.getCode());
    }
}
