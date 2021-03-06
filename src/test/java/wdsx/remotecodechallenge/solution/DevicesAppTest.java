package wdsx.remotecodechallenge.solution;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple DevicesApp.
 */
public class DevicesAppTest 
    extends TestCase
{
	String filename;
	DevicesApp app;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DevicesAppTest( String testName )
    {
        super( testName );
        filename = "devices.json";
    	app = new DevicesApp();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DevicesAppTest.class );
    }

    /**
     * Test for Story 1 -- all devices are returned after being loaded from a file
     */
    public void testAllDevicesReturned()
    {
        //fail("not supported yet.");
    	List<Device> result = app.loadDevicesFromFile(filename);
    	assert(result != null && result.size() == 3);
    }
    
    /**
     * Test for Story 2 -- devices matching specific full name are returned
     */
    public void testSelectiveDevicesReturned()
    {
        //fail("not supported yet.");
    	String result = app.selectByName(filename, "Mockia", "5800");
    	assert(result != null && result.split(" ").length == 1);
    }
    
    /**
     * Test for Story 3 -- validate devices
     */
    public void testValidateDevices()
    {
        //fail("not supported yet.");
    	List<Device> result = app.loadValidDevicesFromFile(filename);
    	assert(result != null && result.size() == 3);
    }
    
    /**
     * Test for Story 4 -- select devices by brand
     */
    public void testSelectiveReturnByBrand()
    {
    	//fail("not supported yet.");
    	boolean flag = true;
    	List<Device> result = app.selectByBrand(filename, "Mockia");
    	for(Device d : result)
    		if(d.getBrand().equals("Mockia"))
    			flag = false;
    	assert(flag);
    }
    
    /**
     * Test for Story 4 -- select devices by model
     */
    public void testSelectiveReturnByModel()
    {
    	//fail("not supported yet.");
    	boolean flag = true;
    	List<Device> result = app.selectByModel(filename, "X11");
    	for(Device d : result)
    		if(d.getModel().equals("X11"))
    			flag = false;
    	assert(flag);
    }
    
    
    
}
