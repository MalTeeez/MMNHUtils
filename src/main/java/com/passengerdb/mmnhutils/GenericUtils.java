package com.passengerdb.mmnhutils;

import java.util.regex.Pattern;

public class GenericUtils {

    private GenericUtils() {}

    public static final Pattern CHAT_FORMATTING_CODE_PATTERN = Pattern.compile("(?i)\\u00a7[0-9A-FK-OR]");

    public static String getTextWithoutFormattingCodes(String text) {
        return text == null ? null
            : CHAT_FORMATTING_CODE_PATTERN.matcher(text)
                .replaceAll("");
    }

}
