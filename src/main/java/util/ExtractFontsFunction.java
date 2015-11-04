package util;

import com.google.common.base.Function;
import domain.Family;
import domain.Font;

import java.util.List;

public class ExtractFontsFunction implements Function<Family, List<Font>> {
    public List<Font> apply(Family input) {
        return input.getFonts();
    }
}
