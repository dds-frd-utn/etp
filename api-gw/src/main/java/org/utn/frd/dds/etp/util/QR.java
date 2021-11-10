package org.utn.frd.dds.etp.util;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;

public class QR {

    public static BufferedImage createQR(String orderUUID) {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        String url = "http://etp2021.ddns.net:8080" + "/etp/order_items/csv/" + orderUUID;

        BitMatrix bitMatrix = null;

        try {
            bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 250, 250);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}








