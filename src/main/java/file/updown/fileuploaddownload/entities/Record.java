package file.updown.fileuploaddownload.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Record {
    @Id
    private Integer recordType;
    private Long longueur;

    @ManyToMany(
            fetch = FetchType.LAZY

    )
    @JoinTable(
            name = "record_zone",
            joinColumns = @JoinColumn(name = "record_id"),
            inverseJoinColumns = @JoinColumn(name = "zone_id")
    )
    private List<Zone> zones;

    public Record(Integer recordType) {
        this.recordType = recordType;
    }

}
