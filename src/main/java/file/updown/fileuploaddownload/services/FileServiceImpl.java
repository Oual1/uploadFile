package file.updown.fileuploaddownload.services;

import file.updown.fileuploaddownload.entities.Detail;
import file.updown.fileuploaddownload.entities.Footer;
import file.updown.fileuploaddownload.enums.FileState;
import file.updown.fileuploaddownload.enums.FileType;
import file.updown.fileuploaddownload.repositories.DetailRepository;
import file.updown.fileuploaddownload.repositories.FileRepository;
import file.updown.fileuploaddownload.repositories.FooterRepository;
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
    private FooterRepository footerRepository;
    private DetailRepository detailRepository;

    public FileServiceImpl(FileRepository fileRepository, FooterRepository footerRepository, DetailRepository detailRepository) {
        this.fileRepository = fileRepository;
        this.footerRepository= footerRepository;
        this.detailRepository= detailRepository;
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

        Footer foo= new Footer();
        Detail detail= new Detail();
        if (segFile.getType()== FileType.BORDEREAU_FACTURATION || segFile.getType()==FileType.REFUS_BORDEREAUX){
//            segFile.setHeader(content.substring(0, 227));
//            segFile.setBody(content.substring(227, 1977));
//            segFile.setFooter(content.substring(1977));
            foo.setContent(content.substring(1977));
            detail.setContent(content.substring(227, 1977));


        }
        else {
//            segFile.setHeader(content.substring(0, 676));

            foo.setContent(content.substring(2828));
            detail.setContent(content.substring(676, 2828));

        }
        segFile.setState(FileState.SEGREGATED);
        footerRepository.save(foo);
        detailRepository.save(detail);
        segFile.setFooterFile(foo);
        segFile.setDetailFile(detail);

        fileRepository.save(segFile);
        foo.setFileFooter(segFile);
        detail.setFileDetail(segFile);
        footerRepository.save(foo);
        detailRepository.save(detail);
        System.out.println(detail.getContent());

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
