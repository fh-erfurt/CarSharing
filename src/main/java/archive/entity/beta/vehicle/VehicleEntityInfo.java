package entity.beta.vehicle;

import entity.beta.appentity.AppEntityInfo;

public interface VehicleEntityInfo extends AppEntityInfo {
    String getVehicleBrandName();
    String getVehicleModelName();
    String getVehicleModelNumber();
    String getReleaseYear();
    String getVehicleType();
}
