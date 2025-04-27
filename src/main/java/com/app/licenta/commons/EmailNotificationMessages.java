package com.app.licenta.commons;

public class EmailNotificationMessages {
    public static final String NEW_AD_CREATED_TITLE = "Un nou anunț a fost creat de un trainer pe care îl urmărești!";
    public static final String NEW_AD_CREATED_BODY = "Bună! \n Un nou anunț a fost creat de un trainer pe care îl urmărești: %s! \n" +
            "Poți verifica în aplicație!";
    public static final String NEW_GROUP_CREATED_TITLE = "O nouă grupă a fost creată!";
    public static final String NEW_GROUP_CREATED_BODY = "Bună! \n O nouă grupă a fost creată: %s! \n" +
            "Poți verifica în aplicație!";
    public static final String ENROLLMENT_REQUEST_APPROVED_TITLE = "Cererea de înscriere a fost acceptată!";
    public static final String ENROLLMENT_REQUEST_APPROVED_BODY = "Cererea de înscriere a copilului %s la anunțul %s a fost acceptată! \n" +
            "Poți verifica în aplicație!";
    public static final String ENROLLMENT_REQUEST_REJECTED_TITLE = "Cererea de înscriere a fost respinsă!";
    public static final String ENROLLMENT_REQUEST_REJECTED_BODY = "Cererea de înscriere a copilului %s la anunțul %s a fost respinsă! \n" +
            "Poți verifica în aplicație!";
    public static final String GROUP_COMPLETED_DIPLOMA_TITLE = "Diplomă de participare pentru copilul dumneavoastră: %s";
    public static final String GROUP_COMPLETED_DIPLOMA_BODY = "Felicitări! Ați primit o diplomă de participare pentru copilul dumneavoastră, %s, pentru activitatea pe care a finalizat-o: %s.\n\nDescarcă atașamentul pentru a revendica diploma. \n";

    private EmailNotificationMessages() {

    }
}
