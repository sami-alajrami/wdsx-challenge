package wdsx.remotecodechallenge.solution;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
	
   
}
