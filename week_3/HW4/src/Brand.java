package src;

import java.util.LinkedHashMap;

public class Brand {
    private static final String[] brands = {"Other", "Samsung", "LG", "Apple", "Sony", "Asus"};

    public static void printBrands() {
        Utils.println("");
        Utils.println("BRANDS");
        Utils.println("----------------------------");
        for (int i = 0; i <brands.length; i++) {
            Utils.println(i+ ") " + brands[i]);
        }
    }
    public static String getBrand(int num){
        return brands[num];
    }
}

