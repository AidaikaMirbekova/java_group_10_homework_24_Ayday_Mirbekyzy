package com.Stage3;

import java.util.Random;

public class OnRepairState extends State {
    @Override
    public void changeDriver(Truck truck) throws Exception {
        throw new Exception("Нельзя сменить водителя! Грузовик на ремонте!");
    }

    @Override
    public void startDriving(Truck truck) throws Exception {
        Random rnd = new Random();
        int x = rnd.nextInt(2);
        if (x<=1) {
            System.out.println("Сотояние изменилсь, грузовик в пути!");
            truck.setState("route");
            truck.setTruckState(new OnRouteState());
        }else{
            System.out.println("Состояние изменилось, грузовик на базе!");
            truck.setState("base");
            truck.setTruckState( new OnBaseState());
        }
    }

    @Override
    public void startRepair(Truck truck) throws Exception {
        throw new Exception("Грузовик уже в ремонте!");
    }
}
