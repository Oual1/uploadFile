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














        };
    }



    }
