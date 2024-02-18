/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import model.Drink;
import model.Drink_Menu;
import model.Ingredient;
import util.DataInput;
import util.DataValidation;
import util.FileManager;
import util.Menu;
import util.SearchData;
import view.Drink_Menu_View;

/**
 *
 * @author long
 */
public class Drink_Menu_Controller {

    private Drink_Menu drMenu;
    private IngredientWareHouseController iwhCtl;
    private Drink_Menu_View view;
    private DataValidation dv = new DataValidation();
    private FileManager fm = new FileManager();
    private final String path = "Menu.txt";

    public Drink_Menu_Controller(Drink_Menu drMenu, Drink_Menu_View view, IngredientWareHouseController iwhCtl) {
        this.drMenu = drMenu;
        this.view = view;
        this.iwhCtl = iwhCtl;
    }

    public void process() {
        this.loadFile();
        Menu mn = new Menu("Drink Menu");
        mn.addOption("Add new drink");
        mn.addOption("Update an drink");
        mn.addOption("Delete an drink");
        mn.addOption("Show all drink");
        mn.addOption("End program");
        int choice;
        do {
            mn.printMenu();
            choice = mn.getChoice();
            switch (choice) {
                case 1:
                    do {
                        this.addANewDrink();
                        String choice2 = DataInput.getString2Formats("Do you want to continue adding drink? (Y/N)", "Choose Y or N please!!!", "[Y/y]", "[N/n]");
                        if ("N".equalsIgnoreCase(choice2)) {
                            break;
                        }
                    } while (true);
                    break;
                case 2:
                    this.updateADrink();
                    break;
                case 3:
                    this.deleteADrink();
                    break;
                case 4:
                    this.show();
                    break;
                case 5:
                    this.writeFile();
                    break;

            }
        } while (choice > 0 && choice <= 4);
    }

    public void loadFile() {
        fm.loadFromFile(drMenu, path);

    }

    public void writeFile() {
        fm.saveToFile(drMenu, path, "Save successfully");
    }

    public void addANewDrink() {

        System.out.println("----------Adding a new ingredient-------");
        String id = dv.inputDrinkID(drMenu);
        String name = dv.inputDrinkName();
        int price = dv.inputDrinkPrice();
        HashMap<Ingredient, Integer> ingrList = new HashMap<>();
        do {
            Ingredient ingr = dv.inputAnIngredientToDrink(iwhCtl.getIwh(), ingrList);
            int quantity = dv.inputQuantityForAnIngredient(ingr);
            ingrList.put(ingr, quantity);
            String choice2 = DataInput.getString2Formats("Do you want to continue adding ingredient? (Y/N)", "Choose Y or N please!!!", "[Y/y]", "[N/n]");
            if ("N".equalsIgnoreCase(choice2)) {
                break;
            }
        } while (true);
        drMenu.addDrink(new Drink(id, name, price, ingrList));
        System.out.println("Add successfully!!!");
    }

    public void updateADrink() {
        if (drMenu.isEmpty()) {
            System.out.println("There is no drink in menu!!!");
        } else {
            System.out.println("----------Updating a drink----------");
            String id = DataInput.getID("Enter the ingredient's id: ", "ID's format is DXXX!!!", "[D/d]\\d{3}");
            Drink dr = SearchData.searchDrinkByIDV2(id, drMenu);
            if (dr == null) {
                System.out.println("This drink is not existed!!!");
            } else {
                String name = dv.inputDrinkNameUpdate(dr);
                dr.setName(name);
                int price = dv.inputDrinkPriceUpdate(dr, 10000, 300000);
                dr.setPrice(price);
                this.updateDrinkRecipe(dr);
                view.printADrink(dr);
                System.out.println("Update successfully");
            }
        }
    }

    public void updateDrinkRecipe(Drink dr) {
        Menu mn = new Menu("Update Recipe For " + dr.getName());
        mn.addOption("Update quantity");
        mn.addOption("Change recipe");
        mn.addOption("Finish update recipe");
        int choice;
        do {
            mn.printMenu();
            choice = mn.getChoice();
            switch (choice) {
                case 1:
                    for (Ingredient ingredient : dr.getRecipe().keySet()) {
                        dr.getRecipe().replace(ingredient, dv.inputQuantityForAnIngredient(ingredient));
                    }
                    break;
                case 2:
                    HashMap<Ingredient, Integer> ingrList = new HashMap<>();
                    do {
                        Ingredient ingr = dv.inputAnIngredientToDrink(iwhCtl.getIwh(), ingrList);
                        int quantity = dv.inputQuantityForAnIngredient(ingr);
                        ingrList.put(ingr, quantity);
                        dr.setRecipe(ingrList);
                        String choice2 = DataInput.getString2Formats("Do you want to continue adding ingredient? (Y/N)", "Choose Y or N please!!!", "[Y/y]", "[N/n]");
                        if ("N".equalsIgnoreCase(choice2)) {
                            break;
                        }
                    } while (true);
                    break;
                case 3:
                    break;
            }
        } while (choice > 0 && choice <= 2);
    }

    public void deleteADrink() {
        if (drMenu.isEmpty()) {
            System.out.println("There is no drink in menu!!!");
        } else {
            System.out.println("-----------Deleting a drink-------------");
            String id = DataInput.getStringFormat("Enter drink's id to delete: ", "Format for id is DXXX!!!", "[D/d]\\d{3}");
            Drink dr = SearchData.searchDrinkByIDV2(id, drMenu);
            if (dr == null) {
                System.out.println("This drink is not existed!!!");           
            } else {
                String choice = DataInput.getString2Formats("Do you want to continue adding? (Y/N)", "Choose Y or N please!!!", "[Y/y]", "[N/n]");
                if (choice.equalsIgnoreCase("N")) {
                    System.out.println("Delete fail!!!");
                } else {
                    drMenu.deleteADrink(dr);
                    System.out.println("Delete successfully!!!");
                }

            }
        }
    }

    public void show() {
        view.printAllDrink(drMenu);
    }
}
