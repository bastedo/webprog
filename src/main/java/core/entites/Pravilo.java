package core.entites;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pravilo")
public class Pravilo {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naziv_pravila")
    private String nazivPravila;

    @Lob
    @Column(name = "sadrzaj_pravila")
    private String sadrzajPravila;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivPravila() {
        return nazivPravila;
    }

    public void setNazivPravila(String nazivPravila) {
        this.nazivPravila = nazivPravila;
    }

    public String getSadrzajPravila() {
        return sadrzajPravila;
    }

    public void setSadrzajPravila(String sadrzajPravila) {
        this.sadrzajPravila = sadrzajPravila;
    }
}
