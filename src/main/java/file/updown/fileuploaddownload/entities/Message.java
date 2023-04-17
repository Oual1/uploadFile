package file.updown.fileuploaddownload.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    @OneToOne
    private Zone zone;

    public Message(String content, Zone zone) {
        this.content = content;
        this.zone = zone;
    }
}
