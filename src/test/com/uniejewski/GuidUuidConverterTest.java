package test.com.uniejewski;

import main.com.uniejewski.GuidUuidConverter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GuidUuidConverterTest {

    @DataProvider
    private Object[][] guidsAndUuids() {
        return new Object[][]{
                {"23F80AE87D7D0D4B8FDFA3B20E02F878", "23f80ae8-7d7d-0d4b-8fdf-a3b20e02f878"},
                {"E43179F0E4D3F145A32EC2F711F4C7BC", "e43179f0-e4d3-f145-a32e-c2f711f4c7bc"}
        };
    }

    @Test(dataProvider = "guidsAndUuids")
    public void testConvertGuidToUuid(String givenGuid, String expectedUuid) {
        assertEquals(GuidUuidConverter.convertGuidToUuid(givenGuid), expectedUuid);
    }

    @Test(dataProvider = "guidsAndUuids")
    public void testConvertUuidToGuid(String expectedGuid, String givenUuid) {
        assertEquals(GuidUuidConverter.convertUuidToGuid(givenUuid), expectedGuid);
    }

}