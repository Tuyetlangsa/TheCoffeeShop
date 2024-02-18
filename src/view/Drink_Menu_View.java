/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Collections;
import model.Drink;
import model.Drink_Menu;
import model.Ingredient;

/**
 *
 * @author long
 */
public class Drink_Menu_View {
    public void printADrink(Drink dr){
        
        System.out.printf("|%-10s|%-10s|%-15d   |", dr.getCode(), dr.getName(), dr.getPrice());
        System.out.println();
        System.out.println("----------RECIPE----------");
        System.out.println("|   Name   |  Quantity   |");
        for (Ingredient ingredient : dr.getRecipe().keySet()) {
            System.out.printf("|%-10s|%5d  %6s|", ingredient.getName(), dr.getRecipe().get(ingredient), ingredient.getUnitMeasure());
            System.out.println();
        }
    }
    
    public void printAllDrink(Drink_Menu mn) {
        if(mn.isEmpty()) System.out.println("There is no drink in menu!!!");
        Collections.sort(mn);
        for (Drink drink : mn) { 
            printADrink(drink);
            System.out.println();
        }
    }
        
}
