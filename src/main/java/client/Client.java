package client;

import static util.FontsProcessorHelper.getFileNames;
import static util.FontsProcessorHelper.getFonts;
import static util.FontsProcessorHelper.getNormalFonts;
import static util.FontsProcessorHelper.unmarshall;

public class Client {
    public static void main(String[] args) {
        System.out.println(getNormalFonts(getFonts(unmarshall())).get());
        System.out.println(getFileNames(getFonts(unmarshall())).get());
    }
}

