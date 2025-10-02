package com.victorisimo.platzi_play.persistence.mapper;

import jdk.jfr.Name;
import org.mapstruct.Named;

public class StatusMapper {

    @Named("stringToStatus")
    public static Boolean stringToStatus(String status) {
        if(status == null) return null;
        return switch (status.toUpperCase()) {
            case "D" -> true;
            case "N" -> false;
            default -> null;
        };
    }

    @Named("statusToString")
    public static String statusToString(Boolean status) {
        if(status == null) return null;
        return status ? "D" : "N";
    }
}
