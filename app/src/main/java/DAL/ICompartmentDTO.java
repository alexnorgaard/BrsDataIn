package DAL;

public interface ICompartmentDTO {
  int getCompartmentId();
  void setCompartmentId(int CompartmentId);

  String getCompartmentName();
  void setCompartmentName(String CompartmentName);

  int getVehicleId();
  void setVehicleId(int VehicleId);

  int getContainerId();
  void setContainerId(int ContainerId);
}
