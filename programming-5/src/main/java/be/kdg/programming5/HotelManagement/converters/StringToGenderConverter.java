package be.kdg.programming5.HotelManagement.converters;

import be.kdg.programming5.HotelManagement.domain.Gender;
import org.springframework.core.convert.converter.Converter;

public class StringToGenderConverter implements Converter<String, Gender> {
    @Override
    public Gender convert(String source) {
        return switch (source.substring(0, Math.min(source.length(), 3)).toUpperCase()) {
            case "MAL" -> Gender.MALE;
            case "FEM" -> Gender.FEMALE;
            default -> Gender.AGENDER;
        };
    }

}
