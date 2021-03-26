package com.gmail.creativegeeksuresh.libraryapp.service.util;

import java.io.File;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.stereotype.Service;

@Service
public class CustomPdfService {

    public void createFile(InputStream inputStream) throws Exception {
        File inputFilePath = new File("E:\\PROJECTS\\Source\\CloudEzMFA\\myreport.pdf");
        File outputFilepath = new File("E:\\testdoc.pdf");

        // BufferedInputStream inputStream = new BufferedInputStream(new
        // FileInputStream(inputFilePath));
        PDDocument document = PDDocument.load(inputStream);

        document.save(outputFilepath);
    }

}
