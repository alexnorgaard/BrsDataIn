package DAL;

import java.io.Serializable;

public class ShelfDTO implements Serializable, IShelfDTO {
  private int shelfId, compartmentId, vehicleId, containerId;
  private String shelfName;

  @Override
  public int getShelfId() {
    return shelfId;
  }

  @Override
  public void setShelfId(int ShelfId) {
    this.shelfId = shelfId;
  }

  @Override
  public String getShelfName() {
    return shelfName;
  }

  @Override
  public void setShelfName(String ShelfName) {
    this.shelfName = shelfName;
  }

  @Override
  public int getCompartmentId() {
    return compartmentId;
  }

  @Override
  public void setCompartmentId(int CompartmentId) {
    this.compartmentId = compartmentId;
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
