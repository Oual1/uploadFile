package file.updown.fileuploaddownload.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Footer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 5000)
    @JsonIgnore
    private String content;
    @JsonIgnore
    @OneToOne(mappedBy = "footerFile")
    private File fileFooter;
    @JsonIgnore
    @OneToMany
    private List<Record> recordFooter;
    @JsonIgnore
    @OneToMany
    private List<Message> messagesFooter;



}
