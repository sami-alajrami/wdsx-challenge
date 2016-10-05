package wdsx.remotecodechallenge.solution;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

/**
 * @author Sami Alajrami (s.alajrami@gmail.com)
 * 
 * @version 1.0 - 5 Oct 2016
 *
 */
public class DevicesApp 
{
	private static final Logger logger = Logger.getLogger(DevicesApp.class);
	public enum FormFactor{CANDYBAR, SMARTPHONE, PHABLET, CLAMSHELL};
	/**
	 * implementation of story 1
	 * @param filename
	 * @return
	 */
	public List<Device> loadDevicesFromFile(String filename)
	{
		final Type DEVICE_TYPE = new TypeToken<List<Device>>() {}.getType();
		Gson gson = new Gson();
		JsonReader reader;
		List<Device> devices = new ArrayList<Device>();
		try 
		{
			reader = new JsonReader(new FileReader(filename));
			System.out.println("test" + reader.getPath());
			devices = gson.fromJson(reader, DEVICE_TYPE);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return devices;
	}
	
	/**
	 * implementation of Story 2
	 * @param filename
	 * @param brand
	 * @param model
	 * @return
	 */
	public String selectByName(String filename, String brand, String model)
	{
		String result = "";
		List<Device> devices = loadDevicesFromFile(filename);
		for(Device d: devices)
			if(d.getBrand().equals(brand) && d.getModel().equals(model))
				result += d + " ";
		return result.trim();
	}
	
	/**
	 * implementation of Story 3
	 * @param filename
	 * @return
	 */
	public List<Device> loadValidDevicesFromFile(String filename)
	{
		List<Device> validDevices = new ArrayList<Device>();
		List<Device> devices = loadDevicesFromFile(filename);
		for(Device d: devices)
			if(isValid(d, devices))
				validDevices.add(d);
			else
				logger.info("invalid device: " + d);					
		return validDevices;		
	}
	
	/**
	 * checks if Device is valid
	 * @param d
	 * @param devices
	 * @return
	 */
	private boolean isValid(Device d, List<Device> devices)
	{
		int counter = 0;
		for(Device device: devices)
			if(d.equals(device))
				counter++;
		if(counter > 1)
			return false;
		if(d.getBrand().length() > 50 || d.getModel().length() > 50)
			return false;
		if(!isInEnum(d.getFormFactor(), FormFactor.class))
			return false;
		if(d.getAttributes().size() > 0)
			for(HashMap<String,String> map: d.getAttributes())
			{
				Iterator<Entry<String, String>> it = map.entrySet().iterator();
				while (it.hasNext()) 
				{
			        Map.Entry<String, String> pair = (Map.Entry<String, String>)it.next();
			        if(pair.getKey() == null || pair.getValue() == null)
			        	return false;
			        if(pair.getKey().length() > 20|| pair.getValue().length() > 100)
			        	return false;
				}
			}
					
		return true;		
	}
	
	/**
	 * http://stackoverflow.com/questions/10199462/how-to-check-if-a-given-string-is-a-part-of-any-given-enum-in-java
	 * @param value
	 * @param enumClass
	 * @return
	 */
	 private <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass)
	 {
		  for (E e : enumClass.getEnumConstants()) 
		  {
		    if(e.name().equals(value)) { return true; }
		  }
		  return false;
	 }

	
   
}
