package com.Stage4;

import java.io.IOException;

public class Main {

    public static void main(String[] args)throws Exception {
        Driver[] drivers = {
                new Driver("1","Святослав",false),
                new Driver("2","Иннокентий", true),
                new Driver("3","Виталий", true),
        };
        Truck[] trucks = {
                new Truck(1,"volvo",drivers[0],"base"),
                new Truck(2,"ЗИЛ",drivers[2], "route"),
                new Truck(3,"КАМАЗ",drivers[1], "repair"),
        };

        try{JsonSerializer.writeDrivers(drivers);
            JsonSerializer.writeTrucks(trucks);
            Info.showTrucks(trucks);
            System.out.println();
            System.out.println();
            Info.userChoice(trucks);
            JsonSerializer.writeDrivers(drivers);
            JsonSerializer.writeTrucks(trucks);
            Info.showTrucks(trucks);
        }catch (IOException ie){
            System.out.println("Error!!!");
        }

    }
}
