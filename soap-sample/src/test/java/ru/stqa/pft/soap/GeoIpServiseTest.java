package ru.stqa.pft.soap;

import com.sun.org.apache.xpath.internal.operations.Equals;
import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiseTest {

  @Test
  public void testMyIp(){
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("77.111.244.31");
    assertEquals(geoIP.getCountryCode(), "FRA");
  }

  @Test
  public void testInvalidIp(){
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("77.111.244.xx");
    assertEquals(geoIP.getCountryCode(), "FRA");
  }
}
