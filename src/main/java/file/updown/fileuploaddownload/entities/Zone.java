package file.updown.fileuploaddownload.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Zone {
    @Id
    private Integer numéro;
    private String description;
    private Integer beginPosition;
    private Integer endPosition;

}
