package entity.beta.vehicle;

import auth.beta.idtoken.IdTokenResult;
import exception.authexception.AuthInvalidUserException;
import job.Job;

public class Vehicle extends VehicleEntity{

    private String brandName;
    private String modelName;
    private String modelNumber;
    private String releaseYear;
    private String vehicleType;
    private boolean inUse;
    private String userId;

    public Vehicle(String _brandName,String _modelName,String _modelNumber, String _releaseYear, String _vehicleType)
    {
        this.brandName = _brandName;
        this.modelName = _modelName;
        this.modelNumber = _modelNumber;
        this.releaseYear = _releaseYear;
        this.vehicleType = _vehicleType;
        this.inUse = false;
        userId = null;
    }

    public String getUserId()
    {
        return userId;
    }

    @Override
    public Job<IdTokenResult> getIDToken(boolean forceRefresh) throws AuthInvalidUserException {
        return super.getIDToken(forceRefresh);
    }

    @Override
    public String getVehicleBrandName() {
        return brandName;
    }

    @Override
    public String getVehicleModelName() {
        return modelName;
    }

    @Override
    public String getVehicleModelNumber() {
        return modelNumber;
    }

    @Override
    public String getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }
}
