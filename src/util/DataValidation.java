/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Arrays;
import java.util.HashMap;
import model.Drink;
import model.Drink_Menu;
import model.Ingredient;
import model.TheIngredientWareHouse;

/**
 *
 * @author long
 */
public class DataValidation {

    public String inputIngredientID(TheIngredientWareHouse iwh) {
        String id = "";
        boolean check = true;
        while (check) {
            id = DataInput.getID("Enter the ingredient's id: ", "ID's format is IXXX!!!", "[I/i]\\d{3}");
            check = SearchData.searchIngredientByID(iwh, id);
            if (check == false) {
                break;
            } else {
                System.out.println("Existed ID. Please enter new ID.");
            }
        }
        return id;
    }

    public String inputIngredientName() {
        String name = "";
        name = DataInput.getStringNotBlank("Enter ingredient's name: ", "Invalid Name!!!");
        return name;
    }

    

    public String inputUnitMeasure() {
        String measure = DataInput.getString2Formats("Enter the measure for weight: ", "Measure can be g or ml !!!", "ml", "g");
        return measure;
    }

    public int inputQuantity() {
        int quantity = DataInput.getAnInteger("Enter the ingredient's quantity: ", "Quantity is number from 0 to 10000!!!", 0, 10000);
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
                return ingr.getMeasure();
            } else {
                check = checkMeasure(measureList, measure);
                if (check == true) {
                    return measure;
                }
                else System.out.println("The measure for a " + ingr.getName() +" can be: "+ Arrays.toString(measureList));
            }
        } while (true);
    }

    

    public int inputQuantityUpdate(TheIngredientWareHouse iwh, Ingredient ingr, int lower, int upper) {
        String quantity;
        int num;
        do {
            quantity = DataInput.getAStringCanBeBlank("Enter ingredient's quantity to update: ");
            if (quantity.equalsIgnoreCase("")) {
                return iwh.get(ingr);
            } else {
                try {
                    num = Integer.parseInt(quantity);
                    if (num >= lower && num <= upper) {
                        return num;
                    }
                } catch (Exception e) {
                    System.out.println("PLEASE ENTER A NUMBER FROM " + lower + 1 + "TO " + upper + "!!!");
                }
            }
        } while (true);
    }

    public String inputDrinkID(Drink_Menu drmn) {
        String id = "";
        boolean check = true;
        while (check) {
            id = DataInput.getID("Enter the ingredient's id: ", "ID's format is DXXX!!!", "[D/d]\\d{3}");
            check = SearchData.searchDrinkByID(id, drmn);
            if (check == false) {
                break;
            } else {
                System.out.println("Existed ID. Please enter new ID.");
            }
        }
        return id;
    }

    public String inputDrinkName() {
        String name = "";
        name = DataInput.getStringNotBlank("Enter drink's name: ", "Invalid Name!!!");
        return name;
    }

    public int inputDrinkPrice() {
        int price;
        price = DataInput.getAnInteger("Enter the drink's price: ", "Price is from 10000 to 300000 VND!!!", 10000, 300000);
        return price;
    }

    public Ingredient inputAnIngredientToDrink(TheIngredientWareHouse iwh, HashMap<Ingredient, Integer> ingrList) {
        String id;
        Ingredient ingr;
        do {
            id = DataInput.getID("Enter the ingredient's id: ", "ID's format is IXXX!!!", "[I/i]\\d{3}");

            ingr = SearchData.searchIngredientByIDV2(iwh, id);
            if (ingr == null) {
                System.out.println("This Ingredient is not existed");
            } else {
                if (ingrList.containsKey(ingr)) {
                    System.out.println(ingr.getName() + " is already in recipe!!!");
                } else {
                    return ingr;
                }
            }
        } while (true);
    }

    public int inputQuantityForAnIngredient(Ingredient ingr) {
        int quantity = DataInput.getAnInteger("Enter the quantity of " + ingr.getName() + " in drink" + "(" + ingr.getMeasure()+ "): ", "Quantity for ingredient is from 1 to 500 " + "(" + ingr.getMeasure()+ ")!!!", 1, 500);
        return quantity;
    }
    
    public String inputDrinkNameUpdate(Drink dr) {
        String name = DataInput.getAStringCanBeBlank("Enter ingredient's name to update: ");
        if (name.equalsIgnoreCase("")) {
            return dr.getName();
        } else {
            return name;
        }
    }
    
    
    
    
   public int inputDrinkPriceUpdate(Drink dr, int lower, int upper) {
       String price;
       int num;
       do {
            price = DataInput.getAStringCanBeBlank("Enter drink's price to update: ");
            if (price.equalsIgnoreCase("")) {
                return dr.getPrice();
            } else {
                try {
                    num = Integer.parseInt(price);
                    if (num > lower && num <= upper) {
                        return num;
                    }
                } catch (Exception e) {
                    System.out.println("PLEASE ENTER A NUMBER FROM " + lower + 1 + "TO " + upper + "!!!");
                }
            }
        } while (true);
   }
    
   public int inputQuantityForIngredient(Ingredient ingr, HashMap<Ingredient, Integer> ingrList, int lower, int upper) {
       String quantity;
       int num;
       do {
            quantity = DataInput.getAStringCanBeBlank("Enter drink's price to update: ");
            if (quantity.equalsIgnoreCase("")) {
                return ingrList.get(ingr);
            } else {
                try {
                    num = Integer.parseInt(quantity);
                    if (num > lower && num <= upper) {
                        return num;
                    }
                } catch (Exception e) {
                    System.out.println("PLEASE ENTER A NUMBER FROM " + lower + 1 + "TO " + upper + "!!!");
                }
            }
        } while (true);
   }
    
    
}
