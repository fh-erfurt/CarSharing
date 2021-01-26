package entity.vehicle;

import entity.EntityInfo;

public interface VehicleInfo extends EntityInfo {
    String getVehicleBrandName();
    String getVehicleModelName();
    String getVehicleModelNumber();
    String getReleaseYear();
    String getVehicleType();
}
