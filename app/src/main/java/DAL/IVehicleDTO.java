package DAL;

public interface IVehicleDTO {
  int getVehicleId();
  void setVehicleID(int VehicleID);

  int getLicense();
  void setLicense(int License);

  String getVehicleType();
  void setVehicleType(String VehicleType);

  String getVehiclePurpose();
  void setVehiclePurpose(String VehiclePurpose);

  String getUserResponsible();
  void setUserResponsible(String UserResponsible);
}