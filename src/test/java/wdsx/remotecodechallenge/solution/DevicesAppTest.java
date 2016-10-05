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
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DevicesAppTest( String testName )
    {
        super( testName );
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
    	String filename = "devices.json";
    	DevicesApp app = new DevicesApp();
    	List<Device> result = app.loadDevicesFromFile(filename);
    	assert(result != null && result.size() == 3);
    }
}
