//package file.updown.fileuploaddownload.services;
//
//import file.updown.fileuploaddownload.entities.ErrorCode;
//import file.updown.fileuploaddownload.repositories.ErrorCodeRepository;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//@Service
//public class ErrorInitializer implements CommandLineRunner {
//    private ErrorCodeRepository errorCodeRepository;
//
//    public ErrorInitializer(ErrorCodeRepository errorCodeRepository) {
//        this.errorCodeRepository = errorCodeRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        List<ErrorCode> entities = readExcelFile();
//
//        // Enregistrer les données dans la base de données
//
////        File file = new File("./errors/codes_erreur_list.xlsx");
////        FileInputStream inputStream = new FileInputStream(file);
////        Workbook workbook = new XSSFWorkbook(inputStream);
////
////        // Récupération de la première feuille
////        Sheet sheet = workbook.getSheetAt(0);
////
////        // Parcours des lignes et création d'objets Person
////        List<ErrorCode> errorCodes = new ArrayList<>();
////        Iterator<Row> rowIterator = sheet.iterator();
////        while (rowIterator.hasNext()) {
////            Row row = rowIterator.next();
////            Iterator<Cell> cellIterator = row.iterator();
////
////            // Récupération des données de la ligne
////            int maj = (int) cellIterator.next().getNumericCellValue();
////            double modiftype = cellIterator.next().getNumericCellValue();
////            String nature = cellIterator.next().getStringCellValue();
////            Double code = cellIterator.next().getNumericCellValue();
////            String deutchDescription = cellIterator.next().getStringCellValue();
////            String frenchDescription = cellIterator.next().getStringCellValue();
////            String remarque = cellIterator.next().getStringCellValue();
////
////            // Création de l'objet Person et ajout à la liste
////            ErrorCode errorCode = new ErrorCode(maj, modiftype, nature, code, deutchDescription, frenchDescription, remarque);
////            errorCodes.add(errorCode);
////        }
////
////        // Fermeture du fichier Excel
////        workbook.close();
////        inputStream.close();
////        errorCodeRepository.saveAll(errorCodes);
////
////
////         //Utilisation des objets Person
////        for (ErrorCode rr: errorCodes) {
////            System.out.println(rr);
////        }
//
//    }
//    private List<ErrorCode> readExcelFile() throws IOException, InvalidFormatException {
//        List<ErrorCode> entities = new ArrayList<>();
//        File file = new File("./errors/codes_erreur_list.xlsx");
//
//        // Créer une instance de Workbook pour lire le fichier Excel
//        Workbook workbook = new XSSFWorkbook(file);
//
//        // Récupérer la feuille de calcul souhaitée
//        Sheet sheet = workbook.getSheetAt(0);
//
//        // Parcourir les lignes
//        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//            Row row = sheet.getRow(i);
//            if (row != null) {
//                ErrorCode entity = new ErrorCode();
//
//
//                entity.setMajBijw(getCellDoubleValue(row.getCell(0)));
//                entity.setModifType(getCellDoubleValue(row.getCell(1)));
//                entity.setErrorNature(getCellStringValue(row.getCell(2)));
//                entity.setCode(getCellStringValue(row.getCell(3)));
//                entity.setDeutchDescription(getCellStringValue(row.getCell(4)));
//                entity.setFrenchDescription(getCellStringValue(row.getCell(5)));
//                entity.setRemarque(getCellStringValue(row.getCell(6)));
//
//                entities.add(entity);
//                errorCodeRepository.save(entity);
//            }
//        }
//
//        // Fermer la lecture du fichier
//        workbook.close();
//
//        return entities;
//    }
//
//
//
//    private String getCellStringValue(Cell cell) {
//        return (cell != null && cell.getCellType() == CellType.STRING) ? cell.getStringCellValue() : null;
//    }
//
//    // Méthode utilitaire pour récupérer la valeur d'une cellule de type Double
//    private Double getCellDoubleValue(Cell cell) {
//        return (cell != null && cell.getCellType() == CellType.NUMERIC) ? cell.getNumericCellValue() : null;
//    }
//
//
//}
