package file.updown.fileuploaddownload.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FileContent {
    @Id
    private Long id;
    private String header;
    private String body;
    private String footer;
}
