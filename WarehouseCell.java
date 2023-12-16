import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WarehouseCell extends ProductList {
    private int priceProduct;
    private ArrayList<WarehouseCell> products = new ArrayList<>();

    private ArrayList<WarehouseCell> receivedProduct = new ArrayList<>();
    public WarehouseCell(int ID, int productSize, String title, int priceProduct){
        super(ID,title,productSize);
        this.priceProduct = priceProduct;

    }
    public WarehouseCell(){

    }

    public void setReceivedProduct(ArrayList<WarehouseCell> receivedProduct) {
        this.receivedProduct = receivedProduct;
    }

    public ArrayList<WarehouseCell> getReceivedProduct() {
        return receivedProduct;
    }


    public void setProducts(ArrayList<WarehouseCell> products) {
        this.products = products;
    }

    public ArrayList<WarehouseCell> getProducts() {
        return products;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void ProductInfo(ArrayList<WarehouseCell> products){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID продукта:");
        int ID = sc.nextInt();
        System.out.println("Введите размер продукта:");
        int productSize = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите название продукта:");
        String title = sc.nextLine();
        System.out.println("Введите цену продукта:");
        int priceProduct = sc.nextInt();
        System.out.println();

        WarehouseCell product = new WarehouseCell(ID,productSize,title,priceProduct);
        products.add(product);
    }
    public void outputInfoProduct(ArrayList<WarehouseCell> products){
        for (WarehouseCell product:products) {
            System.out.println("ID: " + product.getID() + "\nНазвание: " + product.getTitle() + "\nРазмер: " + product.getProductSize() + "\nЦена: " + product.getPriceProduct());
            System.out.println();
        }
    }
    public void receivedProduct(ArrayList<WarehouseCell> products,ArrayList<WarehouseCell> receivedProduct){
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        System.out.println("Введите ID продукта который хотите передать в cклад");
        int add = sc.nextInt();
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getID() == add){
                found = true;
                receivedProduct.add(products.get(i));
                products.remove(i);
                break;
            }
        }
        if (found){
            System.out.println("Продукт успешно передан");
        }
        else{
            System.out.println("Неверный ID,Баран");
        }
    }
    public void writeToFile(ArrayList<WarehouseCell> warehouseCells) throws IOException {
        File file = new File("WareHouseProduct");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter fileBuffered = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(fileBuffered);
        for (int i = 0; i < warehouseCells.size(); i++) {
            printWriter.println(warehouseCells.get(i));
        }
        printWriter.close();
    }

    public void readToFileAndPrint(ArrayList<WarehouseCell> warehouseCells) throws FileNotFoundException {
        File file = new File("WareHouseProduct");
        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                System.out.println("Список ячеек на складе на складе:");
                int line = 1;
                while (scanner.hasNextLine()) {
                    System.out.println(line + ". " + scanner.nextLine());
                    line++;
                }
            } else {
                System.out.println("Нет ячеек склада");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }
}
