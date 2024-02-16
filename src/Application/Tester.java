/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import controller.IngredientWareHouseController;
import model.TheIngredientWareHouse;
import util.DataInput;
import view.IngredientWareHouseView;

/**
 *
 * @author long
 */
public class Tester {

    public static void main(String[] args) {
        TheIngredientWareHouse iwh = new TheIngredientWareHouse();
        IngredientWareHouseView view = new IngredientWareHouseView();
        IngredientWareHouseController controller = new IngredientWareHouseController(iwh, view);
        controller.process();
    }
}
