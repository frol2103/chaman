package be.frol.chaman.utils

import com.lowagie.text.{Document, PageSize, RectangleReadOnly}
import org.xhtmlrenderer.pdf.ITextRenderer
import play.twirl.api.Html

import java.io.ByteArrayOutputStream

object PdfUtils {
  def toPdfBytes(v: String) = {
    val os = toPdf(v)
    val r = os.toByteArray
    os.close()
    r
  }


  def toPdf(html: String): ByteArrayOutputStream = {

    val renderer = new ITextRenderer()
    val sharedContext = renderer.getSharedContext
    sharedContext.setPrint(true)
    sharedContext.setInteractive(false)
    sharedContext.setReplacedElementFactory(new B64ImgReplacedElementFactory)
    sharedContext.getTextRenderer.setSmoothingThreshold(0)
    renderer.setDocumentFromString(html)
    renderer.layout()
    val os = new ByteArrayOutputStream()
    renderer.createPDF(os)
    os
  }

}
