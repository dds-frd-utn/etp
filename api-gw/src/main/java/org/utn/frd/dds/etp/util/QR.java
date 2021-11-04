package org.utn.frd.dds.etp.util;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;

public class QR {

    public static BufferedImage createQR(String orderUUID) throws WriterException {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        String url = "http://localhost:8280/etp/orders/csv/" + orderUUID;

        BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 250, 250);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);

    }

}








