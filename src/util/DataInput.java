/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author long
 */
public class DataInput {
    private static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine().trim());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
       
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine().trim());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    
    public static double getADouble(String inputMsg, String errorMsg) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine().trim());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double n, tmp;
        
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine().trim());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    
    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static String getPhoneNum(String inputMsg, String errorMsg, String format) {
        String phone;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            phone = sc.nextLine().trim();
            match = phone.matches(format);
            if (phone.length() == 0 || phone.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return phone;
            }
        }
    }

    public static String getStringFormat(String inputMsg, String errorMsg, String format) {
        String str;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            match = str.matches(format);
            if (str.length() == 0 || str.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return str;
            }
        }
    }

    //nhập vào một chuỗi kí tự, khác rỗng
    public static String getStringNotBlank(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static String getString2Formats(String inputMsg, String outputMsg, String format1, String format2) {
        String str;
        boolean match1;
        boolean match2;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            match1 = str.matches(format1);
            match2 = str.matches(format2);
            if (match1||match2) {
                return str;
            
            } else {
                System.out.println(outputMsg);
            }
        }

    }

    public static String getAStringCanHaveBlank(String inputMsg, String errorMsg) {
        String str;
        while (true) {
            System.out.println(inputMsg);
            str = sc.nextLine();
            if (str.trim().length() == 0 || str.trim().isEmpty()) {
                return null;
            } else {
                return str;
            }
        }
    }

    public static int getAnIntegerCanHaveBlank(String inputMsg, String errorMsg,int lowerbound, int upperbound) {
        int num;
        String str;
        while (true) {
            System.out.println(inputMsg);
            str = sc.nextLine().trim();
            if (str.isEmpty()) {
                return -1;
            } else {
                try {
                    num = Integer.parseInt(str);
                    if (num >= lowerbound && num <= upperbound) return num;
                    else System.out.println(errorMsg);
                } catch (Exception e) {
                    System.out.println(errorMsg);
                }
            }

        }
    }
    
    public static String getAStringCanBeBlank(String msg) {
        String str ="";
        System.out.println(msg);
        str = sc.nextLine();
        return str.trim();
    }
    public static String getAIntegerCanBeBlank(String msg, int upper, int lower) {
        String str ="";
        int num;
        System.out.println(msg);
        boolean check = true;
        do{
            str = sc.nextLine();
            if(str.trim().equalsIgnoreCase("")) return str.trim();
            else {
                try {
                    num = Integer.parseInt(str);
                    if(num > upper && num< lower) return str;
                } catch (Exception e) {
                    System.out.println("This is not an integer!!!");
                }
            }
        }while(check);
        return str.trim();
    }
}
