/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import model.Drink;
import model.Drink_Menu;
import model.Ingredient;
import model.TheIngredientWareHouse;
import util.DataInput;
import util.FileManager;
import util.Menu;
import util.SearchData;
import view.Drink_Menu_View;
import view.IngredientWareHouseView;

/**
 *
 * @author long
 */
public class Dispending_Drink_Controller {
   
    private Drink_Menu drMenu;
    private TheIngredientWareHouse iwh;
    private HashMap<Drink, Integer> dispending_drink;
    private Drink_Menu_View drMnView ;
    private IngredientWareHouseView ingrView;
    private FileManager fm = new FileManager();
//    private String path = "Orders.txt";
    public Dispending_Drink_Controller( Drink_Menu drMenu, HashMap<Drink, Integer> dispending_drink, TheIngredientWareHouse iwh, IngredientWareHouseView view1, Drink_Menu_View view2) {
        this.drMenu = drMenu;
        this.iwh = iwh;
        this.drMnView = view2;
        this.ingrView = view1;
        this.dispending_drink = dispending_drink;
    }

    public TheIngredientWareHouse getIwh() {
        return iwh;
    }

 

    public void process() throws IOException {
        Menu mn = new Menu("Dispending berverages");
        mn.addOption("Dispend a drink");
        mn.addOption("Update the dispeding drink");
        
        mn.addOption("End program");
        int choice;
        do {
            mn.printMenu();
            choice = mn.getChoice();
            switch (choice) {
                case 1:
                    this.dispendADrink();
                    break;
                case 2:
                    this.updateQuantityDispendingDrink();
                    break;
                case 3:
                    break;

            }
        } while (choice > 0 && choice <= 2);

    }

    public void reportProcess() {
        Menu mn = new Menu("Report");
        mn.addOption("The ingredients are available");
        mn.addOption("The drinks for which the store is out of ingredients.");
        mn.addOption("Show all dispending list");
        mn.addOption("End program");
        int choice;
        do {
            mn.printMenu();
            choice = mn.getChoice();
            switch (choice) {
                case 1:
                    printAvailableIngredient();
                    break;
                case 2:
                    this.printDrinkOutOfIngredient();
                    break;
                case 3:
                    this.printAllDispendingDrink();
                    break;
                case 4: break;

            }
        } while (choice > 0 && choice <= 3);

    }
//    public void writeToFile() throws IOException {
//        fm.saveToFileByText(dispending_drink, path);
//    }
    
    public void dispendADrink() {
        if (drMenu.isEmpty()) {
            System.out.println("There is no drink in menu!!!");
        } else {
            Drink drink = SearchData.searchDrinkByIDV2(DataInput.getID("Enter the drink's id: ", "ID's format is DXXX!!!", "[D/d]\\d{3}"), drMenu);
            if (drink == null) {
                System.out.println("This drink is not exist!!!");
            } else {
                
                boolean check = this.checkAnIngredientAvaible(drink, 1);
                if (check == true) {
                    this.decreaseQuantityInWareHouse(drink, 1);
                    this.dispending_drink.put(drink, 1);
                    System.out.println("Dispend successfully");
                } else {
                    System.out.println("There is not enough ingredient to dispend " + drink.getName() + "!!!" + "Dispend fail.");
                }

            }
        }
    }

    public boolean checkAnIngredientAvaible(Drink dr, int quantity) {
        for (Ingredient ingredient : dr.getRecipe().keySet()) {
            if (!SearchData.searchIngredientByID(iwh, ingredient.getCode())) {       
                return false;
            } else {
                if (dr.getRecipe().get(ingredient) * quantity  > iwh.get(SearchData.searchIngredientByIDV2(iwh, ingredient.getCode()))) {
                    return false;
                }
            }
        }
        return true;
    }
    


    public void decreaseQuantityInWareHouse(Drink d, int quantity) {
        for (Ingredient ingredient : d.getRecipe().keySet()) {
           iwh.updateItem(SearchData.searchIngredientByIDV2(iwh, ingredient.getCode()),ingredient.getName(),ingredient.getMeasure(), iwh.get(SearchData.searchIngredientByIDV2(iwh, ingredient.getCode())) - d.getRecipe().get(ingredient));
            System.out.println(iwh.get(SearchData.searchIngredientByIDV2(iwh, ingredient.getCode())));
           System.out.println(d.getRecipe().get(ingredient));
        }
        for (Ingredient i: iwh.keySet()) {
            System.out.println(i);
        System.out.println(iwh.get(i));
        }
    }

    public void updateQuantityDispendingDrink() {
        if (dispending_drink.isEmpty()) {
            System.out.println("There is no dispending drink!!!");
        } else {
            Drink drink = SearchData.searchDrinkByIDV2(DataInput.getID("Enter the ingredient's id: ", "ID's format is DXXX!!!", "[D/d]\\d{3}"), drMenu);
            int quantity = DataInput.getAnInteger("Enter quantity for drink: ", "Invalid quantity!!!");
            boolean check = this.checkAnIngredientAvaible(drink, quantity - 1);
            if (check == true) {
                this.decreaseQuantityInWareHouse(drink, quantity - 1);
                System.out.println("Update quantity successfully");
            } else {
                System.out.println("There is not enough ingredient to dispend " + drink.getName() + "!!!" + "Dispend fail.");
            }
        }
    }

    public void printAllDispendingDrink() {
        if (dispending_drink.isEmpty()) {
            System.out.println("There is no dispending drink!!!");
        } else {
            for (Drink drink : dispending_drink.keySet()) {
                System.out.println("|      Drink     |   Quantity  |");
                System.out.printf("|%17s|    %4d     |", drink.getName(), dispending_drink.get(drink));
                System.out.println();
            }
        }
    }

    public void printDrinkOutOfIngredient() {
        if(drMenu.isEmpty()) System.out.println("There is no drink in menu!!!");
        else{
        for (Drink drink : drMenu) {
            boolean check = this.checkAnIngredientAvaible(drink, 1);
            if (!check) {
               drMnView.printADrink(drink);
            }
        }
    }
    }
    
    
     public void printAvailableIngredient() {
        if (iwh.isEmpty()) {
            System.out.println("There is no ingredient in warehouse!!!");
        }
        System.out.println("                             Ingredient Warehouse                            ");
        System.out.println("|   ID     |           NAME               |   QUANTITY    |      MEASURE   |");
        for (Ingredient ingr : iwh.keySet()) {
            if (iwh.get(ingr) > 0) {
                ingrView.printAnIngredient(ingr, iwh);
            }
        }
    }
}
