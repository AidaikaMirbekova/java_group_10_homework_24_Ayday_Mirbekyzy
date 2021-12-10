package com.Stage2;

public class OnBaseState extends State {
    @Override
    public void changeDriver(Truck truck) throws Exception {

    }

    @Override
    public void startDriving(Truck truck) throws Exception {
        if(truck.getDriver() == null){
            throw new Exception("В грузовике нет водителя");
        }
        System.out.println("Состояние изменилось, теперь грузовик в пути");
        truck.setState("route");
        truck.setTruckState(new OnRouteState());
    }

    @Override
    public void startRepair(Truck truck) throws Exception {

    }
}
