package com.eteration.simplebanking.Utilities;

import java.util.UUID;

public class UtilityFunctions {

    public static String generateApprovalCode() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
