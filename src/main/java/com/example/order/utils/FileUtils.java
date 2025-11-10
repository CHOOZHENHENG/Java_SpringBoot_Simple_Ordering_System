package com.example.order.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;

@Slf4j
public class FileUtils {
    public static void jsonFileWriter(String dataFile, Object data) throws IOException {
        try(FileWriter file = new FileWriter(dataFile)){
            ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
            file.write(objectWriter.writeValueAsString(data));
        }
    }
}
