package file.updown.fileuploaddownload;

import file.updown.fileuploaddownload.entities.Record;
import file.updown.fileuploaddownload.entities.Zone;
import file.updown.fileuploaddownload.repositories.ErrorCodeRepository;
import file.updown.fileuploaddownload.repositories.RecordRepository;
import file.updown.fileuploaddownload.repositories.ZoneRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FileUploadDownloadApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileUploadDownloadApplication.class, args);
    }
    @Bean
    CommandLineRunner init(ZoneRepository zoneRepository, RecordRepository recordRepository) {
        List<Zone> reczones4=new ArrayList<>();
        List<Zone> reczones5=new ArrayList<>();
        List<Zone>reczones10=new ArrayList<>();
        List<Zone>reczones20=new ArrayList<>();
        List<Zone>reczones50=new ArrayList<>();
        List<Zone>reczones80= new ArrayList<>();
        List<Zone>reczones90= new ArrayList<>();
        List<Zone>reczones91= new ArrayList<>();
        List<Zone>reczones92=new ArrayList<>();
        List<Zone>segment200=new ArrayList<>();
        List<Zone>segment300= new ArrayList<>();
        return args -> {

          // Enregistrement des zones de record 95
            reczones4.add(new Zone(400, "type de record", 1, 2));
           reczones4.add(new Zone(4001, "Code erreur", 3, 4));
            reczones4.add(new Zone(401, "Numéro de mutualité", 5, 7));
            reczones4.add(new Zone(4011, "code erreur", 8, 9));
            reczones4.add(new Zone(402, "numéro de facture récapitulative", 10, 21));


            reczones4.add(new Zone(4021, "code erreur", 22, 23));
            reczones4.add(new Zone(403, "Signe montant demandé compte A", 24, 24));
            reczones4.add(new Zone(404, "montant demandé compte A", 25, 35));
            reczones4.add(new Zone(4041, "code erreur", 36, 37));
            reczones4.add(new Zone(407, "Signe total montants demandés compte A + compte B + compte C", 52, 52));
            reczones4.add(new Zone(408, " total montants demandés compte A + compte B + compte C", 53, 63));
            reczones4.add(new Zone(4081, "code erreur", 64, 65));
            reczones4.add(new Zone(409, "nombre d'enregistrements", 66, 73));
            reczones4.add(new Zone(4091, "code erreur", 74, 75));
            reczones4.add(new Zone(4010, "N° de contrôle par mutualité", 76, 77));
            reczones4.add(new Zone(4101, "code erreur", 78, 79));


            zoneRepository.saveAll(reczones4);

            Record rec4= new Record(95);

          rec4.setZones(reczones4);
          recordRepository.save(rec4);

            // Enregistrement des zones de record 96
            reczones5.add(new Zone(500, "type de record", 1, 2));
            reczones5.add(new Zone(5001, "code erreur", 3, 4));
            reczones5.add(new Zone(501, "Numéro de mutualité", 5, 7));
            reczones5.add(new Zone(5011, "code erreur", 8, 9));
            reczones5.add(new Zone(503, "Signe total montants demandés compte A", 24, 24));


            reczones5.add(new Zone(504, " Total montants demandés compte A", 25, 35));
            reczones5.add(new Zone(5041, "Code erreur", 36, 37));
            reczones5.add(new Zone(507, "Signe total montants demandés compte A + compte B + compte C", 52, 52));
            reczones5.add(new Zone(508, " total montants demandés compte A + compte B + compte C", 53, 63));
            reczones5.add(new Zone(5081, "code erreur", 64, 65));
            reczones5.add(new Zone(509, "nombre d'enregistrements", 66, 73));
            reczones5.add(new Zone(5091, "code erreur", 74, 75));
            reczones5.add(new Zone(5010, "N° de contrôle de l'envoi", 76, 77));
            reczones5.add(new Zone(5101, "code erreur", 78, 79));
            zoneRepository.saveAll(reczones5);
            Record rec5= new Record(96);
            rec5.setZones(reczones5);
            recordRepository.save(rec5);




            // Enregistrement des zones de record 10
            reczones10.add(new Zone(2, "NUMERO D'ORDRE DE L'ENREGISTREMENT", 3, 8));
            reczones20.add(new Zone(4, "VERSION FICHIER", 10, 16));
            reczones10.add(new Zone(7, "numero de l'envoi", 33,35 ));
            reczones10.add(new Zone(13, "contenu facturation", 53, 55));
            reczones10.add(new Zone(14, "n° tiers payant (INAMI)", 56, 67));
            reczones10.add(new Zone(22, "annee facturee", 108, 112));
            reczones10.add(new Zone(23, "mois facture", 113, 114));
            reczones10.add(new Zone(256, "date de création", 120, 127));
            reczones10.add(new Zone(27, "Numéro BCE", 128, 137));
            reczones10.add(new Zone(28, "REFERENCE DE L'ETABLISSEMENT", 138, 162));
            reczones10.add(new Zone(314, "bic - compte financier A", 167, 177));
            reczones10.add(new Zone(3641, "iban - compte financier A", 179, 212));

            zoneRepository.saveAll(reczones10);
            Record rec10= new Record(10);
            rec10.setZones(reczones10);
            recordRepository.save(rec10);

            // Enregistrement des zones de record 20

            reczones20.add(new Zone(2, "NUMERO D'ORDRE DE L'ENREGISTREMENT", 3, 8));
            reczones20.add(new Zone(3, "AUTORISATION TIERS PAYANT", 9, 9));
            reczones20.add(new Zone(7, "n° mutualite affiliation", 33, 35));
            reczones20.add(new Zone(8, "identification du beneficiairee (numéro NISS)", 36, 48));
            reczones20.add(new Zone(9, "sexe beneficiaire", 49, 49));
            reczones20.add(new Zone(10, "type facture", 50, 50));
            reczones20.add(new Zone(11, "type facturation", 51, 51));
            reczones20.add(new Zone(13, "SERVICE 721 bis", 53, 55));
            reczones20.add(new Zone(14, "n° de l'etablissement qui facture (= R10 Z14)", 56, 67));
            reczones20.add(new Zone(15, "n° de l'etablissement de sejour", 68, 79));
            reczones20.add(new Zone(16, "CODE LEVEE DELAI DE PRESCRIPTION", 80, 80));
            reczones20.add(new Zone(17, "causes du traitement", 81, 84));
            reczones20.add(new Zone(18, "n° mutualite destination", 85, 87));
            reczones20.add(new Zone(2021, "DATE DE L'ACCORD TRAITEMENT DE REEDUCATION OU DATE D'INSCRIPTION AU FORFAIT", 100, 107));
            reczones20.add(new Zone(2425, "n° de facture individuelle", 115, 126));
            reczones20.add(new Zone(27, "CODE TITULAIRE 1 + 2", 128, 137));
            reczones20.add(new Zone(28, "REFERENCE DE L'ETABLISSEMENT", 138, 162));
            reczones20.add(new Zone(2931, "numero de facture precedente", 163, 174));
            reczones20.add(new Zone(32, "FLAG IDENTIFICATION DU BENEFICIAIRE", 175, 175));
            reczones20.add(new Zone(3436, "numero de l'envoi precedent", 177, 179));
            reczones20.add(new Zone(37, "n° mut. fact. preced.", 180, 182));
            reczones20.add(new Zone(3839, "REFERENCE MUTUALITE NUMERO DE COMPTE FINANCIER A", 183, 204));

            reczones20.add(new Zone(41, "ANNEE ET MOIS PRECEDEMMENT FACTURES", 207, 212));
            reczones20.add(new Zone(4245, "DONNEES DE REFERENCE RESEAU", 213, 260));
            reczones20.add(new Zone(47, "date de facturation", 262, 268));


            zoneRepository.saveAll(reczones20);

            Record rec20= new Record(20);
            rec20.setZones(reczones20);
            recordRepository.save(rec20);

// Enregistrement des zones de record 50
            reczones50.add(new Zone(2, "NUMERO D'ORDRE DE L'ENREGISTREMENT", 3, 8));
            reczones50.add(new Zone(3, "NORME PRESTATION (POURCENTAGE)",9 , 9));
            reczones50.add(new Zone(4, "(pseudo-)code nomencl.", 10, 16));
            reczones50.add(new Zone(5, "date 1er prest. effect.", 17, 24));
            reczones50.add(new Zone(6, "date derniere prestation effectuee", 25, 32));

            reczones50.add(new Zone(7, "n° mutualite affiliation", 33, 35));
            reczones50.add(new Zone(8, "Identification du beneficiaire", 36, 48));
            reczones50.add(new Zone(9, "SEXE BENEFICIAIRE", 49, 49));
            reczones50.add(new Zone(12, "nuit, w.e. ou jour ferie", 52, 52));
            reczones50.add(new Zone(13, "CODE SERVICE", 53, 55));
            reczones50.add(new Zone(14, "lieu de prestation", 56, 67));
            reczones50.add(new Zone(15, "IDENTIFICATION DU DISPENSATEUR", 68, 79));
            reczones50.add(new Zone(16, "NORME DISPENSATEUR", 80, 80));
            reczones50.add(new Zone(1718, "prestation relative", 81, 87));
            reczones50.add(new Zone(19, "signe+montant intervention de l'assurance", 88, 99));
            reczones50.add(new Zone(2021, "date de la prescription", 100, 107));
            reczones50.add(new Zone(22, "signe + nombre d'unites", 108, 112));
            reczones50.add(new Zone(23, "DEROGATION NOMBRE MAXIMAL OU PRESTATION IDENTIQUE", 113, 114));
            reczones50.add(new Zone(2425, "identification du prescripteur", 115, 126));
            reczones50.add(new Zone(26, "norme prescript", 127, 127));
            reczones50.add(new Zone(27, "SIGNE + INTERVENTION PERSONNELLE PATIENT", 128, 137));
            reczones50.add(new Zone(28, "ref. etablissement", 138, 162));
            reczones50.add(new Zone(29, "dent traitee (cas de DENTIST)", 163, 164));//?????
            reczones50.add(new Zone(3031, "SIGNE + MONTANT SUPPLEMENT OU MONTANT POUR PRODUITSPRESTATIONS OU SERVICES NON-REMBOURSABLES", 165, 174));
            reczones50.add(new Zone(32, "EXCEPTION TIERS PAYANT", 175, 175));

            reczones50.add(new Zone(33, "CODE FACTURATION INTERVENTION PERSONNELLE OU SUPPLEMENT", 176, 176));
            reczones50.add(new Zone(23, "membre traité", 177, 177));
            reczones50.add(new Zone(23, "PRESTATAIRE CONVENTIONNE", 178, 178));
            reczones50.add(new Zone(23, "DISPENSATEUR AUXILIAIRE", 271, 282));


            zoneRepository.saveAll(reczones50);

            Record rec50= new Record(50);
            rec50.setZones(reczones50);
            recordRepository.save(rec50);


            // Enregistrement des zones de record 80
            reczones80.add(new Zone(2, "NUMERO D'ORDRE DE L'ENREGISTREMENT", 3, 8));
            reczones80.add(new Zone(7, "n° mutualite affiliation", 33, 35));
            reczones80.add(new Zone(8, "identification du beneficiaire", 36, 48));
            reczones80.add(new Zone(9, "SEXE BENEFICIAIRE", 49, 49));
            reczones80.add(new Zone(10, "type facture", 50, 50));
            reczones80.add(new Zone(13, "SERVICE 721 bis", 53, 55));
            reczones80.add(new Zone(14, "n° de l'etablissement qui facture", 56, 67));
            reczones80.add(new Zone(17, "CAUSES DU TRAITEMENT", 81, 84));
            reczones80.add(new Zone(18, "NUMERO DE LA MUTUALITE DE DESTINATION", 85, 87));
            reczones80.add(new Zone(19, "SIGNE + MONTANT NUMERO DE COMPTE FINANCIER A", 88, 99));
            reczones80.add(new Zone(2021, "DATE DE LA FACTURE", 100, 107));
            reczones80.add(new Zone(2425, "n° de facture individuelle", 108, 112));
            reczones80.add(new Zone(27, "SIGNE + INTERVENTION PERSONNELLE PATIENT", 128, 137));
            reczones80.add(new Zone(28, "REFERENCE DE L'ETABLISSEMENT", 138, 162));
            reczones80.add(new Zone(3031, "SIGNE + MONTANT SUPPLEMENT", 165, 174));
            reczones80.add(new Zone(32, "FLAG IDENTIFICATION DU BENEFICIAIRE", 175, 175));
            reczones80.add(new Zone(38, "SIGNE + ACOMPTE NUMERO DE COMPTE FINANCIER A", 183, 194));


           zoneRepository.saveAll(reczones80);

          Record rec80= new Record(80);
          rec80.setZones(reczones80);
          recordRepository.save(rec80);


          // Enregistrement des zones de record 90
          reczones90.add(new Zone(2, "NUMERO D'ORDRE DE L'ENREGISTREMENT", 3, 8));
          reczones90.add(new Zone(56, "n° compte financier a", 17, 28));
          reczones90.add(new Zone(7, "numero de l'envoi", 33, 35));
          reczones90.add(new Zone(14, "n° tiers payant", 56, 67));
          reczones90.add(new Zone(19, "SIGNE + MONTANT TOTAL NUMERO COMPTE FINANCIER A", 88, 98));
          reczones90.add(new Zone(22, "annee facturee", 108, 112));
          reczones90.add(new Zone(23, "mois facture", 113, 114));
          reczones90.add(new Zone(27, "Numéro BCE", 128, 137));
          reczones90.add(new Zone(28, "REFERENCE DE L'ETABLISSEMENT", 138, 162));
          reczones90.add(new Zone(3134, "bic - compte financier A", 167, 177));
          reczones90.add(new Zone(3641, "iban - compte financier A", 179, 213));



          zoneRepository.saveAll(reczones90);

          Record rec90= new Record(90);
          rec90.setZones(reczones90);
          recordRepository.save(rec90);

          // Enregistrement des zones de seg 200

          segment200.add(new Zone(200, "Nom du message", 1, 6));
          segment200.add(new Zone(2001, "Code erreur", 7, 8));
          segment200.add(new Zone(201, "N° version du format du message", 9, 10));
          segment200.add(new Zone(2011, "Code erreur", 11, 12));
          segment200.add(new Zone(202, "Type de message", 13, 14));
          segment200.add(new Zone(2021, "Code erreur", 15, 16));
          segment200.add(new Zone(203, "Statut du message", 17, 18));
          segment200.add(new Zone(2031, "Code erreur", 19, 20));
          segment200.add(new Zone(204, "Référence du message ( prestataire ou institution)", 21, 34));
          segment200.add(new Zone(2041, "Code erreur", 35, 36));
          segment200.add(new Zone(200, "Référence message OA", 1, 6));
          segment200.add(new Zone(200, "Code erreur", 1, 6));

          zoneRepository.saveAll(segment200);



          Record seg200= new Record(200);
          seg200.setZones(segment200);
          recordRepository.save(seg200);


          //Enregistrement des zones de segment 300
          segment300.add(new Zone(300, "Année et mois de facturation", 68, 73));
          segment300.add(new Zone(3001, "Code erreur", 74, 75));
          segment300.add(new Zone(301, "Numéro d’envois", 76, 78));
          segment300.add(new Zone(3011, "Code erreur", 79, 80));
          segment300.add(new Zone(302, "Date de création de la facture", 81, 88));
          segment300.add(new Zone(3021, "Code erreur", 89, 90));
          segment300.add(new Zone(303, "Référence facture (not used pour les hôpitaux)", 91, 103));
          segment300.add(new Zone(3031, "", 104, 105));
          segment300.add(new Zone(304, "numéro de version des instructions", 106, 112));
          segment300.add(new Zone(3041, "Code erreur", 113, 114));
          segment300.add(new Zone(305, "Nom de la personne de contact", 115, 159));
          segment300.add(new Zone(3051, "Code erreur", 160, 161));
          segment300.add(new Zone(306, "Prénom de la personne de contact", 162, 185));
          segment300.add(new Zone(3061, "Code erreur", 186, 187));
          segment300.add(new Zone(307, "Numéro de téléphone de la personne de contact", 188, 197));
          segment300.add(new Zone(3071, "Code erreur", 198, 199));
          segment300.add(new Zone(309, "Type facturation", 207, 208));
          segment300.add(new Zone(3091, "Code erreur", 209, 210));

          zoneRepository.saveAll(segment300);
          Record seg300= new Record(300);
          seg300.setZones(segment300);
          recordRepository.save(seg300);



          //Enregistrement des zones de record 91
          reczones91.add(new Zone(411, "Signe montant accepté compte A", 80, 80));
          reczones91.add(new Zone(412, "montant accepté compte A", 81, 91));
          reczones91.add(new Zone(4121, "Code erreur", 92, 93));
          reczones91.add(new Zone(413, "Signe montant refusé compte A", 94, 94));
          reczones91.add(new Zone(414, "montant refusé compte A", 95, 105));
          reczones91.add(new Zone(4141, "Signe montant accepté compte A", 106, 107));
          reczones91.add(new Zone(419, "Signe total montants acceptés compte A + compte B + compte C", 136, 136));
          reczones91.add(new Zone(420, "Total montants acceptés compte A + compte B + compte C", 137, 147));
          reczones91.add(new Zone(4201, "Code erreur", 148, 149));
          reczones91.add(new Zone(421, "Signe total montants refusés compte A + compte B + compte C ", 150, 150));
          reczones91.add(new Zone(422, "Total montants refusés compte A + compte B + compte C", 151, 161));
          reczones91.add(new Zone(4221, "Code erreur", 162, 163));
          reczones91.add(new Zone(423, "Référence paiement  compte A OA ou mutualité", 164, 185));
          reczones91.add(new Zone(4231, "Code erreur", 186, 187));
          zoneRepository.saveAll(reczones91);
          reczones91.addAll(0,reczones4);

          Record rec91= new Record(91);
          rec91.setZones(reczones91);
          recordRepository.save(rec91);




          //Enregistrement des zones de record 92
          reczones92.add(new Zone(511, "Signe total montants acceptés compte A", 80,80 ));
          reczones92.add(new Zone(512, "Total montants acceptés compte A", 81,91 ));
          reczones92.add(new Zone(5121, "Code erreur", 92,93 ));
          reczones92.add(new Zone(513, "Signe total montants refusés compte A ", 94,94 ));
          reczones92.add(new Zone(514, "Total montants refusés compte A ", 95,105 ));
          reczones92.add(new Zone(5141, "Code erreur", 106,107 ));
          reczones92.add(new Zone(519, "Signe total montants acceptés compte A + compte B + compte C", 136,136 ));
          reczones92.add(new Zone(520, "Total montants acceptés compte A + compte B + compte C", 137,147 ));
          reczones92.add(new Zone(5201, "Code erreur", 148,149 ));
          reczones92.add(new Zone(521, "Signe total montants refusés compte A + compte B + compte C", 150,150 ));
          reczones92.add(new Zone(522, "Total montants refusés compte A + compte B + compte C", 151,161 ));
          reczones92.add(new Zone(5221, "Code erreur", 162,163 ));

          zoneRepository.saveAll(reczones92);
          reczones92.addAll(0, reczones5);

          Record rec92= new Record(92);
          rec92.setZones(reczones92);
          recordRepository.save(rec92);











































        };
    }



    }
