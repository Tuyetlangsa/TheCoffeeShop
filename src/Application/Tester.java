/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import controller.Dispending_Drink_Controller;
import controller.Drink_Menu_Controller;
import controller.IngredientWareHouseController;
import java.io.IOException;
import java.util.HashMap;
import model.Drink;
import model.Drink_Menu;
import model.TheIngredientWareHouse;
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
         final String path1 = "Ingredients.txt";
         final String path2 = "Menu.txt";
         final String path3 = "Orders.txt";
        HashMap<Drink, Integer> dispending_drink = new HashMap<>();
        FileManager fm = new FileManager();
        TheIngredientWareHouse  iwh = new TheIngredientWareHouse();
        fm.loadFromFile(iwh, path1);
        IngredientWareHouseView iwhView = new IngredientWareHouseView();
        Drink_Menu drMenu = new Drink_Menu();
        fm.loadFromFile(drMenu, path2);
        Drink_Menu_View drMnView = new Drink_Menu_View();
        IngredientWareHouseController ingrController = new IngredientWareHouseController(iwh, iwhView);
        Drink_Menu_Controller drMnController = new Drink_Menu_Controller(drMenu, drMnView, ingrController);
        Dispending_Drink_Controller disDrController = new Dispending_Drink_Controller(drMenu, dispending_drink, iwh, iwhView, drMnView);
        Menu programMenu = new Menu("THE COFFEE SHOP");
        programMenu.addOption("Manage ingredients");
        programMenu.addOption("Manage beverage recipes");
        programMenu.addOption("Dispensing beverages");
        programMenu.addOption("Report");
        programMenu.addOption("End program");
//        ingrController.loadFile();
//        drMnController.loadFile();
        int choice;
        do {
            programMenu.printMenu();
            choice = programMenu.getChoice();
            switch (choice) {
                case 1:
                    ingrController.process();
                    fm.saveToFile(iwh, path1, "");
                    break;
                case 2:
                    drMnController.process();
                    fm.saveToFile(drMenu, path2, "");
                    break;
                case 3:
                    disDrController.process();
                    fm.saveToFileByText(dispending_drink, path3);
                    break;
                case 4:
                    disDrController.reportProcess();
                    break;
                case 5:
//                    drMnController.writeFile();
//                    ingrController.writeFile();
//                    disDrController.writeToFile();
                      
                    System.out.println("Exit Program");
                    break;
            }
        } while (choice > 0 && choice <= 4);
    }
}
