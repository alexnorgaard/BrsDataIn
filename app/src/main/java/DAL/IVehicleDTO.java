package DAL;

public interface IVehicleDTO {
  int getVehicleId();
  void setVehicleId(int VehicleId);

  int getLicense();
  void setLicense(int License);

  String getVehicleType();
  void setVehicleType(String VehicleType);

  String getVehiclePurpose();
  void setVehiclePurpose(String VehiclePurpose);

  String getUnitResponsible();
  void setUnitResponsible(String UnitResponsible);
}