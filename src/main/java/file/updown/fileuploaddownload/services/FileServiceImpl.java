package file.updown.fileuploaddownload.services;

import file.updown.fileuploaddownload.enums.FileState;
import file.updown.fileuploaddownload.enums.FileType;
import file.updown.fileuploaddownload.repositories.FileRepository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Service
public class FileServiceImpl implements FileService {
    private FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    public void saveFile(String path) throws IOException {
        java.io.File fileModel = new File(path);
        FileInputStream inputStream = new FileInputStream(fileModel);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String type = reader.readLine().substring(0, 6);
        reader.close();

        file.updown.fileuploaddownload.entities.File savedFile = new file.updown.fileuploaddownload.entities.File();
        savedFile.setFileName(path.substring(10));

        if (type.equals("920000")){
            savedFile.setType(FileType.BORDEREAU_FACTURATION);
        } else if (type.equals("931000")) {
            savedFile.setType(FileType.ACCUSE_RECEPTION);
        } else if (type.equals("920999")) {
            savedFile.setType(FileType.REFUS_BORDEREAUX);
        } else if (type.equals("920098")) {
            savedFile.setType(FileType.REJET_MOINS5);
        } else if (type.equals("920099")) {
            savedFile.setType(FileType.REJET_PLUS5);
        } else if (type.equals("920900")) {
            savedFile.setType(FileType.DECOMPTE_REJET);
        }
        savedFile.setState(FileState.FILE_DROPPED);
        fileRepository.save(savedFile);
    }

    public void segregateContentById(Long id) throws IOException {
        file.updown.fileuploaddownload.entities.File fileOptional = fileRepository.findById(id).orElse(null);
        segregateContentByType(fileOptional);

        String path = "./uploads/"+ fileOptional.getFileName();
        String path2 = "./treatement/"+ fileOptional.getFileName();
        fileOptional.setState(FileState.SEGREGATED);
        moveFile(path, path2);



    }

    @Override
    public file.updown.fileuploaddownload.entities.File retreiveFile(Long id) {
        return fileRepository.findById(id).orElse(null);
    }

    @Override
    public void moveFile(String sourceFilePath, String targetFilePath) throws IOException {
        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);
        Files.move(sourceFile.toPath(), targetFile.toPath());
    }

    @Override
    public void segregateContentByType(file.updown.fileuploaddownload.entities.File segFile) throws IOException {
        String path = "./uploads/"+ segFile.getFileName();
        String content = Files.readString(Paths.get(path));
        System.out.println(content.length());
        if (segFile.getType()== FileType.BORDEREAU_FACTURATION || segFile.getType()==FileType.REFUS_BORDEREAUX){
            segFile.setHeader(content.substring(0, 227));
            segFile.setBody(content.substring(227, 1977));
            segFile.setFooter(content.substring(1977));
        }
        else {
            segFile.setHeader(content.substring(0, 676));
            segFile.setBody(content.substring(678, 2828));
            segFile.setFooter(content.substring(2828));
        }
        segFile.setState(FileState.SEGREGATED);
        fileRepository.save(segFile);
    }

    @Override
    public List<file.updown.fileuploaddownload.entities.File> getAllFiles() {
        return fileRepository.findAll();
    }

    @Override
    public void deleteFileById(Long id) {
        file.updown.fileuploaddownload.entities.File fileOptional = fileRepository.findById(id).orElse(null);
        if(fileOptional.getState()==FileState.FILE_DROPPED){
            String path = "./uploads/"+ fileOptional.getFileName();
            File file = new File(path);
            file.delete();
        } else if (fileOptional.getState()==FileState.SEGREGATED) {
            String path = "./treatement/"+ fileOptional.getFileName();
            File file = new File(path);
            file.delete();
        }
        fileRepository.delete(fileOptional);
    }


}
