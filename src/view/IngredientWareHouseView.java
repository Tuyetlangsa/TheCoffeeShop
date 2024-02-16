/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import model.Ingredient;
import model.TheIngredientWareHouse;
import util.SearchData;

/**
 *
 * @author long
 */
public class IngredientWareHouseView {

    public IngredientWareHouseView() {
    }
    public void printAnIngredient(Ingredient ingredient, TheIngredientWareHouse iwh) {
        System.out.printf("|%10s|%30s|%15d|%15s|",ingredient.getCode(), ingredient.getName(), iwh.get(ingredient), ingredient.getUnitType());
        System.out.println();
    }
    
    
    
    public void printAllIngredient(TheIngredientWareHouse iwh) {
        if (iwh.keySet().isEmpty()) {
            System.out.println("THERE IS NO INGREDIENT IN WAREHOUSE!!!");
        } else {
            ArrayList sort = new ArrayList<>(iwh.keySet());
            Collections.sort(sort);
            System.out.println("                             Ingredient Warehouse                            ");
            System.out.println("|   ID     |           NAME               |   QUANTITY    |       TYPE    |");
            for (Object ingredient : sort) {
//            System.out.println("|          |                              |               |               |");
                Ingredient tmp = (Ingredient) ingredient;
                
                System.out.printf("|%10s|%30s|%15d|%15s|",tmp.getCode(), tmp.getName(), iwh.get(tmp), tmp.getUnitType());
                System.out.println();
            }
        }

    }

    public void printAnIngredientInWareHouseByID(TheIngredientWareHouse iwh, String id) {
//        System.out.println("|          |                              |               |               |");
        Ingredient ingr = SearchData.SearchByIDV2(iwh, id);
        if (ingr != null) {
            System.out.println("                         Ingredient Warehouse                         ");

            System.out.println("|   ID     |           NAME               |   QUANTITY    |       TYPE    |");

            System.out.printf("|%10s|%30s|%15d|%15s|", ingr.getCode(), ingr.getName(), iwh.get(ingr), ingr.getUnitType());
        } else {
            System.out.println("THIS INGREDIENT'S ID IS NOT EXISTED!!!");
        }

    }
}