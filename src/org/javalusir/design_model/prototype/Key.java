package org.javalusir.design_model.prototype;

/**
 * this is prototype clone object
 * @author JavaLuSir
 *
 */
public class Key implements Cloneable{

	private String keyOwner;
	
	private String keyType;
	
	/**
	 * other object copy this object by this method
	 */
	public Key clone(){
		
		try {
			return (Key) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	public String getKeyOwner() {
		return keyOwner;
	}

	public void setKeyOwner(String keyOwner) {
		this.keyOwner = keyOwner;
	}

	public String getKeyType() {
		return keyType;
	}

	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
}
