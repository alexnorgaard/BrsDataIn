package DAL;

public interface IContainerDTO {
  int getContainerId();
  void setContainerId(int ContainerId);

  int getLicense();
  void setLicense(int License);

  String getContainerType();
  void setContainerType(String ContainerType);

  String getUnitResponsible();
  void setUnitResponsible(String UnitResponsible);
}
