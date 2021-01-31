package archive.main.entity.beta.vehicle;

import archive.main.entity.beta.appentity.AppEntityInfo;

public interface VehicleEntityInfo extends AppEntityInfo {
    String getVehicleBrandName();
    String getVehicleModelName();
    String getVehicleModelNumber();
    String getReleaseYear();
    String getVehicleType();
}
