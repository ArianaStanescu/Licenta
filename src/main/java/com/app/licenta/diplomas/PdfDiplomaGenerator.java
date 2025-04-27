package com.app.licenta.diplomas;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.Objects;

@Component
public class PdfDiplomaGenerator {

    public byte[] generateDiploma(String childName, String activityName, LocalDate from, LocalDate until, String trainerName) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Document document = new Document(PageSize.A4.rotate());
        PdfWriter writer = PdfWriter.getInstance(document, baos);

        writer.setPageEvent(new PdfPageEventHelper() {
            @Override
            public void onEndPage(PdfWriter writer, Document document) {
                try {
                    Image bg = Image.getInstance(Objects.requireNonNull(getClass().getClassLoader().getResource("diploma-background.jpg")));
                    bg.scaleToFit(PageSize.A4.getHeight(), PageSize.A4.getWidth());
                    bg.setAbsolutePosition(0, 18);
                    PdfContentByte canvas = writer.getDirectContentUnder();
                    canvas.addImage(bg);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        document.open();

        Font titleFont = new Font(Font.HELVETICA, 32, Font.BOLD);
        Font textFont = new Font(Font.HELVETICA, 18);
        Font boldFont = new Font(Font.HELVETICA, 20, Font.BOLD);

        Paragraph emptyLineHeader = new Paragraph(" ", textFont);
        emptyLineHeader.setAlignment(Element.ALIGN_CENTER);
        document.add(emptyLineHeader);

        Paragraph title = new Paragraph("Diploma de participare", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(30);
        document.add(title);

        Paragraph recipientDescription = new Paragraph("Se acordă lui", textFont);
        recipientDescription.setAlignment(Element.ALIGN_CENTER);
        document.add(recipientDescription);

        Paragraph recipient = new Paragraph(childName, boldFont);
        recipient.setAlignment(Element.ALIGN_CENTER);
        recipient.setSpacingAfter(20);
        document.add(recipient);

        Paragraph activityDescription = new Paragraph("Pentru participarea la activitatea", textFont);
        activityDescription.setAlignment(Element.ALIGN_CENTER);
        document.add(activityDescription);

        Paragraph activity = new Paragraph(activityName, boldFont);
        activity.setAlignment(Element.ALIGN_CENTER);
        activity.setSpacingAfter(20);
        document.add(activity);

        Paragraph periodDescription = new Paragraph("ce a avut loc în intervalul de timp", textFont);
        periodDescription.setAlignment(Element.ALIGN_CENTER);
        document.add(periodDescription);

        Paragraph period = new Paragraph(from.toString() + " - " + until.toString(), boldFont);
        period.setAlignment(Element.ALIGN_CENTER);
        document.add(period);

        Paragraph trainerDescription = new Paragraph("organizată de către trainer-ul", textFont);
        trainerDescription.setAlignment(Element.ALIGN_CENTER);
        trainerDescription.setSpacingBefore(10);
        document.add(trainerDescription);

        Paragraph trainer = new Paragraph(trainerName, boldFont);
        trainer.setAlignment(Element.ALIGN_CENTER);
        document.add(trainer);

        Paragraph footer = new Paragraph("KidSphere", titleFont);
        footer.setSpacingBefore(30);
        footer.setAlignment(Element.ALIGN_CENTER);
        document.add(footer);

        document.close();
        return baos.toByteArray();
    }
}
