package com.wei.itexpdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@SpringBootTest
class SpringBootItexpdfApplicationTests {

    @Test
    void contextLoads() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document,new FileOutputStream("HelloWorld.pdf"));
            document.open();
            document.add(new Paragraph("A hello world pdf document."));
            document.add(new Chunk("This  is sentence 1"));
            document.add(new Chunk("This  is sentence 2"));
            document.add(new Chunk("This  is sentence 3"));
            document.add(new Chunk("This  is sentence 4"));
            document.add(new Chunk("This  is sentence 5"));
            document.add(new Chunk("This  is sentence 6"));
            document.add(new Paragraph("A hello world pdf document."));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
