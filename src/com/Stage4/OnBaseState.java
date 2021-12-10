package com.Stage4;

public class OnBaseState extends State {
    @Override
    public void changeDriver(Truck truck) throws Exception {
        Driver[] drivers = JsonSerializer.getDrivers();
        Driver driver = truck.getDriver();
        for(int i = 0; i < drivers.length;i++){
            if(drivers[i].isFree()){
                truck.setDriver(drivers[i]);
                drivers[i].setFree(false);
                for(int j = 0; j < drivers.length; j++){
                    if(drivers[j].getId().equals(driver.getId())){
                        drivers[j].setFree(true);
                    }
                }
                JsonSerializer.writeDrivers(drivers);
                System.out.println("Теперь грузовик " + truck.getName() + " ведет водитель " + truck.getDriver().getName());
                System.out.println("теперь водитель " + driver.getName() + " свободен");
                return;
            }
        }
        throw new Exception("нет свободных водителей");
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
        System.out.println("Состояние изменилось, теперь грузовик на ремонте");
        truck.setState("repair");
        truck.setTruckState(new OnRepairState());
    }
}
