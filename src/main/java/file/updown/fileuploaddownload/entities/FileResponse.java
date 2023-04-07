package file.updown.fileuploaddownload.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileResponse {

    private Long id;
    private String fileName;
    private String filePath;

    private Long fileSize;
    private byte[] fileData;


    public FileResponse(String fileName, Long fileSize, String filePath, byte[] fileData) {
        this.fileName = fileName;
        this.fileSize= fileSize;
        this.filePath= filePath;
        this.fileData= fileData;
    }
}
