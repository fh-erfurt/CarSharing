package entity.vehicle;

import entity.AppEntityInfo;

public interface VehicleEntityInfo extends AppEntityInfo {
    String getVehicleBrandName();
    String getVehicleModelName();
    String getVehicleModelNumber();
    String getReleaseYear();
    String getVehicleType();
}
