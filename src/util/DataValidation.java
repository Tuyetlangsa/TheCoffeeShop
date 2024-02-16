/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.Ingredient;
import model.TheIngredientWareHouse;

/**
 *
 * @author long
 */
public class DataValidation {

    public String inputID(TheIngredientWareHouse iwh) {
        String id = "";
        boolean check = true;
        while (check) {
            id = DataInput.getID("Enter the ingredient's id: ", "ID's format is IXXX!!!", "[I/i]\\d{3}");
            check = SearchData.SearchByID(iwh, id);
            if (check == false) {
                break;
            } else {
                System.out.println("Existed ID. Please enter new ID.");
            }
        }
        return id;
    }

    public String inputName() {
        String name = "";
        name = DataInput.getStringNotBlank("Enter ingredient's name: ", "Invalid Name!!!");
        return name;
    }

    public String inputUnitType() {
        String unitType = DataInput.getStringNotBlank("Enter the item's unit type: ", "Invalid Unit Type!!!");
        return unitType;
    }

    public int inputUnitWeight() {
        int unitWeight = DataInput.getAnInteger("Enter ingredient's weight: ", "Weight is number from 1 to 10000!!!", 0, 10000);
        return unitWeight;
    }

    public String inputUnitMeasure() {
        String measure = DataInput.getString2Formats("Enter the measure for weight: ", "Measure can be g or ml !!!", "ml", "g");
        return measure;
    }

    public int inputQuantity() {
        int quantity = DataInput.getAnInteger("Enter the ingredient's quantity: ", "Quantity is number from 1 to 10000!!!", 0, 10000);
        return quantity;
    }

    public String inputNameUpdate(Ingredient ingr) {
        String name = DataInput.getAStringCanBeBlank("Enter ingredient's name to update: ");
        if (name.equalsIgnoreCase("")) {
            return ingr.getName();
        } else {
            return name;
        }
    }

    public String inputUnitTypeUpdate(Ingredient ingr) {

        String type = DataInput.getAStringCanBeBlank("Enter ingredient's unit type to update: ");
        if (type.equalsIgnoreCase("")) {
            return ingr.getUnitType();
        } else {
            return type;
        }
    }

    public boolean checkMeasure(String[] measure, String str) {
        boolean check = false;
        for (String string : measure) {
            if (str.equalsIgnoreCase(string)) {
                check = true;
            }
        }
        return check;
    }

    public String inputUnitMeasureUpdate(Ingredient ingr) {
        boolean check = false;
        String measure;
        String[] measureList = new String[]{"g", "ml"};
        do {
            measure = DataInput.getAStringCanBeBlank("Enter ingredient's measure to update: ");
            if (measure.equalsIgnoreCase("")) {
                return ingr.getUnitMeasure();
            } else {
                check = checkMeasure(measureList, measure);
                if (check == true) {
                    return measure;
                }
            }
        } while (true);
    }

    public int inputUnitWeightUpdate(Ingredient ingr, int lower, int upper) {
        String weight;
        int num;
        do {
            weight = DataInput.getAStringCanBeBlank("Enter ingredient's weight for a type to update: ");
            if (weight.equalsIgnoreCase("")) {
                return ingr.getUnitWeight();
            } else {
                try {
                    num = Integer.parseInt(weight);
                    if (num > lower && num <= upper) {
                        return num;
                    }
                } catch (Exception e) {
                    System.out.println("PLEASE ENTER A NUMBER FROM " + lower+1 + "TO " + upper + "!!!");
                }
            }
        } while (true);

    }
    public int inputQuantityUpdate(TheIngredientWareHouse iwh, Ingredient ingr, int lower, int upper) {
        String quantity;
        int num;
        
        do{
            quantity = DataInput.getAStringCanBeBlank("Enter ingredient's quantity to update: ");
            if(quantity.equalsIgnoreCase("")) return iwh.get(ingr);
            else {
                try {
                    num = Integer.parseInt(quantity);
                    if(num> lower && num<= upper) return num;
                } catch (Exception e) {
                    System.out.println("PLEASE ENTER A NUMBER FROM " + lower+1 + "TO " + upper + "!!!");
                }
            }
        }while(true);
    }
    
}
