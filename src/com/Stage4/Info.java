package com.Stage4;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Info {
    Scanner sc = new Scanner(System.in);

    public static void showTrucks(Truck[] trucks) {
        System.out.print("  #   |    Bus     |   Drivers   |  State   |\n------+------------+-------------+----------+\n");
        for (int i = 0; i < trucks.length; ++i) {
            System.out.printf("%6s|%12s|%13s|%10s|\n", trucks[i].getId(), trucks[i].getName(), trucks[i].getDriver().getName(), trucks[i].getState());
        }
    }

    public static void showDrivers(Driver[] drivers, Truck[] trucks) {
        System.out.print("  #   |    Drivers     |    Bus   |\n------+----------------+----------+\n");
        for (int i = 0; i < drivers.length; ++i) {
            System.out.printf("%6s|%17s|%9s|\n", drivers[i].getId(), trucks[i].getDriver().getName(), trucks[i].getName());
        }
    }

    public static void userChoice(Truck[] trucks)throws Exception {
        try {
        Scanner sc = new Scanner(System.in);
        int choiceTruck = sc.nextInt();
        for (int i = 0; i <= trucks.length; i++) {
            if (trucks[i].getId() == choiceTruck) {
                System.out.printf("N           :" + trucks[i].getId()+"\n");
                System.out.printf("Bus         :" + trucks[i].getName()+"\n");
                System.out.printf("Drivers     :" + trucks[i].getDriver().getName()+"\n");
                System.out.printf("Bus state   :" + trucks[i].getState()+"\n");
                System.out.println("1 Сменить водителя\n2 Отправить на маршрут\n3 Отправить на ремонт");
                int choiceState = sc.nextInt();
                if (choiceState>3){
                throw new IllegalArgumentException("Нету такого действия");}
                switch (choiceState) {
                    case 1:
                        trucks[i].changeDriver();
                        break;
                    case 2:
                        trucks[i].startDriving();
                        trucks[i].setState("route");
                        trucks[i].setTruckState(new OnRouteState());
                        break;
                    case 3:
                        trucks[i].startRepair();
                        trucks[i].setState("repair");
                        trucks[i].setTruckState(new OnRepairState());
                        break;}
                JsonSerializer.writeTrucks(trucks);
                JsonSerializer.writeTrucks(trucks);
                break;
            }
        }
        }catch (ArrayIndexOutOfBoundsException abe){
            System.out.println("Нету грузовика с данным id номером!");
            userChoice(trucks);
        }catch (InputMismatchException ime){
            System.out.println("Ошибка!!! Нельзя ввоить символы, введите номер id!");
            userChoice(trucks);
        }
    }
}
