import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PointOfSale extends Storage{

    private ArrayList<PointOfSale> Sale = new ArrayList<>();
    private ArrayList<WarehouseCell> ReceivedProduct = new ArrayList<>();
    public PointOfSale(int ID,String address,int responsiblePersonID,int storageSize){
        super(ID, address, responsiblePersonID, storageSize);

    }
    public PointOfSale(){

    }

    public void setReceivedProduct(ArrayList<WarehouseCell> receivedProduct) {
        ReceivedProduct = receivedProduct;
    }

    public ArrayList<WarehouseCell> getReceivedProduct() {
        return ReceivedProduct;
    }

    public void setSale(ArrayList<PointOfSale> sale) {
        Sale = sale;
    }

    public ArrayList<PointOfSale> getSale() {
        return Sale;
    }
    public void inputInfo(ArrayList<PointOfSale> pointOfSales){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID пункта продаж");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите адрес пункта продаж");
        String address = sc.nextLine();
        System.out.println("Введите ID ответственного лица пункта продаж");
        int responsiblePersonID = sc.nextInt();
        System.out.println("Введите размер пункта продаж");
        int storageSize = sc.nextInt();
        System.out.println();
        PointOfSale pointOfSale = new PointOfSale(ID,address,responsiblePersonID,storageSize);
        pointOfSales.add(pointOfSale);
    }
    public void BurningPointOfSale(ArrayList<PointOfSale> pointOfSales){
        boolean found = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID пункта продаж который хотите сжечь");
        int burn = sc.nextInt();
        Iterator<PointOfSale> iterator = pointOfSales.iterator();
        while (iterator.hasNext()){
            PointOfSale p = iterator.next();
            if(p.getID() == burn){
                found = true;
                iterator.remove();
                break;
            }
        }
        if(found){
            System.out.println("Сжег,красава");
        }
        else {
            System.out.println("Такого ID нет");
        }

    }
    public void outputInfo(ArrayList<PointOfSale> pointOfSales){
        for(PointOfSale pointOfSale: pointOfSales){
            System.out.println("ID: " + pointOfSale.getID() +"\nАдрес: " + pointOfSale.getAddress()  + "\nID ответственного лица: " + pointOfSale.getResponsiblePersonID() +"\nРазмер пункта продаж: " + pointOfSale.getStorageSize());
            System.out.println();
        }
    }
    public void received(ArrayList<WarehouseCell> products, ArrayList<WarehouseCell> receivedProduct){
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        System.out.println("Введите ID продукта который хотите передать в пункт продаж");
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
            System.out.println("Неверный ID идиот");
        }
    }

    public void outputInfoProduct(ArrayList<WarehouseCell> receivedProduct){
        for (WarehouseCell product:receivedProduct) {
            System.out.println("ID: " + product.getID() + "\nНазвание: " + product.getTitle() + "\nРазмер: " + product.getProductSize() + "\nЦена: " + product.getPriceProduct());
            System.out.println();
        }
    }
    public void writeToFile(ArrayList<PointOfSale> pointOfSales) throws IOException {
        File file = new File("WareHouseProduct");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter fileBuffered = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(fileBuffered);
        for (int i = 0; i < pointOfSales.size(); i++) {
            printWriter.println(pointOfSales.get(i));
        }
        printWriter.close();
    }

    public void readToFileAndPrint(ArrayList<Warehouse> warehouseList) throws FileNotFoundException {
        File file = new File("WareHouseProduct");
        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                System.out.println("Список пунктов продаж:");
                int line = 1;
                while (scanner.hasNextLine()) {
                    System.out.println(line + ". " + scanner.nextLine());
                    line++;
                }
            } else {
                System.out.println("Нет пунктов продаж");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }
}
