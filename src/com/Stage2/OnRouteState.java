package com.Stage2;

public class OnRouteState extends State {
    @Override
    public void changeDriver(Truck truck) throws Exception {
        throw new Exception("Мне теперь из кабины на ходу выпрыгивать?");
    }

    @Override
    public void startDriving(Truck truck) throws Exception {
        throw new Exception("Грузовик уже едет, чего ты еще хочешь?");
    }

    @Override
    public void startRepair(Truck truck) throws Exception {
        System.out.println("Состояние изменилось, теперь грузовик на ремонте");
        truck.setTruckState(new OnRepairState());
        truck.setState("repair");
    }
}
