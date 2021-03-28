package com.gmail.creativegeeksuresh.libraryapp.service.util;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CustomPdfService {

    @Value("${default.storage.path}")
    private String defaultStoragePath;

    public Map<String, Object> createFile(InputStream inputStream, String fileName) throws Exception {

        Map<String, Object> response = new HashMap<>();
        File outputFilepath = new File(defaultStoragePath + fileName);

        PDDocument document = PDDocument.load(inputStream);
        document.setAllSecurityToBeRemoved(Boolean.TRUE);

        document.save(outputFilepath);

        response.put("location", defaultStoragePath + fileName);
        response.put("status", Boolean.TRUE);
        return response;
    }

}
