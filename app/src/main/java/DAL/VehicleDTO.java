package DAL;

import java.io.Serializable;

public class VehicleDTO implements Serializable, IVehicleDTO {
  private int vehicleId, license;
  private String vehicleType, vehiclePurpose, userResponsible;


  @Override
  public int getVehicleId() {
    return vehicleId;
  }

  @Override
  public void setVehicleId(int VehicleId) {
    this.vehicleId = vehicleId;
  }

  @Override
  public int getLicense() {
    return license;
  }

  @Override
  public void setLicense(int License) {
    this.license = license;
  }

  @Override
  public String getVehicleType() {
    return vehicleType;
  }

  @Override
  public void setVehicleType(String VehicleType) {
    this.vehicleType = vehicleType;
  }

  @Override
  public String getVehiclePurpose() {
    return vehiclePurpose;
  }

  @Override
  public void setVehiclePurpose(String VehiclePurpose) {
    this.vehiclePurpose = vehiclePurpose;
  }

  @Override
  public String getUserResponsible() {
    return userResponsible;
  }

  @Override
  public void setUserResponsible(String UserResponsible) {
    this.userResponsible = userResponsible;
  }
}
