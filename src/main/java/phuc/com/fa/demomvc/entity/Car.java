package phuc.com.fa.demomvc.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/* class Organization declare the required information of an organization */
@Entity
public class Car{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stt;

    @Size(min = 0, max = 13, message = "Maxlength is 13 characters")
    @Column(columnDefinition = "nvarchar(13)")
    private String メーカー;

    @Size(min = 0, max = 8, message = "Maxlength is 8 characters")
    @Column(columnDefinition = "nvarchar(8)")
    private String 搬入場所;

    @Size(min = 0, max = 18, message = "Maxlength is 18 characters")
    @Column(columnDefinition = "nvarchar(18)")
    private String manufacturerPartNumber;

    @Size(min = 0, max = 2, message = "Maxlength is 2 characters")
    @Column(columnDefinition = "nvarchar(2)")
    private String 出荷デポ;

    @Size(min = 0, max = 1, message = "Maxlength is 1 characters")
    @Column(columnDefinition = "nvarchar(1)")
    private String SS;

    @Size(min = 0, max = 1, message = "Maxlength is 1 characters")
    @Column(columnDefinition = "nvarchar(1)")
    private String 車種;

    @Column(columnDefinition = "nvarchar(255)")
    private String メーカー名;

    @Column(columnDefinition = "nvarchar(255)")
    private String SS名;

    @Column(columnDefinition = "nvarchar(255)")
    private String 出荷デポ名;

    //constructor
    public Car() {
        super();
    }

    public Car(@Size(min = 0, max = 13, message = "Maxlength is 13 characters") String メーカー,
            @Size(min = 0, max = 8, message = "Maxlength is 8 characters") String 搬入場所,
            @Size(min = 0, max = 18, message = "Maxlength is 18 characters") String manufacturerPartNumber,
            @Size(min = 0, max = 2, message = "Maxlength is 2 characters") String 出荷デポ,
            @Size(min = 0, max = 1, message = "Maxlength is 1 characters") String sS,
            @Size(min = 0, max = 1, message = "Maxlength is 1 characters") String 車種, String メーカー名, String sS名,
            String 出荷デポ名) {
        super();
        this.メーカー = メーカー;
        this.搬入場所 = 搬入場所;
        this.manufacturerPartNumber = manufacturerPartNumber;
        this.出荷デポ = 出荷デポ;
        SS = sS;
        this.車種 = 車種;
        this.メーカー名 = メーカー名;
        SS名 = sS名;
        this.出荷デポ名 = 出荷デポ名;
    }

    public long getStt() {
        return stt;
    }

    public void setStt(long stt) {
        this.stt = stt;
    }

    public String getManufacturerPartNumber() {
        return manufacturerPartNumber;
    }

    public void setManufacturerPartNumber(String manufacturerPartNumber) {
        this.manufacturerPartNumber = manufacturerPartNumber;
    }

    public String getメーカー() {
        return メーカー;
    }

    public void setメーカー(String メーカー) {
        this.メーカー = メーカー;
    }

    public String get搬入場所() {
        return 搬入場所;
    }

    public void set搬入場所(String 搬入場所) {
        this.搬入場所 = 搬入場所;
    }

    public String get出荷デポ() {
        return 出荷デポ;
    }

    public void set出荷デポ(String 出荷デポ) {
        this.出荷デポ = 出荷デポ;
    }

    public String getSS() {
        return SS;
    }

    public void setSS(String sS) {
        SS = sS;
    }

    public String get車種() {
        return 車種;
    }

    public void set車種(String 車種) {
        this.車種 = 車種;
    }

    public String getメーカー名() {
        return メーカー名;
    }

    public void setメーカー名(String メーカー名) {
        this.メーカー名 = メーカー名;
    }

    public String getSS名() {
        return SS名;
    }

    public void setSS名(String sS名) {
        SS名 = sS名;
    }

    public String get出荷デポ名() {
        return 出荷デポ名;
    }

    public void set出荷デポ名(String 出荷デポ名) {
        this.出荷デポ名 = 出荷デポ名;
    }

    @Override
    public String toString() {
        return "Car [stt=" + stt + ", メーカー=" + メーカー + ", 搬入場所=" + 搬入場所 + ", manufacturerPartNumber=" + manufacturerPartNumber + ", 出荷デポ=" + 出荷デポ
                + ", SS=" + SS + ", 車種=" + 車種 + ", メーカー名=" + メーカー名 + ", SS名=" + SS名 + ", 出荷デポ名=" + 出荷デポ名 + "]";
    }
}
