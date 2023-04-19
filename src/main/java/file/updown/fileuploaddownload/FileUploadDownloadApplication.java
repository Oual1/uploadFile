package file.updown.fileuploaddownload;

import file.updown.fileuploaddownload.entities.Record;
import file.updown.fileuploaddownload.entities.Zone;
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
        List<Zone> reczones4= new ArrayList<>();
        List<Zone> reczones5= new ArrayList<>();
        List<Zone>reczones10=new ArrayList<>();
        List<Zone>reczones20=new ArrayList<>();
        return args -> {

            Zone zone400 = new Zone(400, "type de record", 1, 2);
            Zone zone4001 = new Zone(4001, "code erreur", 3, 4);
            Zone zone401 = new Zone(401, "Numéro de mutualité", 5, 7);
            Zone zone4011 = new Zone(4011, "code erreur", 8, 9);
            Zone zone402 = new Zone(402, "numéro de facture récapitulative", 10, 21);


            Zone zone4021= new Zone(4021, "code erreur", 22, 23);
            Zone zone403 = new Zone(403, "Signe montant demandé compte A", 24, 24);
            Zone zone404 = new Zone(404, "montant demandé compte A", 25, 35);
            Zone zone4041= new Zone(4041, "code erreur", 36, 37);
            Zone zone407 = new Zone(407, "Signe total montants demandés compte A + compte B + compte C", 52, 52);
            Zone zone408 = new Zone(408, " total montants demandés compte A + compte B + compte C", 53, 63);
            Zone zone4081 = new Zone(4081, "code erreur", 64, 65);
            Zone zone409 = new Zone(409, "nombre d'enregistrements", 66, 73);
            Zone zone4091 = new Zone(4091, "code erreur", 74, 75);
            Zone zone4010 = new Zone(4010, "N° de contrôle par mutualité", 76, 77);
            Zone zone4101 = new Zone(4101, "code erreur", 78, 79);


            zoneRepository.save(zone400);
            zoneRepository.save(zone4001);
            zoneRepository.save(zone401);
            zoneRepository.save(zone4011);
            zoneRepository.save(zone402);
            zoneRepository.save(zone4021);
            zoneRepository.save(zone403);
            zoneRepository.save(zone404);
            zoneRepository.save(zone4041);
            zoneRepository.save(zone407);
            zoneRepository.save(zone408);
            zoneRepository.save(zone4081);
            zoneRepository.save(zone409);
            zoneRepository.save(zone4091);
            zoneRepository.save(zone4010);
            zoneRepository.save(zone4101);

            reczones4.add(zone400);
            reczones4.add(zone4001);
            reczones4.add(zone401);
            reczones4.add(zone4011);
            reczones4.add(zone402);
            reczones4.add(zone4021);
            reczones4.add(zone403);
            reczones4.add(zone404);
            reczones4.add(zone4041);
            reczones4.add(zone407);
            reczones4.add(zone408);
            reczones4.add(zone4081);
            reczones4.add(zone409);
            reczones4.add(zone4091);
            reczones4.add(zone4010);
            reczones4.add(zone4101);

            Record rec4= new Record(95);

          rec4.setZones(reczones4);
          recordRepository.save(rec4);
            Zone zone500 = new Zone(500, "type de record", 1, 2);
            Zone zone5001 = new Zone(5001, "code erreur", 3, 4);
            Zone zone501 = new Zone(501, "Numéro de mutualité", 5, 7);
            Zone zone5011 = new Zone(5011, "code erreur", 8, 9);
            Zone zone503 = new Zone(503, "Signe total montants demandés compte A", 24, 24);


            Zone zone504 = new Zone(504, " Total montants demandés compte A", 25, 35);
            Zone zone5041 = new Zone(5041, "Code erreur", 36, 37);
            Zone zone507 = new Zone(507, "Signe total montants demandés compte A + compte B + compte C", 52, 52);
            Zone zone508 = new Zone(508, " total montants demandés compte A + compte B + compte C", 53, 63);
            Zone zone5081= new Zone(5081, "code erreur", 64, 65);
            Zone zone509 = new Zone(509, "nombre d'enregistrements", 66, 73);
            Zone zone5091 = new Zone(5091, "code erreur", 74, 75);
            Zone zone5010 = new Zone(5010, "N° de contrôle de l'envoi", 76, 77);
            Zone zone5101 = new Zone(5101, "code erreur", 78, 79);
            zoneRepository.save(zone500);
            zoneRepository.save(zone5001);
            zoneRepository.save(zone501);
            zoneRepository.save(zone5011);
            zoneRepository.save(zone503);
            zoneRepository.save(zone504);
            zoneRepository.save(zone5041);
            zoneRepository.save(zone507);
            zoneRepository.save(zone508);
            zoneRepository.save(zone5081);
            zoneRepository.save(zone509);
            zoneRepository.save(zone5091);
            zoneRepository.save(zone5010);
            zoneRepository.save(zone5101);

            reczones5.add(zone500);
            reczones5.add(zone5001);
            reczones5.add(zone501);
            reczones5.add(zone5011);
            reczones5.add(zone503);
            reczones5.add(zone504);
            reczones5.add(zone5041);
            reczones5.add(zone507);
            reczones5.add(zone508);
            reczones5.add(zone5081);
            reczones5.add(zone509);
            reczones5.add(zone5091);
            reczones5.add(zone5010);
            reczones5.add(zone5101);
            Record rec5= new Record(96);
            rec5.setZones(reczones5);
            recordRepository.save(rec5);


            Zone zone2=new Zone(2, "NUMERO D'ORDRE DE L'ENREGISTREMENT", 3, 8);
            Zone zone4=new Zone(4, "VERSION FICHIER", 10, 16);
            Zone zone7=new Zone(7, "numero de l'envoi", 33,35 );
            Zone zone13=new Zone(13, "contenu facturation", 53, 55);
            Zone zone14= new Zone(14, "n° tiers payant (INAMI)", 56, 67);
            Zone zone22= new Zone(22, "annee facturee", 108, 112);
            Zone zone23=new Zone(23, "mois facture", 113, 114);
            Zone zone256=new Zone(256, "date de création", 120, 127);
            Zone zone27= new Zone(27, "Numéro BCE", 128, 137);
            Zone zone28= new Zone(28, "REFERENCE DE L'ETABLISSEMENT", 138, 162);
            Zone zone314=new Zone(314, "bic - compte financier A", 167, 177);
            Zone zone3641=new Zone(3641, "iban - compte financier A", 179, 212);


            zoneRepository.save(zone2);
            zoneRepository.save(zone4);
            zoneRepository.save(zone7);
            zoneRepository.save(zone13);
            zoneRepository.save(zone14);
            zoneRepository.save(zone22);
            zoneRepository.save(zone23);
            zoneRepository.save(zone256);
            zoneRepository.save(zone27);
            zoneRepository.save(zone28);
            zoneRepository.save(zone314);
            zoneRepository.save(zone3641);

            reczones10.add(zone2);
            reczones10.add(zone4);
            reczones10.add(zone7);
            reczones10.add(zone13);
            reczones10.add(zone14);
            reczones10.add(zone22);
            reczones10.add(zone23);
            reczones10.add(zone256);
            reczones10.add(zone27);
            reczones10.add(zone28);
            reczones10.add(zone3641);

            Record rec10= new Record(10);
            rec10.setZones(reczones10);
            recordRepository.save(rec10);



            Zone zone2_2=new Zone(2, "NUMERO D'ORDRE DE L'ENREGISTREMENT", 3, 8);
            Zone zone2_3=new Zone(3, "AUTORISATION TIERS PAYANT", 9, 9);
            Zone zone2_7=new Zone(7, "n° mutualite affiliation", 33, 35);
            Zone zone2_8=new Zone(8, "identification du beneficiairee (numéro NISS)", 36, 48);
            Zone zone2_9=new Zone(9, "sexe beneficiaire", 49, 49);
            Zone zone2_10=new Zone(10, "type facture", 50, 50);
            Zone zone2_11=new Zone(11, "type facturation", 51, 51);
            Zone zone2_13=new Zone(13, "SERVICE 721 bis", 53, 55);
            Zone zone2_14=new Zone(14, "n° de l'etablissement qui facture (= R10 Z14)", 56, 67);
            Zone zone2_15=new Zone(15, "n° de l'etablissement de sejour", 68, 79);
            Zone zone2_16=new Zone(16, "CODE LEVEE DELAI DE PRESCRIPTION", 80, 80);
            Zone zone2_17=new Zone(17, "causes du traitement", 81, 84);
            Zone zone2_18=new Zone(18, "n° mutualite destination", 85, 87);
            Zone zone2_2021=new Zone(2021, "DATE DE L'ACCORD TRAITEMENT DE REEDUCATION OU DATE D'INSCRIPTION AU FORFAIT", 100, 107);
            Zone zone2_2425=new Zone(2425, "n° de facture individuelle", 115, 126);
            Zone zone2_27=new Zone(27, "CODE TITULAIRE 1 + 2", 128, 137);
            Zone zone2_28=new Zone(28, "REFERENCE DE L'ETABLISSEMENT", 138, 162);
            Zone zone2_2931=new Zone(2931, "numero de facture precedente", 163, 174);
            Zone zone2_32=new Zone(32, "FLAG IDENTIFICATION DU BENEFICIAIRE", 175, 175);
            Zone zone2_3436=new Zone(3436, "numero de l'envoi precedent", 177, 179);
            Zone zone2_37=new Zone(37, "n° mut. fact. preced.", 180, 182);
            Zone zone2_3839=new Zone(3839, "REFERENCE MUTUALITE NUMERO DE COMPTE FINANCIER A", 183, 204);

            Zone zone2_41=new Zone(41, "ANNEE ET MOIS PRECEDEMMENT FACTURES", 207, 212);
            Zone zone2_4245=new Zone(4245, "DONNEES DE REFERENCE RESEAU", 213, 260);
            Zone zone2_47=new Zone(47, "date de facturation", 262, 268);

            zoneRepository.save(zone2_2);
            zoneRepository.save(zone2_3);
            zoneRepository.save(zone2_7);
            zoneRepository.save(zone2_8);
            zoneRepository.save(zone2_9);
            zoneRepository.save(zone2_10);
            zoneRepository.save(zone2_11);
            zoneRepository.save(zone2_13);
            zoneRepository.save(zone2_14);
            zoneRepository.save(zone2_15);
            zoneRepository.save(zone2_16);
            zoneRepository.save(zone2_17);
            zoneRepository.save(zone2_18);
            zoneRepository.save(zone2_2021);
            zoneRepository.save(zone2_2425);
            zoneRepository.save(zone2_27);
            zoneRepository.save(zone2_28);
            zoneRepository.save(zone2_2931);
            zoneRepository.save(zone2_32);
            zoneRepository.save(zone2_3436);
            zoneRepository.save(zone2_37);
            zoneRepository.save(zone2_3839);
            zoneRepository.save(zone2_41);
            zoneRepository.save(zone2_4245);
            zoneRepository.save(zone2_47);

            reczones20.add(zone2_2);
            reczones20.add(zone2_3);
            reczones20.add(zone2_7);
            reczones20.add(zone2_8);
            reczones20.add(zone2_9);
            reczones20.add(zone2_10);
            reczones20.add(zone2_11);
            reczones20.add(zone2_13);
            reczones20.add(zone2_14);
            reczones20.add(zone2_15);
            reczones20.add(zone2_16);
            reczones20.add(zone2_17);
            reczones20.add(zone2_18);
            reczones20.add(zone2_2021);
            reczones20.add(zone2_2425);
            reczones20.add(zone2_27);
            reczones20.add(zone2_28);
            reczones20.add(zone2_2931);
            reczones20.add(zone2_32);
            reczones20.add(zone2_3436);
            reczones20.add(zone2_37);
            reczones20.add(zone2_3839);
            reczones20.add(zone2_41);
            reczones20.add(zone2_4245);
            reczones20.add(zone2_47);

            Record rec20= new Record(20);
            rec20.setZones(reczones20);
            recordRepository.save(rec20);


            Zone zone50_2=new Zone(2, "NUMERO D'ORDRE DE L'ENREGISTREMENT", 3, 8);
            Zone zone50_3=new Zone(3, "NORME PRESTATION (POURCENTAGE)",9 , 9);
            Zone zone50_4=new Zone(4, "(pseudo-)code nomencl.", 10, 16);
            Zone zone50_5=new Zone(5, "date 1er prest. effect.", 17, 24);
            Zone zone50_6=new Zone(6, "date derniere prestation effectuee", 25, 32);

            Zone zone50_7=new Zone(7, "n° mutualite affiliation", 33, 35);
            Zone zone50_8=new Zone(8, "Identification du beneficiaire", 36, 48);
            Zone zone50_9=new Zone(9, "SEXE BENEFICIAIRE", 49, 49);
            Zone zone50_12=new Zone(12, "nuit, w.e. ou jour ferie", 52, 52);
            Zone zone50_13=new Zone(13, "CODE SERVICE", 53, 55);
            Zone zone50_14=new Zone(14, "lieu de prestation", 56, 67);
            Zone zone50_15=new Zone(15, "IDENTIFICATION DU DISPENSATEUR", 68, 79);
            Zone zone50_16=new Zone(16, "NORME DISPENSATEUR", 80, 80);
            Zone zone50_1718=new Zone(1718, "prestation relative", 81, 87);
            Zone zone50_19=new Zone(19, "signe+montant intervention de l'assurance", 88, 99);
            Zone zone50_2021=new Zone(2021, "date de la prescription", 100, 107);
            Zone zone50_22=new Zone(22, "signe + nombre d'unites", 108, 112);
            Zone zone50_23=new Zone(23, "DEROGATION NOMBRE MAXIMAL OU PRESTATION IDENTIQUE", 113, 114);
            Zone zone50_2425=new Zone(2425, "identification du prescripteur", 115, 126);
            Zone zone50_26=new Zone(26, "norme prescript", 127, 127);
            Zone zone50_27=new Zone(27, "SIGNE + INTERVENTION PERSONNELLE PATIENT", 128, 137);
            Zone zone50_28=new Zone(28, "ref. etablissement", 138, 162);
            Zone zone50_29=new Zone(29, "dent traitee (cas de DENTIST)", 163, 164);//?????
            Zone zone50_3031=new Zone(3031, "SIGNE + MONTANT SUPPLEMENT OU MONTANT POUR PRODUITSPRESTATIONS OU SERVICES NON-REMBOURSABLES", 165, 174);
            Zone zone50_32=new Zone(32, "EXCEPTION TIERS PAYANT", 175, 175);

            Zone zone50_33=new Zone(33, "CODE FACTURATION INTERVENTION PERSONNELLE OU SUPPLEMENT", 176, 176);
            Zone zone50_34=new Zone(23, "membre traité", 177, 177);
            Zone zone50_35=new Zone(23, "PRESTATAIRE CONVENTIONNE", 178, 178);
            Zone zone50_49=new Zone(23, "DISPENSATEUR AUXILIAIRE", 271, 282);


















        };
    }



    }
