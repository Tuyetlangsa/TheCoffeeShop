/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import controller.Drink_Menu_Controller;
import controller.IngredientWareHouseController;
import java.io.IOException;
import model.Drink_Menu;
import model.TheIngredientWareHouse;
import util.DataInput;
import util.FileManager;
import util.Menu;
import view.Drink_Menu_View;

import view.IngredientWareHouseView;

/**
 *
 * @author long
 */
public class Tester {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        TheIngredientWareHouse iwh = new TheIngredientWareHouse();
        IngredientWareHouseView iwhView = new IngredientWareHouseView();
        Drink_Menu drMenu = new Drink_Menu();
        Drink_Menu_View drMnView = new Drink_Menu_View();
        IngredientWareHouseController ingrController = new IngredientWareHouseController(iwh, iwhView);
        Drink_Menu_Controller drMnController = new Drink_Menu_Controller(drMenu, drMnView, ingrController);
        Menu programMenu = new Menu("THE COFFEE SHOP");
        programMenu.addOption("Manage ingredients");
        programMenu.addOption("Manage beverage recipes");
        programMenu.addOption("Dispensing beverages");
        programMenu.addOption("Report");
        programMenu.addOption("End program");
        ingrController.loadFile();
        drMnController.loadFile();
        int choice;
          do {
            programMenu.printMenu();
            choice = programMenu.getChoice();
            switch (choice) {
                case 1:
                       ingrController.process();
                       break;
                case 2:
                        drMnController.process();
                    break;
                case 3:                 
                    break;
                case 4: 
                    ingrController.showAvailableIngredient();
                    break;
                case 5: 
                    drMnController.writeFile();
                    ingrController.writeFile();
                    System.out.println("Exit Program");
                    break;
            }
        } while (choice > 0 && choice <=4 );
    }
}
