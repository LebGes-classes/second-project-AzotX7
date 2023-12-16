import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Buyer extends Human {

    private ArrayList<Buyer> buyers = new ArrayList<>();
    private ArrayList<WarehouseCell> productsForBuyers = new ArrayList<>();
    public Buyer(int ID,String name,int age){
        super(name, age, ID);
    }
    public Buyer(){

    }

    public void setBuyers(ArrayList<Buyer> buyers) {
        this.buyers = buyers;
    }

    public ArrayList<Buyer> getBuyers() {
        return buyers;
    }

    public void setProductsForBuyers(ArrayList<WarehouseCell> productsForBuyers) {
        this.productsForBuyers = productsForBuyers;
    }

    public ArrayList<WarehouseCell> getProductsForBuyers() {
        return productsForBuyers;
    }
    public void infoBuyer(ArrayList<Buyer> buyers){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID покупателя");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите имя покупателя");
        String name = sc.nextLine();
        System.out.println("Введите возраст покупателя,вдруг пиздюк");
        int age = sc.nextInt();
        System.out.println();
        Buyer buyer = new Buyer(ID,name,age);
        buyers.add(buyer);
    }
    public void outputInfoBuyer(ArrayList<Buyer> buyers){
        for (Buyer buyer:buyers) {
            System.out.println("ID: " + buyer.getID() + "\nИмя: " + buyer.getName() + "\nВозраст: " + buyer.getAge());
            System.out.println();
        }
    }
    public void received(ArrayList<WarehouseCell> ReceivedProducts, ArrayList<WarehouseCell> productsForBuyers){
        boolean found = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID продукта который хотите приобрести");
        int add = sc.nextInt();
        for (int i = 0; i < ReceivedProducts.size(); i++) {
            if(ReceivedProducts.get(i).getID() == add){
                found = true;
                productsForBuyers.add(ReceivedProducts.get(i));
                ReceivedProducts.remove(i);
                break;
            }
        }
        if(found){
            System.out.println("Купил,хватило денег,вафля");
        }
        else {
            System.out.println("Бомжара где деньги!?");
        }
    }
    public void outputInfoProductsForBuyers(ArrayList<WarehouseCell> productsForBuyers){
        for (WarehouseCell product:productsForBuyers) {
            System.out.println("ID: " + product.getID() + "\nНазвание: " + product.getTitle() + "\nРазмер: " + product.getProductSize() + "\nЦена: " + product.getPriceProduct());
            System.out.println();
        }
    }
    public void writeToFile(ArrayList<Buyer> buyers) throws IOException {
        File file = new File("WareHouseProduct");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter fileBuffered = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(fileBuffered);
        for (int i = 0; i < buyers.size(); i++) {
            printWriter.println(buyers.get(i));
        }
        printWriter.close();
    }

    public void readToFileAndPrint(ArrayList<Buyer> buyers) throws FileNotFoundException {
        File file = new File("WareHouseProduct");
        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                System.out.println("Список покупателей:");
                int line = 1;
                while (scanner.hasNextLine()) {
                    System.out.println(line + ". " + scanner.nextLine());
                    line++;
                }
            } else {
                System.out.println("Нет покупателей");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

}
