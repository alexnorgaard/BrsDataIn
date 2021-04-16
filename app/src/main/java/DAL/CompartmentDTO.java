package DAL;

import java.io.Serializable;

public class CompartmentDTO implements Serializable, ICompartmentDTO {
  private int compartmentId, vehicleId, containerId;
  private String compartmentName;

  @Override
  public int getCompartmentId() {
    return compartmentId;
  }

  @Override
  public void setCompartmentId(int CompartmentId) {
    this.compartmentId = compartmentId;
  }

  @Override
  public String getCompartmentName() {
    return compartmentName;
  }

  @Override
  public void setCompartmentName(String CompartmentName) {
    this.compartmentName = compartmentName;
  }

  @Override
  public int getVehicleId() {
    return vehicleId;
  }

  @Override
  public void setVehicleId(int VehicleId) {
    this.vehicleId = vehicleId;
  }

  @Override
  public int getContainerId() {
    return containerId;
  }

  @Override
  public void setContainerId(int ContainerId) {
    this.containerId = containerId;
  }
}
