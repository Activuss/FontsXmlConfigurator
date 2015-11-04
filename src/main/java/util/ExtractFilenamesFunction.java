package util;

import com.google.common.base.Function;
import domain.Font;

public class ExtractFilenamesFunction implements Function<Font, String> {

    public String apply(Font input) {
        return input.getFileName();
    }
}
