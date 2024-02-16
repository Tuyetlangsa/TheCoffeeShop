package util;

import java.util.Map.Entry;

import model.Ingredient;
import model.TheIngredientWareHouse;

public class SearchData {
    public static boolean SearchByID(TheIngredientWareHouse hm, String id ) {
        for (Ingredient ingr :
             hm.keySet()) {
                if(ingr.getCode().equalsIgnoreCase(id)) return true;
             }
        return false;
    }
    public static Ingredient SearchByIDV2( TheIngredientWareHouse hm, String id) {
        Ingredient find = null;
        for(Ingredient ingr: hm.keySet()) {
            if(ingr.getCode().equalsIgnoreCase(id)) find = ingr;
        }
        return find;
    }
}
