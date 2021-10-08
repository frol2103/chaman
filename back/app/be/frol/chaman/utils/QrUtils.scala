package be.frol.chaman.utils

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter

import java.io.{ByteArrayOutputStream, OutputStream}
import javax.imageio.ImageIO

object QrUtils {

  def qrCode(str:String, os:OutputStream) = {

    val barcodeWriter = new QRCodeWriter();
    val bitMatrix = barcodeWriter.encode(str, BarcodeFormat.QR_CODE, 200, 200);

    ImageIO.write(MatrixToImageWriter.toBufferedImage(bitMatrix), "png", os)
  }

  def qrCodeOS(string: String) = {
    val os = new ByteArrayOutputStream()
    qrCode(string,os)
    os
  }

}
