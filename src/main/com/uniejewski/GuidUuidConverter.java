package main.com.uniejewski;

public class GuidUuidConverter {

    public static String convertGuidToUuid(String guid) {
        StringBuilder uuidBuilder = new StringBuilder(guid);
        uuidBuilder.insert(8, "-");
        uuidBuilder.insert(13, "-");
        uuidBuilder.insert(18, "-");
        uuidBuilder.insert(23, "-");

        return uuidBuilder.toString().toLowerCase();
    }

    public static String convertUuidToGuid(String uuid) {
        return uuid.replace("-", "").toUpperCase();
    }
}
