package com.Stage2;

public class Info {
    public static void showTrucks(Truck[] trucks){
        System.out.print("  #   |    Bus     |   Drivers   |  State   |\n------+------------+-------------+----------+\n");
        for (int i = 0; i < trucks.length; ++i) {
            System.out.printf("%6s|%12s|%13s|%10s|\n", trucks[i].getId(), trucks[i].getName(), trucks[i].getDriver().getName(), trucks[i].getState());
        }
    }
    public static void showDrivers(Driver[] drivers,Truck[] trucks){
        System.out.print("  #   |    Drivers     |    Bus   |\n------+----------------+----------+\n");
        for (int i = 0; i < drivers.length; ++i) {
            System.out.printf("%6s|%17s|%9s|\n", drivers[i].getId(), trucks[i].getDriver().getName(), trucks[i].getName());
        }
    }


}
