/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author long
 */
public class Drink_Menu extends ArrayList<Drink> {

  public void addDrink(Drink dr) {
      this.add(dr);
  }
  public void addAListDrink (ArrayList<Drink> drlist) {
      this.addAll(drlist);
  }
  public void deleteADrink(Drink dr){
      this.remove(dr);
  }
  
}
