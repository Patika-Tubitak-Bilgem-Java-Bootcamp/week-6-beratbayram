package src;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Product {

    static Scanner input = new Scanner(System.in).useLocale(Locale.US);

    private final int id;
    private static int idNotebook = 0;
    private static int idMobilePhone = 0;

    private final double unitPrice;

    private final String model;
    private final String nameBrand;
    private String productName;

    private final int storage;
    private final double screenSize;
    private double camera;
    private int battery;
    private int RAM;
    private String color;

    private static HashMap<String, ArrayList<Product>> products = new HashMap<>() {{
        put("Notebook", new ArrayList<>());
        put("MobilePhone", new ArrayList<>());
    }};


    public Product(int id, double unitPrice, int stock, String model, String nameBrand, int storage, double screenSize, int RAM) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.model = model;
        this.nameBrand = Brand.getBrand(Integer.parseInt(nameBrand));
        this.storage = storage;
        this.screenSize = screenSize;
        this.RAM = RAM;
    }

    public Product(int id, double unitPrice, double discountRate, int stock, String model, String nameBrand, int storage, double screenSize, int camera, int battery, int RAM, String color) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.model = model;
        this.nameBrand = nameBrand;
        this.storage = storage;
        this.screenSize = screenSize;
        this.camera = camera;
        this.battery = battery;
        this.RAM = RAM;
        this.color = color;
    }

    public static void processMenu(int num) {
        if (num == 1) {
            Utils.println("Notebook");
        } else {
            Utils.println("Mobile Phone");
        }
        Utils.println("-----------------");
        Utils.println("1 - List Items");
        Utils.println("2 - Add Items");
        Utils.println("3 - Delete Items");
        Utils.println("4 - Filter Items");
        Utils.println("Your choice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1 -> listItems(num);
            case 2 -> addItems(num);
            case 3 -> deleteItems(num);
            case 4 -> filterItems(num);
            default -> {
                Utils.println("There is no such an option. Please enter your choice again.");
                processMenu(num);
            }
        }
    }

    public static void listItems(int num) {
        if (num % 2 != 0) {
            Utils.printHeader(Utils.Header.Notebook);
            ArrayList<Product> productList = products.get("Notebook");

            if (!productList.isEmpty()) {
                for (Product product : productList) {
                    String productName = product.getNameBrand() + " " + product.getModel();
                    product.setProductName(productName);

                    System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s |\n",
                            product.getId(), product.getProductName(), product.getUnitPrice(), product.getNameBrand(),
                            product.getStorage(), product.getScreenSize(), product.getRAM());
                }
                Utils.println("----------------------------------------------------------------------------------------------------------");
            }
        } else {
            // Mobile phone
            Utils.printHeader(Utils.Header.MobilePhone);
            ArrayList<Product> productList = products.get("MobilePhone");

            if (!productList.isEmpty()) {
                for (Product product : productList) {
                    String productName = product.getNameBrand() + " " + product.getModel();
                    product.setProductName(productName);

                    System.out.printf("| %-2s | %-30s| %-10s TL | %-10s| %-10s| %-12s | %-10s | %-10s | %-10s | %-10s |\n" ,
                            product.getId(), product.getProductName(), product.getUnitPrice(), product.getNameBrand(),
                            product.getStorage(), product.getScreenSize(), product.getCamera(), product.getBattery(), product.getRAM(), product.getColor());
                }
                Utils.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

            }
        }
    }

    public static void addItems(int num) {
        Utils.println("Unit Price: ");
        double unitPriceInput = input.nextDouble();
        Utils.println("Discount Rate: ");
        double discountRateInput = input.nextDouble();
        Utils.println("Stock: ");
        int stockInput = input.nextInt();
        Brand.printBrands();
        Utils.println("Brand: ");
        String brandInput = input.next();
        input.nextLine();
        Utils.println("Model: ");
        String modelInput = input.nextLine();
        Utils.println("Storage: ");
        int storageInput = input.nextInt();
        Utils.println("Screen Size: ");
        double screenSizeInput = input.nextDouble();
        Utils.println("RAM: ");
        int RAMInput = input.nextInt();

        if (num % 2 != 0) {
            // Notebook
            idNotebook += 1;
            int id = idNotebook;
            products.get("Notebook").add(new Product(id, unitPriceInput, stockInput, modelInput, brandInput, storageInput, screenSizeInput, RAMInput));

        } else {
            // Mobile Phone
            idMobilePhone += 1;
            int id = idMobilePhone;
            Utils.println("Camera: ");
            int cameraInput = input.nextInt();
            Utils.println("Battery Capacity: ");
            int batteryInput = input.nextInt();
            input.nextLine();
            Utils.println("Color: ");
            String colorInput = input.nextLine();

            Product newMobilePhone = new Product(id, unitPriceInput, discountRateInput, stockInput, modelInput, brandInput, storageInput, screenSizeInput, cameraInput, batteryInput, RAMInput, colorInput);
            products.get("MobilePhone").add(newMobilePhone);

        }
    }

    public static void deleteItems(int num) {
        Utils.println("Enter an ID value to delete: ");
        int idProduct = input.nextInt();
        boolean notExist = true;
        if (num % 2 != 0) {
            for (Product product : products.get("Notebook")) {
                if (product.getId() == idProduct) {
                    products.get("Notebook").remove(product);
                    notExist = false;
                    Utils.println("The product with ID " + idProduct + " has been removed from the system.");
                    break;
                }
            }

        } else {
            for (Product product : products.get("MobilePhone")) {
                if (product.getId() == idProduct) {
                    products.get("MobilePhone").remove(product);
                    notExist = false;
                    Utils.println("The product with ID " + idProduct + " has been removed from the system.");
                    break;
                }
            }

        }
        if (notExist) {
            Utils.println("The value ID is not found in the system. Please check your ID and Try again...");
        }
    }

    public static void filterItems(int num) {
        Utils.println("Enter an ID to filter products or '0' if you don't like to enter an ID: ");
        int idProduct = input.nextInt();
        boolean idExits = idProduct != 0;

        Utils.println("Enter the brand to filter products or 'none' if you don't like to enter a brand: ");
        String brandProduct = input.next();
        boolean brandExits = !brandProduct.equals("none");

        ArrayList<Product> filteredProducts = new ArrayList<>();

        if (num % 2 != 0) {
            if (idExits && brandExits) {
                for (Product product : products.get("Notebook")) {
                    if (brandProduct.equals(product.getNameBrand()) && product.getId() == idProduct) {
                        filteredProducts.add(product);
                        listFilteredItems(num, filteredProducts);
                        break;
                    } else {
                        Utils.println("The value ID or brand is not found in the system. Please check your ID or brand. Then Try again...");
                        filterItems(num);
                    }
                }
            } else {
                if (brandExits) {
                    for (Product product : products.get("Notebook")) {
                        if (brandProduct.equals(product.getNameBrand())) {
                            filteredProducts.add(product);
                        }
                    }
                    listFilteredItems(num, filteredProducts);
                } else {
                    Utils.println("The brand is not found in the system. Please check your brand. Then Try again...\nATTENTION: **You must enter ID with a brand together.**");
                    filterItems(num);
                }
            }

        } else {
            if (idExits && brandExits) {
                for (Product product : products.get("MobilePhone")) {
                    if (brandProduct.equals(product.getNameBrand()) && product.getId() == idProduct) {
                        filteredProducts.add(product);
                        listFilteredItems(num, filteredProducts);
                        break;
                    } else {
                        Utils.println("The value ID or brand is not found in the system. Please check your ID or brand. Then Try again...");
                        filterItems(num);
                    }
                }
            } else {
                if (brandExits) {
                    for (Product product : products.get("MobilePhone")) {
                        if (brandProduct.equals(product.getNameBrand())) {
                            filteredProducts.add(product);
                        }
                    }
                    listFilteredItems(num, filteredProducts);
                } else {
                    Utils.println("The brand is not found in the system. Please check your brand. Then Try again...\nATTENTION: **You must enter ID with a brand together.**");
                    filterItems(num);
                }
            }
        }
    }

    private static void listFilteredItems(int num, ArrayList<Product> filteredProductList) {
        if (num % 2 != 0) {
            Utils.printHeader(Utils.Header.Notebook);
            if (!filteredProductList.isEmpty()) {
                for (Product product : filteredProductList) {
                    System.out.printf("| %-2s | %-30s| %-15s TL | %-10s| %-10s| %-12s | %-10s |\n",
                            product.getId(), product.getProductName(), product.getUnitPrice(), product.getNameBrand(),
                            product.getStorage(), product.getScreenSize(), product.getRAM());
                }
                Utils.println("---------------------------------------------------------------------------------------------------------------");
            }
            Utils.println("");

        } else {
            Utils.printHeader(Utils.Header.MobilePhone);
            if (!filteredProductList.isEmpty()) {
                for (Product product : filteredProductList) {
                    System.out.printf("| %-2s | %-30s| %-15s TL | %-10s| %-10s| %-10s | %-12s | %-10s | %-10s | %-10s |\n" ,
                            product.getId(), product.getProductName(), product.getUnitPrice(), product.getNameBrand(),
                            product.getStorage(), product.getScreenSize(), product.getCamera(), product.getBattery(), product.getRAM(), product.getColor());
                }
                Utils.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

            }
        }
    }

    public int getId() {
        return id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getModel() {
        return model;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public double getCamera() {
        return camera;
    }

    public void setCamera(double camera) {
        this.camera = camera;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int batteryPower) {
        this.battery = batteryPower;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static HashMap<String, ArrayList<Product>> getProducts() {
        return products;
    }

    public static void setProducts(HashMap<String, ArrayList<Product>> products) {
        Product.products = products;
    }
}
