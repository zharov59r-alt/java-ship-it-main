package ru.yandex.practicum.delivery;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();

    private static ParcelBox<Parcel> standardParcelBox = new ParcelBox(100);
    private static ParcelBox<Parcel> perishableParcelBox = new ParcelBox(100);
    private static ParcelBox<Parcel> fragileParcelBox = new ParcelBox(100);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    showReportStatus();
                    break;
                case 5:
                    showParcelBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Отследить посылки");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {

        Parcel parcel = null;

        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Скоропортящаяся");
        System.out.println("3 — Хрупкая");

        int choiceType = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите описание:");
        String description = scanner.nextLine();

        System.out.println("Введите вес:");
        double weight = Double.parseDouble(scanner.nextLine());

        System.out.println("Введите адрес:");
        String deliveryAddress = scanner.nextLine();

        System.out.println("Введите день отправки:");
        int sendDay = Integer.parseInt(scanner.nextLine());

        if (choiceType == 1) {

            parcel = new StandardParcel(description,
                                        weight,
                                        deliveryAddress,
                                        sendDay);

            standardParcelBox.addParcel(parcel);

        } else if (choiceType == 2) {

            System.out.println("Введите срок хранения:");
            int timeToLive = Integer.parseInt(scanner.nextLine());

            parcel = new PerishableParcel(  description,
                                            weight,
                                            deliveryAddress,
                                            sendDay,
                                            timeToLive);

            perishableParcelBox.addParcel(parcel);

        } else if (choiceType == 3) {

            parcel = new FragileParcel( description,
                                        weight,
                                        deliveryAddress,
                                        sendDay);

            trackableParcels.add((Trackable) parcel);

            fragileParcelBox.addParcel(parcel);

        }

        allParcels.add(parcel);

    }

    private static void sendParcels() {
        for (Parcel parcel: allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        double sum = 0;
        for (Parcel parcel: allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок составляет " + sum);
    }

    private static void showReportStatus() {

        System.out.println("Введите местоположение:");

        for (Trackable parcel: trackableParcels) {
            parcel.reportStatus(scanner.nextLine());
        }
    }

    private static void showParcelBox() {

        System.out.println("Выберите тип коробки:");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Скоропортящаяся");
        System.out.println("3 — Хрупкая");

        int choiceType = Integer.parseInt(scanner.nextLine());

        switch (choiceType) {
            case 1:
                standardParcelBox.getAllParcels();
                break;
            case 2:
                perishableParcelBox.getAllParcels();
                break;
            case 3:
                fragileParcelBox.getAllParcels();
                break;
            default:
                System.out.println("Неверный выбор.");
        }

    }




}