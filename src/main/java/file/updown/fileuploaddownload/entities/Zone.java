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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer numéro;
    private String description;
    private Integer beginPosition;
    private Integer endPosition;

    public Zone(Integer numéro, String description, Integer beginPosition, Integer endPosition) {
        this.numéro = numéro;
        this.description = description;
        this.beginPosition = beginPosition;
        this.endPosition = endPosition;
    }
}
