/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import model.TheIngredientWareHouse;

/**
 *
 * @author long
 */
public class FileManager {
    public <T> boolean loadFromFile(List<T> list, String fileName) {
        list.clear();
        File f = new File(fileName);
        if (!f.exists()) {
            return false;
        }
        try (FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            if (f.length() == 0) {
                System.err.println("File is empty");
            }

            boolean check = true;
            while (check) {
                try {
                            list.addAll((List)ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            return false;
        } catch (IOException | ClassNotFoundException e) {
            if (f.length() != 0) {
                System.err.println("Error reading from file: " + fileName + " " + e.getMessage());
                return false;
            }
        } catch (NumberFormatException e) {
            // log error or throw exception
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
   
    
    public <T> boolean saveToFile(List<T> list, String fileName, String msg) {

        try {

            File f = new File(fileName);
            if (!f.exists()) {
                System.out.println("Empty list");
                return false;
            }

            ObjectOutputStream fileOut;
            try (FileOutputStream fos = new FileOutputStream(f)) {
                fileOut = new ObjectOutputStream(fos);
                fileOut.writeObject(list);
                fileOut.close();
                fos.close();
                System.out.println(msg);
                return true; //successful save
            }
        } catch (IOException e) {
            System.out.println(e);
            
        }
        return false;
    }
    
    public <T> boolean loadFromFile(HashMap<T,Integer> list, String fileName) {
        list.clear();
        File f = new File(fileName);
        if (!f.exists()) {
            return false;
        }
        try (FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            if (f.length() == 0) {
                System.err.println("File is empty");
            }

            boolean check = true;
            while (check) {
                try {
                    
                    list.putAll((HashMap<T, Integer>)ois.readObject());
                    
                } catch (EOFException e) {
                    break;
                }
            }
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            return false;
        } catch (IOException | ClassNotFoundException e) {
            if (f.length() != 0) {
                System.err.println("Error reading from file: " + fileName + " " + e.getMessage());
                return false;
            }
        } catch (NumberFormatException e) {
            // log error or throw exception
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
     public boolean saveToFile(TheIngredientWareHouse list, String fileName, String msg) {

        try {

            File f = new File(fileName);
            if (!f.exists()) {
                System.out.println("Empty list");
                return false;
            }

            ObjectOutputStream fileOut;
            try (FileOutputStream fos = new FileOutputStream(f)) {
                fileOut = new ObjectOutputStream(fos);
                fileOut.writeObject(list);
                fileOut.close();
                fos.close();
                System.out.println(msg);
                return true; //successful save
            }
        } catch (IOException e) {
            System.out.println(e);
            
        }
        return false;
    }
    
    
    
    
    
    
}