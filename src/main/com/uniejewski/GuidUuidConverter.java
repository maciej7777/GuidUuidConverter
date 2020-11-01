package main.com.uniejewski;

import java.util.Optional;
import java.util.regex.Pattern;

public class GuidUuidConverter {

    private static final Pattern UUID_PATTERN = Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");
    private static final Pattern GUID_PATTERN = Pattern.compile("[0-9A-F]{32}$");


    private GuidUuidConverter() {

    }

    public static boolean isUuidValid(String uuid) {
        if (uuid == null) {
            return false;
        }
        return UUID_PATTERN.matcher(uuid).matches();
    }

    public static boolean isGuidValid(String guid) {
        if (guid == null) {
            return false;
        }
        return GUID_PATTERN.matcher(guid).matches();
    }

    public static Optional<String> tryToConvertGuidToUuid(String guid) {
        return Optional.ofNullable(guid)
                .filter(GuidUuidConverter::isGuidValid)
                .map(GuidUuidConverter::convertGuidToUuid);
    }

    public static Optional<String> tryToConvertUuidToGuid(String uuid) {
        return Optional.ofNullable(uuid)
                .filter(GuidUuidConverter::isUuidValid)
                .map(GuidUuidConverter::convertUuidToGuid);
    }

    private static String convertGuidToUuid(String guid) {
        StringBuilder uuidBuilder = new StringBuilder(guid);
        uuidBuilder.insert(8, "-");
        uuidBuilder.insert(13, "-");
        uuidBuilder.insert(18, "-");
        uuidBuilder.insert(23, "-");

        return uuidBuilder.toString().toLowerCase();
    }

    private static String convertUuidToGuid(String uuid) {
        return uuid.replace("-", "").toUpperCase();
    }
}
