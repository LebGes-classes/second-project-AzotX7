import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Worker extends Human{
    private String post;
    private int placeOfWorkID;
    private ArrayList<Worker> workers = new ArrayList<>();
    public Worker(String post, int placeOfWorkID, String name, int age, int ID){
        super(name, age, ID);
        this.post = post;
        this.placeOfWorkID = placeOfWorkID;
    }
    public Worker(){

    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public void setWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void setPlaceOfWorkID(int placeOfWorkID) {
        this.placeOfWorkID = placeOfWorkID;
    }

    public int getPlaceOfWorkID() {
        return placeOfWorkID;
    }
    public void inputInfo(ArrayList<Worker> workers){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID сотрудника");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите имя сотрудника");
        String name = sc.nextLine();
        System.out.println("Введите возраст сотрудника");
        int age = sc.nextInt();
        System.out.println("Введите ID место работы сотрудника");
        int placeOfWorkID = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите должность сотрудника");
        String post = sc.nextLine();
        System.out.println();
        Worker worker = new Worker(post,placeOfWorkID,name,age,ID);
        workers.add(worker);
    }
    public void DismissalWorker(ArrayList<Worker> workers){
        boolean found = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID сотрудника, которого хотите побрить");
        int dismissal = sc.nextInt();
        Iterator<Worker> iterator = workers.iterator();
        while (iterator.hasNext()){
            Worker w = iterator.next();
            if(w.getID() == dismissal){
                found = true;
                iterator.remove();
                break;
            }
        }
        if(found){
            System.out.println("Побрит");
        }
        else {
            System.out.println("Уже лысый");
        }
    }
    public void outputInfo(ArrayList<Worker> workers){
        for (Worker worker:workers) {
            System.out.println("ID: " + worker.getID() + "\nИмя: " + worker.getName() + "\nВозвраст: " + worker.getAge() + "\nID места работы: " +worker.getPlaceOfWorkID() + "\nДолжность: " + worker.getPost());
            System.out.println();
        }
    }
    public void writeToFile(ArrayList<Worker> workers) throws IOException {
        File file = new File("WareHouseProduct");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter fileBuffered = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(fileBuffered);
        for (int i = 0; i < workers.size(); i++) {
            printWriter.println(workers.get(i));
        }
        printWriter.close();
    }

    public void readToFileAndPrint(ArrayList<Warehouse> warehouseList) throws FileNotFoundException {
        File file = new File("WareHouseProduct");
        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                System.out.println("Список работников на складе:");
                int line = 1;
                while (scanner.hasNextLine()) {
                    System.out.println(line + ". " + scanner.nextLine());
                    line++;
                }
            } else {
                System.out.println("Нет работников");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }
}

