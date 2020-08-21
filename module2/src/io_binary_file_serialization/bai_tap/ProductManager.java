package io_binary_file_serialization.bai_tap;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ProductManager {
    public static HashMap<String, Product> productHashMap = new HashMap<>();
    private static final String PATH_FILE = "E:\\C0620G1\\module2\\src\\io_binary_file_serialization\\bai_tap\\demo.bin";
    public static void main(String[] args) throws Exception {
        readFromDatabase(); // requirement

        addProduct("1","Iphone X","USA","1000USD","Beautiful");
        showProducts();

        writeToDatabase(); // requirement
    }

    public static void writeToDatabase() throws Exception {
        FileOutputStream fileOutput = new FileOutputStream(PATH_FILE);
        try {
            ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            for(Map.Entry<String,Product> entry : productHashMap.entrySet()){
                output.writeObject(entry.getValue());
            }
            output.flush();
            output.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void readFromDatabase() throws Exception {
        FileInputStream fileInput = new FileInputStream(PATH_FILE);
        try {
            ObjectInputStream input = new ObjectInputStream(fileInput);
            Product product = (Product) input.readObject();
            while(input.read() != -1){
                productHashMap.put(product.getId(),product);
            }
            input.close();
        } catch (EOFException e){
            e.printStackTrace();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void addProduct(String id,String name,String manufacturer,String price,String description) throws Exception {
        readFromDatabase();
        productHashMap.put(id,new Product(id,name,manufacturer,price,description));
        writeToDatabase();
    }

    public static void showProducts() throws Exception{
        readFromDatabase();
        productHashMap.forEach((k,v) -> {
            System.out.println(v.toString());
        });
    }

    public static void searchProducts(String key) throws Exception {
        readFromDatabase();
        System.out.println(productHashMap.get(key).toString());
    }

}
