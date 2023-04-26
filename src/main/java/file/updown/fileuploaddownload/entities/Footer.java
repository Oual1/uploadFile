package file.updown.fileuploaddownload.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Footer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50000)
    @JsonIgnore
    private String content;
    @JsonIgnore
    @OneToOne(mappedBy = "footerFile")
    private File fileFooter;
    @JsonIgnore
    @ManyToMany()
    @JoinTable(
            name = "footer_record",
            joinColumns = @JoinColumn(name = "footer_id"),
            inverseJoinColumns = @JoinColumn(name = "record_id")
    )
    private List<Record> recordFooter;
    @JsonIgnore
    @OneToMany
    private List<Message> messagesFooter;



}
