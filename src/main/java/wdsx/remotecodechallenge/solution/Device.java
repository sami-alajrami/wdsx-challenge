/**
 * 
 */
package wdsx.remotecodechallenge.solution;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Sami Alajrami (s.alajrami@gmail.com)
 *
 * @version 1.0 - 5 Oct 2016
 */
public class Device 
{
	private String brand;
	private String model;
	private String formFactor;
	private ArrayList<HashMap<String,String>> attributes;

	/**
	 * constructor
	 * @param brand
	 * @param model
	 * @param formFactor
	 */
	public Device(String brand, String model, String formFactor) 
	{
		this.setBrand(brand);
		this.setModel(model);
		this.setFormFactor(formFactor);
		this.setAttributes(new ArrayList<HashMap<String,String>>());
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the formFactor
	 */
	public String getFormFactor() {
		return formFactor;
	}

	/**
	 * @param formFactor the formFactor to set
	 */
	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}

	/**
	 * @return the attributes
	 */
	public ArrayList<HashMap<String,String>> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(ArrayList<HashMap<String,String>> attributes) {
		this.attributes = attributes;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return brand + "-" + model;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o)
	{
		Device d = (Device) o;
		if(d != null)
			return this.brand.equals(d.brand) && this.model.equals(d.model);
		return false;
	}

}
