import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {

        File file = new File("produkty.csv");
        Product[] products = new Product[1000];
        double sumOfAllProduct = 0;
        if (!file.exists()) {
            file.createNewFile();
        }
        try {
            int i = 0;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] words = line.split(";");
                products[i] = new Product(words[0], words[1], Double.valueOf(words[2]));
                System.out.println(products[i].toString());
                sumOfAllProduct += products[i].getPrice();

                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        System.out.println("SUMA WSZYSTKICH PRODUKTÓW: " + sumOfAllProduct);
    }
}
