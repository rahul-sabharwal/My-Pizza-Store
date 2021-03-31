package Enums;

public class ItemProperty {
	
	private ItemPropertyType property;
	private String val;
	
	ItemProperty(ItemPropertyType property, String val) {
		this.property = property;
		this.val = val;
	}
	
	public ItemPropertyType getName() {
		return property;
	}
	public void setName(ItemPropertyType propertyName) {
		this.property = propertyName;
	}
	public String getValue() {
		return val;
	}
	public void setValue(String val) {
		this.val = val;
	}

}
