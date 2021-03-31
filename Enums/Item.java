package Enums;

public abstract class Item {
  private ItemType itemType;
	private ItemProperty[] properties = new ItemProperty[0];

  // Constructor
  protected Item(ItemType type){
    this.itemType = type;
  }

  public abstract void inputProperties();

  // Get type of Item
  public String getType(){
    return this.itemType.name();
  }

  public void printDetails() {
		for (ItemProperty prop : this.properties) {
			System.out.print(prop.getValue()+"\t\t");
		}		
    System.out.print("\n");
	}

  public void updateProperty(ItemPropertyType property, String val){
    for(int i=0;i<this.properties.length;i++){
      if(property.equals(this.properties[i].getName())){
        this.properties[i].setValue(val);
      }
    }
  }

  // add a property
  public void addProperty(ItemPropertyType property , String val){
    ItemProperty[] temp = this.properties;
    int len = temp.length;
    this.properties = new ItemProperty[len+1];
    for(int i=0; i<len; i++){
      this.properties[i] = temp[i];
    }
    this.properties[len] = new ItemProperty(property, val);
  }

  public void EditMenu() {
  }

}
