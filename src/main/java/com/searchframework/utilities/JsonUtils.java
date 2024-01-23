package com.searchframework.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;

@Log4j2
public class JsonUtils {

    public <T> T convertJsonToJava(String fileName, Class<T> type) {
        T classType;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            log.debug("Converted JSON values from file to Java Object ");
            classType = objectMapper.readValue(new File(fileName), type);
        } catch (IOException e) {
            log.error("Json File is not correct or missing");
            classType = null;
        }
        return classType;
    }

}
