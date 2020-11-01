package test.com.uniejewski;

import main.com.uniejewski.GuidUuidConverter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

import static java.util.Optional.empty;
import static org.testng.Assert.assertEquals;

public class GuidUuidConverterTest {

    @DataProvider
    private Object[][] guidsAndExpectedUuids() {
        return new Object[][]{
                {"23F80AE87D7D0D4B8FDFA3B20E02F878", Optional.of("23f80ae8-7d7d-0d4b-8fdf-a3b20e02f878")},
                {"E43179F0E4D3F145A32EC2F711F4C7BC", Optional.of("e43179f0-e4d3-f145-a32e-c2f711f4c7bc")},
                {"", empty()}
        };
    }

    @Test(dataProvider = "guidsAndExpectedUuids")
    public void testConvertProperGuidToUuid(String givenGuid, Optional<String> expectedUuid) {
        assertEquals(GuidUuidConverter.tryToConvertGuidToUuid(givenGuid), expectedUuid);
    }

    @DataProvider
    private Object[][] uuidsAndExpectedGuids() {
        return new Object[][]{
                {"23f80ae8-7d7d-0d4b-8fdf-a3b20e02f878", Optional.of("23F80AE87D7D0D4B8FDFA3B20E02F878")},
                {"e43179f0-e4d3-f145-a32e-c2f711f4c7bc", Optional.of("E43179F0E4D3F145A32EC2F711F4C7BC")},
                {"", empty()}
        };
    }

    @Test(dataProvider = "uuidsAndExpectedGuids")
    public void testConvertProperUuidToGuid(String givenGuid, Optional<String> expectedUuid) {
        assertEquals(GuidUuidConverter.tryToConvertUuidToGuid(givenGuid), expectedUuid);
    }

    @DataProvider
    private Object[][] guidsAndExpectedValid() {
        return new Object[][]{
                {"23F80AE87D7D0D4B8FDFA3B20E02F878", true},
                {"E43179F0E4D3F145A32EC2F711F4C7BC", true},
                {null, false},
                {"", false},
                {"this is not a guid", false},
                {"23F", false},
                {"TTF80AE87D7D0D4B8FDFA3B20E02F878", false},
                {"ffF80AE87D7D0D4B8FDFA3B20E02F878", false},
                {"23F80AE87D7D0D4B8FDFA3B20E02F8", false},
                {"23f80ae8-7d7d-0d4b-8fdf-a3b20e02f878", false}
        };
    }

    @Test(dataProvider = "guidsAndExpectedValid")
    public void testIsGuidValid(String givenGuid, boolean expectedValid) {
        assertEquals(GuidUuidConverter.isGuidValid(givenGuid), expectedValid);
    }

    @DataProvider
    private Object[][] uuidsAndExpectedValid() {
        return new Object[][]{
                {"23f80ae8-7d7d-0d4b-8fdf-a3b20e02f878", true},
                {"e43179f0-e4d3-f145-a32e-c2f711f4c7bc", true},
                {null, false},
                {"", false},
                {"this is not an uuid", false},
                {"23f", false},
                {"23F80AE87D7D0D4B8FDFA3B20E02F878", false},
                {"y43179f0-e4d3-f145-a32e-c2f711f4c7bc", false},
                {"e43179f0-e4d3-f145-a32e-c2f711f4c7", false},
                {"E43179f0-e4d3-f145-a32e-c2f711f4c7bc", false}
        };
    }

    @Test(dataProvider = "uuidsAndExpectedValid")
    public void testIsUuidValid(String givenGuid, boolean expectedValid) {
        assertEquals(GuidUuidConverter.isUuidValid(givenGuid), expectedValid);
    }
}