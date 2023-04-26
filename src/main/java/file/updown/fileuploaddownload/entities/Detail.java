package file.updown.fileuploaddownload.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50000)
    @JsonIgnore
    private String content;
    @JsonIgnore
    @OneToOne(mappedBy = "detailFile")
    private File fileDetail;
    @JsonIgnore
    @OneToMany
    private List<Record> recordsDetail;
    @JsonIgnore
    @OneToMany
    private List<Message> messagesDetail;
}
