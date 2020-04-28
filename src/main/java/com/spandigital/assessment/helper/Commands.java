package com.spandigital.assessment.helper;

public class Commands {
    
    public static String showAll(){
        var builder = new StringBuilder();
        builder.append("Usage:\n");
        builder.append("\tjava -jar games-cli-latest-1.0-SNAPSHOT.jar");
        builder.append("\n\tjava -jar games-cli-latest-1.0-SNAPSHOT.jar -f <path of file>");
        return builder.toString();
    }
}
