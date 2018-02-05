package core.entites;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "podforum")
public class Podforum {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "naziv", nullable = false)
    private String naziv;


    @Column(name = "opis", nullable = false)
    private String opis;

    @Lob
    @Column(name = "ikonica")
    private byte[] ikonica;

    @Column(name = "ikonica_content_type")
    private String ikonicaContentType;

    @ManyToOne
    private Account OdgovorniModerator;

    @ManyToOne
    private Account autor ;

    @ManyToMany(fetch = FetchType.EAGER)
    //@JsonIgnore
    private Set<Pravilo> spisakPravilas = new HashSet<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public byte[] getIkonica() {
        return ikonica;
    }

    public void setIkonica(byte[] ikonica) {
        this.ikonica = ikonica;
    }

    public String getIkonicaContentType() {
        return ikonicaContentType;
    }

    public void setIkonicaContentType(String ikonicaContentType) {
        this.ikonicaContentType = ikonicaContentType;
    }

    public Account getOdgovorniModerator() {
        return OdgovorniModerator;
    }

    public void setOdgovorniModerator(Account odgovorniModerator) {
        OdgovorniModerator = odgovorniModerator;
    }

    public Account getAutor() {
        return autor;
    }

    public void setAutor(Account autor) {
        this.autor = autor;
    }

    public Set<Pravilo> getSpisakPravilas() {
        return spisakPravilas;
    }

    public void setSpisakPravilas(Set<Pravilo> spisakPravilas) {
        this.spisakPravilas = spisakPravilas;
    }
}
