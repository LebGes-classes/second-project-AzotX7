import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Seller extends Human {
    private ArrayList<Seller> sellers = new ArrayList<>();
    public Seller(){

    }
    public Seller(int ID,int age,String name){
        super(name, age, ID);
    }

    public void setSellers(ArrayList<Seller> sellers) {
        this.sellers = sellers;
    }

    public ArrayList<Seller> getSellers() {
        return sellers;
    }

    public void inputInfo(ArrayList<Seller> sellers){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID продавца");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите имя продавца");
        String name = sc.nextLine();
        System.out.println("Введите возраст продавца");
        int age = sc.nextInt();
        System.out.println();
        Seller newSeller = new Seller(ID,age,name);
        sellers.add(newSeller);
    }
    public void DismissalSeller(ArrayList<Seller> sellers){
        Scanner sc = new Scanner(System.in);
        boolean found = false;
        System.out.println("Введите ID продавца,которого хотите побрить");
        int dismissal = sc.nextInt();
        Iterator<Seller> iterator = sellers.iterator();
        while (iterator.hasNext()){
            Seller s = iterator.next();
            if(s.getID() == dismissal){
                found = true;
                iterator.remove();
                break;
            }
        }
        if (found){
            System.out.println("Успешно побрит");
        }
        else {
            System.out.println("Уже лысый");
        }
    }
     public void outputInfo(ArrayList<Seller> sellers){
        for (Seller seller:sellers) {
          System.out.println("ID: " + seller.getID() + "\nИмя: " + seller.getName() + "\nВозраст: " + seller.getAge());
            System.out.println();
            
        }
    }
    public void writeToFile(ArrayList<Seller> sellers) throws IOException {
        File file = new File("WareHouseProduct");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter fileBuffered = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(fileBuffered);
        for (int i = 0; i < sellers.size(); i++) {
            printWriter.println(sellers.get(i));
        }
        printWriter.close();
    }

    public void readToFileAndPrint(ArrayList<Seller> sellers) throws FileNotFoundException {
        File file = new File("WareHouseProduct");
        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                System.out.println("Список продавцов:");
                int line = 1;
                while (scanner.hasNextLine()) {
                    System.out.println(line + ". " + scanner.nextLine());
                    line++;
                }
            } else {
                System.out.println("Нет продавцов");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }
}
