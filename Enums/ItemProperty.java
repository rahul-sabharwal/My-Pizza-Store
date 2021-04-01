package Enums;

public class ItemProperty {
	
	private ItemPropertyType property;
	private String strval;
	private int intval;
	
	ItemProperty(ItemPropertyType property, String strval) {
		this.property = property;
		this.strval = strval;
	}

	ItemProperty(ItemPropertyType property, int intval) {
		this.property = property;
		this.intval = intval;
	}
	
	public ItemPropertyType getName() {
		return property;
	}
	public void setName(ItemPropertyType propertyName) {
		this.property = propertyName;
	}
	public String getValue() {
		return strval;
	}
	public int getIntValue() {
		return intval;
	}
	public void setValue(String strval) {
		this.strval = strval;
	}

	public void setValue(int intval){
		this.intval = intval;
	}

}
