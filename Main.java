import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        ArrayList<WarehouseCell> productInPointOfSale = new ArrayList<>();
        ArrayList<WarehouseCell> productList = new ArrayList<>();
        ArrayList<Warehouse> warehouseList = new ArrayList<>();
        ArrayList<PointOfSale> pointOfSalesList = new ArrayList<>();
        ArrayList<Buyer> buyersList = new ArrayList<>();
        ArrayList<Worker> workers = new ArrayList<>();
        ArrayList<Seller> sellerList = new ArrayList<>();
        ArrayList<WarehouseCell> productsForBuyers = new ArrayList<>();
        while (true) {
            System.out.println("======MENU======");
            System.out.println("1. Склад");
            System.out.println("2. Пункт продаж");
            System.out.println("3. Покупатель");
            System.out.println("4. Продавец");
            System.out.println("5. Продукты");
            System.out.println("6. Работник");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    showWarehouseMenu(sc,warehouseList,productInPointOfSale,productsForBuyers);
                    break;
                case 2:
                    showPointOfSaleMenu(sc, productInPointOfSale,pointOfSalesList);
                    break;
                case 3:
                    showBuyerMenu(sc, productInPointOfSale,buyersList,productsForBuyers);
                    break;
                case 4:
                    showSellerMenu(sc,sellerList);
                case 5:
                    showWarehouseCellMenu(sc, productInPointOfSale,productList);
                    break;
                case 6:
                    showWorkerMenu(sc,workers);
                    break;
                default:
                    System.out.println("Ну ты совсем косорылый?");
            }
        }
    }

    private static void showWarehouseMenu(Scanner sc,ArrayList<Warehouse> warehouseList,ArrayList<WarehouseCell> productInPointOfSale,ArrayList<WarehouseCell> productsForBuyers) throws IOException {
        Warehouse warehouse = new Warehouse();
        Buyer buyers = new Buyer();

        while (true) {
            System.out.println("\n======Меню склада======");
            System.out.println("1. Информация о складе/ах");
            System.out.println("2. Ввести информацию о складе/ах");
            System.out.println("3. Информация о продуктах в складе");
            System.out.println("4. Передать продукты в пункт продаж");
            System.out.println("5. Удалить склад");
            System.out.println("6. Назад");
            System.out.println("Выберите опцию");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    warehouse.readToFileAndPrint(warehouseList);
                    break;
                case 2:
                    warehouse.InfoWarehouse(warehouseList);
                    warehouse.writeToFile(warehouseList);
                    break;
                case 3:
                    warehouse.outputInfoWarehouse(warehouseList);
                case 4:
                    buyers.received(productInPointOfSale, productsForBuyers);
                    break;
                case 5:
                    warehouse.Removal(warehouseList);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Ну ты реально косорылый");
            }
        }
    }

    private static void showWarehouseCellMenu(Scanner sc, ArrayList<WarehouseCell> productInPointOfSale, ArrayList<WarehouseCell> productList) {
        WarehouseCell product = new WarehouseCell();
        PointOfSale pointOfSale1 = new PointOfSale();

        while (true) {

            System.out.println("\n======Меню ячеек======");
            System.out.println("1. Информация о продукте/ах");
            System.out.println("2. Добавить продукт");
            System.out.println("3. Передать продукт в склад");
            System.out.println("4. Назад");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    product.outputInfoProduct(productList);
                    break;
                case 2:
                    product.ProductInfo(productList);
                    break;
                case 3:
                    product.receivedProduct(productList, productInPointOfSale);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Прекращай");
            }
        }
    }

    private static void showPointOfSaleMenu(Scanner sc, ArrayList<WarehouseCell> productInPointOfSale, ArrayList<PointOfSale> pointOfSalesList) {
        PointOfSale pointOfSales = new PointOfSale();
        while (true) {
            System.out.println("\n======Меню пункта продаж======");
            System.out.println("1. Информация о пункте/ах продаж");
            System.out.println("2. Ввести информацию о пункте/ах продаж");
            System.out.println("3. Удалить пункт/ы продаж");
            System.out.println("4. Продукты переданные в пункт продажи");
            System.out.println("5. Назад");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    pointOfSales.outputInfo(pointOfSalesList);
                    break;
                case 2:
                    pointOfSales.inputInfo(pointOfSalesList);
                    break;
                case 3:
                    pointOfSales.BurningPointOfSale(pointOfSalesList);
                    break;
                case 4:
                    pointOfSales.outputInfoProduct(productInPointOfSale);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Ты сейчас серьезно,собака?");
            }
        }
    }

    private static void showBuyerMenu(Scanner sc, ArrayList<WarehouseCell> productInPointOfSale, ArrayList<Buyer> buyersList, ArrayList<WarehouseCell> productsForBuyers) {
        Buyer buyers = new Buyer();

        while (true) {

            System.out.println("\n======Меню покупателя======");
            System.out.println("1. Информация о покупателе/ях");
            System.out.println("2. Ввести информацию о покупателе/ях");
            System.out.println("3. Приобретение товара");
            System.out.println("4. Покупки покупателя");
            System.out.println("5. Назад");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    buyers.outputInfoBuyer(buyersList);
                    break;
                case 2:
                    buyers.infoBuyer(buyersList);
                    break;
                case 3:
                    buyers.received(productInPointOfSale, productsForBuyers);
                    break;
                case 4:
                    buyers.outputInfoProductsForBuyers(productsForBuyers);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Нет ты реально приколист,вафля");
            }
        }
    }

    private static void showSellerMenu(Scanner sc,ArrayList<Seller> sellerList) {
        Seller seller = new Seller();

        while (true) {
            System.out.println("\n======Меню продавца======");
            System.out.println("1. Информация о продавце/ах");
            System.out.println("2. Добавить продавца/ов");
            System.out.println("3. Уволить продавца");
            System.out.println("4. Назад");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    seller.outputInfo(sellerList);
                    break;
                case 2:
                    seller.inputInfo(sellerList);
                    break;
                case 3:
                    seller.DismissalSeller(sellerList);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Да пошел ты");
            }
        }
    }

    private static void showWorkerMenu(Scanner sc,ArrayList<Worker> workers) {
        Worker worker = new Worker();

        while (true) {
            System.out.println("\n======Меню работника======");
            System.out.println("1. Информация о работнике/ах");
            System.out.println("2. Добавить работника/ов");
            System.out.println("3. Уволить работника/ов");
            System.out.println("4. Назад");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    worker.outputInfo(workers);
                    break;
                case 2:
                    worker.inputInfo(workers);
                    break;
                case 3:
                    worker.DismissalWorker(workers);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("...");
            }
        }
    }
}