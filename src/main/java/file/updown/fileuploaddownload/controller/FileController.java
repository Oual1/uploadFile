package file.updown.fileuploaddownload.controller;

import file.updown.fileuploaddownload.entities.File;

import file.updown.fileuploaddownload.message.ResponseMessage;
import file.updown.fileuploaddownload.services.EncryptionService;
import file.updown.fileuploaddownload.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/files/")
public class FileController {

    private final FileService fileService;
    @Autowired
    private EncryptionService myService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/encrypt")
    public ResponseEntity<String> encryptFile(@RequestParam("filePath") String filePath) {
        try {
            myService.encryptFile(filePath);
            return ResponseEntity.ok("File encrypted successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to encrypt file.");
        }
    }
    @PutMapping("/decrypt")
    public ResponseEntity<String> decryptFile(@RequestParam("filePath") String filePath) {
        try {
            myService.decryptFile(filePath);
            return ResponseEntity.ok("File decrypted successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to decrypt file.");
        }
    }








    @PostMapping("/uploads")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam(name="file") MultipartFile file) throws IOException {

        if(file.getOriginalFilename().endsWith(".txt")) {

            byte[] bytes = file.getBytes();
            String dateSt= LocalDate.now().toString();
            String newFileName= file.getOriginalFilename().substring(0,file.getOriginalFilename().length()-4)+"_"+dateSt +".txt" ;

           // if((file.getContentType().substring(0,6).equals("920000") )||(file.getContentType().substring(0,6).equals("920999")) ||(file.getContentType().substring(0,6).equals("920900")  )){
                Path path = Paths.get("./uploads/"+ newFileName);
                Files.write(path, bytes);
                //myService.encryptFile(path.toString());
                fileService.saveFile(path.toString());
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Uploaded the file successfully: " + newFileName));
//            }else {
//                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseMessage("Content Not Acceptable:"));
//            }
        }else
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(new ResponseMessage("Unsupported file type:"));
    }

    @GetMapping("/all-files/{id}")
    public ResponseEntity<File> findFile(@PathVariable("id") Long id){
        File foundFile = fileService.retreiveFile(id);
        if (foundFile==null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().body(foundFile);
        }
    }
    @GetMapping()
    public List<File> getFiles(){
        return fileService.getAllFiles();
    }

    @GetMapping("/file-seg/{id}")
    public ResponseEntity<ResponseMessage> firstSegregation(@PathVariable("id") Long id){
        try {
            fileService.segregateContentById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("file segregated successfully."));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("File id is not exist."));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteFileById(@PathVariable long id){
        try {
            fileService.deleteFileById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Deleted the file successfully."));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Deleting file is not exist."));
        }
    }


    }





