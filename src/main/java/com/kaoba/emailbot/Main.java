package com.kaoba.emailbot;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            String site = "https://www.telecontact.ma/liens/pediatre/casablanca.php";// Remplace par un vrai site
            Set<String> emails = EmailScraper.scrapeEmails(site);
            System.out.println("Emails trouvés: " + emails);

            List<String> emailList = new ArrayList<>(emails);

            String sujet = "Offre spéciale KA⚡BA";
            String contenu = "<h1>🔥 Promotion Spéciale sur nos meubles !</h1>" +
                "<p>Découvrez nos nouveaux produits modernes avec des réductions exclusives.</p>" +
                "<img src='https://kaoba.ma/promo.jpg' width='400'/>" +
                "<p><strong>Visitez-nous :</strong> <a href='https://kaoba.ma'>kaoba.ma</a></p>";


            EmailSender.sendEmail(emailList, sujet, contenu);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
