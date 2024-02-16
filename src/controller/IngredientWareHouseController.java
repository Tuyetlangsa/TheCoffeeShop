/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Ingredient;
import model.TheIngredientWareHouse;
import model.Unit;
import util.DataInput;
import util.DataValidation;
import util.FileManager;
import util.Menu;
import util.SearchData;
import view.IngredientWareHouseView;

/**
 *
 * @author long
 */
public class IngredientWareHouseController {

    private final TheIngredientWareHouse iwh;
    private final IngredientWareHouseView view;
    private final DataValidation dv = new DataValidation();
    private final Menu mn = new Menu("Ingredient Management");
    private final FileManager fm = new FileManager();
    private final String path = "Ingredients.txt";

    public IngredientWareHouseController(TheIngredientWareHouse iwh, IngredientWareHouseView view) {
        this.iwh = iwh;
        this.view = view;
    }

    public void process() {
        this.readFromFile();
        mn.addOption("Add new ingredient");
        mn.addOption("Updat an ingredient");
        mn.addOption("Delete an ingredient");
        mn.addOption("Show all ingredient");
        int choice;
        do {
            mn.printMenu();
            choice = mn.getChoice();
            switch (choice) {
                case 1:
                    do {
                        this.addANewIngredient();
                        this.writeToFile();
                        String choice2 = DataInput.getString2Formats("Do you want to continue adding? (Y/N)", "Choose Y or N please!!!", "[Y/y]", "[N/n]");
                        if ("N".equalsIgnoreCase(choice2)) {
                            break;
                        }
                    } while (true);
                    break;
                case 2:
                    this.upadteAnIngredient();
                    this.writeToFile();
                    break;
                case 3:
                    this.deleteAnIngredient();
                    this.writeToFile();
                    break;
                case 4:
                    this.show();

            }
        } while (choice > 0 && choice <= 4);
    }

    public void readFromFile() {
        fm.loadFromFile(iwh, path);
    }
    public void writeToFile() {
        fm.saveToFile(iwh, path, "Save Successfully!!!");
    }
    
    public void addANewIngredient() {
            System.out.println("----------Adding a new ingredient-------");
            Ingredient newIngr = new Ingredient(dv.inputID(iwh), dv.inputName(), new Unit(dv.inputUnitType(), dv.inputUnitWeight(), dv.inputUnitMeasure()));
            iwh.addItem(newIngr, dv.inputQuantity());
            System.out.println("Add successfully!!!");
        }
    

    public void show() {
        if (iwh.isEmpty()) {
            System.out.println("There is no ingredient in warehouse!!!");
        } else {
            view.printAllIngredient(iwh);
        }
    }

    public void upadteAnIngredient() {
        if (iwh.isEmpty()) {
            System.out.println("There is no ingredient in warehouse!!!");
        } else {
            System.out.println("-----------Updating an ingredient-------------");
            String id = DataInput.getStringFormat("Enter ingredient's id to update: ", "Format for id is IXXX!!!", "[I]\\d{3}");
            Ingredient ingr = SearchData.SearchByIDV2(iwh, id);
            if (ingr == null) {
                System.out.println("This id is not existed!!");
            } else {
                iwh.updateItem(ingr, dv.inputNameUpdate(ingr), dv.inputUnitTypeUpdate(ingr), dv.inputUnitWeightUpdate(ingr, 0, 10000), dv.inputUnitMeasureUpdate(ingr), dv.inputQuantityUpdate(iwh, ingr, 0, 10000));
                view.printAnIngredient(ingr, iwh);
            }

        }
    }

    public void deleteAnIngredient() {
        if (iwh.isEmpty()) {
            System.out.println("There is no ingredient in warehouse!!!");
        } else {
            System.out.println("-----------Deleting an ingredient-------------");
            String id = DataInput.getStringFormat("Enter ingredient's id to update: ", "Format for id is IXXX!!!", "[I]\\d{3}");
            Ingredient ingr = SearchData.SearchByIDV2(iwh, id);
            if (ingr == null) {
                System.out.println("THIS ID IS NOT EXISTED!!!");
            } else {
                view.printAnIngredient(ingr, iwh);
                String choice = DataInput.getString2Formats("Do you want to continue adding? (Y/N)", "Choose Y or N please!!!", "[Y/y]", "[N/n]");
                if (choice.equalsIgnoreCase("N")) {
                    System.out.println("Delete fail!!!");
                } else {
                    iwh.deleteItem(ingr);
                    System.out.println("Delete successfully!!!");
                }
            }

        }
    }
}