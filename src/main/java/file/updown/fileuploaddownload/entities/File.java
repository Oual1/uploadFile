package file.updown.fileuploaddownload.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import file.updown.fileuploaddownload.enums.FileState;
import file.updown.fileuploaddownload.enums.FileType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.file.Path;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    @Enumerated(EnumType.STRING)
    private FileState state;
    @Enumerated(EnumType.STRING)
    private FileType type;
    @OneToOne
    private Detail detailFile;
    @OneToOne
    private Footer footerFile;


    public File(Long id, String fileName, FileState state, FileType type) {
        this.id = id;
        this.fileName = fileName;
        this.state = state;
        this.type = type;
    }
}
