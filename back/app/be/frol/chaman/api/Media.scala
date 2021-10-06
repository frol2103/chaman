package be.frol.chaman.api

import be.frol.chaman.Conf
import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import play.api.mvc._

import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO
import javax.inject.Inject
import scala.concurrent.ExecutionContext

class Media @Inject()(
                       c: ControllerComponents,
                     )(
                       implicit val ec: ExecutionContext
                     ) extends AbstractController(c) {

  def itemQr(id: String) = Action{ r =>
    val barcodeWriter = new QRCodeWriter();
    val bitMatrix = barcodeWriter.encode(Conf.qrCodePrefix + id, BarcodeFormat.QR_CODE, 200, 200);

    val os = new ByteArrayOutputStream()
    ImageIO.write(MatrixToImageWriter.toBufferedImage(bitMatrix), "png", os)
    Ok(os.toByteArray).as("image/png");
  }

}
