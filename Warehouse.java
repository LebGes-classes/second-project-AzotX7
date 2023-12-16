import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Warehouse extends Storage implements Serializable {
    private ArrayList<Warehouse> warehouse = new ArrayList<>();


    public Warehouse(int ID,int responsiblePersonID,String address,int storageSize){
        super(ID, address, responsiblePersonID, storageSize);
    }
    public Warehouse(){

    }
    public void setWarehouse(ArrayList<Warehouse> warehouse) {
        this.warehouse = warehouse;
    }

    public ArrayList<Warehouse> getWarehouse() {
        return warehouse;
    }
    public void InfoWarehouse(ArrayList<Warehouse> warehouse){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID склада:");
        int ID = sc.nextInt();
        System.out.println("Введите ID ответственного за склад");
        int responsiblePersonID = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите адрес склада:");
        String address = sc.nextLine();
        System.out.println("Введите размер склада");
        int storageSize = sc.nextInt();
        System.out.println();
            Warehouse warehouses = new Warehouse(ID, responsiblePersonID, address, storageSize);
            warehouse.add(warehouses);
    }
    public void Removal(ArrayList<Warehouse> warehouse) {
        boolean found = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID склада,который хотите сжечь");
        int remove = sc.nextInt();
        sc.nextLine();

        Iterator<Warehouse> iterator = warehouse.iterator();
        while (iterator.hasNext()){
            Warehouse w = iterator.next();
            if (w.getID() == remove) {
                found = true;
                iterator.remove();
                break;
            }
        }

        if (found) {
            System.out.println("Склад успешно уничтожен");
        } else {
            System.out.println("Склада с таким ID не существует");
        }
    }
    public void outputInfoWarehouse(ArrayList<Warehouse> warehouse){
        for (Warehouse warehous:warehouse) {
            System.out.println("ID:" + warehous.getID() + "\nАдрес:" + warehous.getAddress() + "\nID ответственного лица: " + warehous.getResponsiblePersonID() + "\nРазмер склада в квадратных метрах: " + warehous.getStorageSize());
            System.out.println();
        }
    }



    public void writeToFile(ArrayList<Warehouse> warehouseList) throws IOException {
        File file = new File("WareHouseProduct");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter fileBuffered = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(fileBuffered);
        for (int i = 0; i < warehouse.size(); i++) {
            printWriter.println(warehouse.get(i));
        }
        printWriter.close();
    }

    public void readToFileAndPrint(ArrayList<Warehouse> warehouseList) throws FileNotFoundException {
        File file = new File("WareHouseProduct");
        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                System.out.println("Список продуктов на складе:");
                int line = 1;
                while (scanner.hasNextLine()) {
                    System.out.println(line + ". " + scanner.nextLine());
                    line++;
                }
            } else {
                System.out.println("Нет продуктов");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }


}
