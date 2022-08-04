package com.example.simplebarcodegenerator;

import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

@SpringBootApplication
public class SimpleBarcodeGeneratorApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SimpleBarcodeGeneratorApplication.class, args);
        var barcode = generateEAN13BarcodeImage("4650118460249");
        File outputfile = new File("image.png");
        ImageIO.write(barcode, "png", outputfile);
    }

    private static BufferedImage generateEAN13BarcodeImage(String barcodeText) {
        EAN13Bean barcodeGenerator = new EAN13Bean();
        BitmapCanvasProvider canvas =
                new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);

        barcodeGenerator.generateBarcode(canvas, barcodeText);
        return canvas.getBufferedImage();
    }

}
