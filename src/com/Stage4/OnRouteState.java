package com.Stage4;

public class OnRouteState extends State {
    @Override
    public void changeDriver(Truck truck) throws Exception {
        throw new Exception("Грузовик уже в пути, невозможно сменить водителя!");
    }

    @Override
    public void startDriving(Truck truck) throws Exception {
        throw new Exception("Грузовик уже в пути?");
    }

    @Override
    public void startRepair(Truck truck) throws Exception {
        System.out.println("Состояние изменилось, теперь грузовик на ремонте");
        truck.setTruckState(new OnRepairState());
        truck.setState("repair");
    }
}
