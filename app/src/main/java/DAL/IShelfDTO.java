package DAL;

public interface IShelfDTO {
  int getShelfId();
  void setShelfId(int ShelfId);

  String getShelfName();
  void setShelfName(String ShelfName);

  int getCompartmentId();
  void setCompartmentId(int CompartmentId);

  int getVehicleId();
  void setVehicleId(int VehicleId);

  int getContainerId();
  void setContainerId(int ContainerId);
}
