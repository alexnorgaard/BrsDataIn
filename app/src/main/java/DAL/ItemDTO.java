package DAL;

import java.io.Serializable;

public class ItemDTO implements Serializable, IItemDTO {
  private int itemId, itemNumber;
  private String itemName, itemType;

  @Override
  public int getItemId() {
    return itemId;
  }

  @Override
  public void setItemId(int ItemId) {
    this.itemId = itemId;
  }

  @Override
  public int getItemNumber() {
    return itemNumber;
  }

  @Override
  public void setItemNumber(int ItemNumber) {
    this.itemNumber = itemNumber;
  }

  @Override
  public String getItemName() {
    return itemName;
  }

  @Override
  public void setItemName(String ItemName) {
    this.itemName = itemName;
  }

  @Override
  public String getItemType() {
    return itemType;
  }

  @Override
  public void setItemType(String ItemType) {
    this.itemType = itemType;
  }
}
