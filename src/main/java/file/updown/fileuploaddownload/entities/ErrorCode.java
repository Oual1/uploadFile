package file.updown.fileuploaddownload.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "MAJ/BIJW")
    private Double majBijw;
    @Column(name = "Type modification/Type wijziging")
    private Double modifType;
    @Column(name = "Nature erreur/Aard fout")
    private String errorNature;

    @Column(name = "Code erreur/Foutcode")
    private String code;

    @Column(name = "Omschrijving", length = 50000)
    private String deutchDescription;
    @Column(name = "Libellé", length = 50000)
    private String frenchDescription;
    @Column(name = "REMARQUES", length = 50000)
    private String remarque;

    public ErrorCode(Double majBijw, Double modifType, String errorNature, String code, String deutchDescription, String frenchDescription, String remarque) {
        this.majBijw = majBijw;
        this.modifType = modifType;
        this.errorNature = errorNature;
        this.code = code;
        this.deutchDescription = deutchDescription;
        this.frenchDescription = frenchDescription;
        this.remarque = remarque;
    }
}
