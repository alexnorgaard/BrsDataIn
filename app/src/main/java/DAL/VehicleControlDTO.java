package DAL;

import java.io.Serializable;

public class VehicleControlDTO implements Serializable, IVehicleControlDTO {
  private int vehicleControlId, userId, vehicleId;

  @Override
  public int getVehicleControlId() {
    return vehicleControlId;
  }

  @Override
  public void setVehicleControlId(int VehicleControlId) {
    this.vehicleControlId = vehicleControlId;
  }

  @Override
  public int getUserId() {
    return userId;
  }

  @Override
  public void setUserId(int UserId) {
    this.userId = userId;
  }

  @Override
  public int getVehicleId() {
    return vehicleId;
  }

  @Override
  public void setVehicleId(int VehicleId) {
    this.vehicleId = vehicleId;
  }
}
