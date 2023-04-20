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
public class Header {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 5000)
    @JsonIgnore
    private String content;
    @JsonIgnore
    @OneToOne(mappedBy = "headerFile")
    private File fileHeader;
    @JsonIgnore
    @OneToMany
    private List<Record> recordsHeader;
    @JsonIgnore
    @OneToMany
    private List<Message> messagesHeader;
}
