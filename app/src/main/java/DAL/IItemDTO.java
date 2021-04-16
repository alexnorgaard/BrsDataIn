package DAL;

public interface IItemDTO {
  int getItemId();
  void setItemId(int ItemId);

  int getItemNumber();
  void setItemNumber(int ItemNumber);

  String getItemName();
  void setItemName(String ItemName);

  String getItemType();
  void setItemType(String ItemType);
}
