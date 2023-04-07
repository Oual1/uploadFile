package file.updown.fileuploaddownload.services;

import file.updown.fileuploaddownload.entities.File;
import file.updown.fileuploaddownload.enums.FileType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Service
public interface FileService {


    void saveFile(String fileName) throws IOException;

    void segregateContentById(Long id)throws IOException;

    File retreiveFile(Long id);

    void moveFile(String sourceFilePath, String targetFilePath) throws IOException;
    void segregateContentByType(File segFile) throws IOException;
    List<File> getAllFiles();
    void deleteFileById(Long id);
}
