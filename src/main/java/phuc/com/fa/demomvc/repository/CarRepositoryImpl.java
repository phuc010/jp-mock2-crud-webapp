package phuc.com.fa.demomvc.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import phuc.com.fa.demomvc.entity.Car;
import phuc.com.fa.demomvc.page.PageAble;

@Repository
public class CarRepositoryImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public Car findById(long stt) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Car.class, stt);
    }

    public void delete(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(car);
    }

    @Modifying
    public List<Car> listNoPage(String keySearch , String keySearch2, String keySearch3, String keySearch4, String keySearch5, String keySearch6) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Car> createQuery = session.createQuery("SELECT p FROM Car p where p.メーカー LIKE :updatekey and p.搬入場所 LIKE :updatekey2 and p.manufacturerPartNumber LIKE :updatekey3 and p.出荷デポ LIKE :updatekey4 and p.SS LIKE :updatekey5 and p.車種 LIKE :updatekey6", Car.class);
        createQuery.setParameter("updatekey", "%" + keySearch + "%")
        .setParameter("updatekey2", "%" + keySearch2 + "%")
        .setParameter("updatekey3", "%" + keySearch3 + "%")
        .setParameter("updatekey4", "%" + keySearch4 + "%")
        .setParameter("updatekey5", "%" + keySearch5 + "%")
        .setParameter("updatekey6", "%" + keySearch6 + "%");
        List<Car> cars = createQuery.getResultList();
        return cars;
    }

    @Modifying
    public List<Car> findWithPageAble(PageAble pageAble, String keySearch , String keySearch2, String keySearch3, String keySearch4, String keySearch5, String keySearch6) {
        List<Car> cars = null;
        Session session = sessionFactory.getCurrentSession();
        cars = session.createQuery("SELECT p FROM Car p where p.メーカー LIKE :updatekey"
                + " and p.搬入場所 LIKE :updatekey2"
                + " and p.manufacturerPartNumber LIKE :updatekey3"
                + " and p.出荷デポ LIKE :updatekey4"
                + " and p.SS LIKE :updatekey5"
                + " and p.車種 LIKE :updatekey6 ", Car.class)
                .setParameter("updatekey", "%" + keySearch + "%")
                .setParameter("updatekey2", "%" + keySearch2 + "%")
                .setParameter("updatekey3", "%" + keySearch3 + "%")
                .setParameter("updatekey4", "%" + keySearch4 + "%")
                .setParameter("updatekey5", "%" + keySearch5 + "%")
                .setParameter("updatekey6", "%" + keySearch6 + "%")
                .setFirstResult(pageAble.getOffset())
                .setMaxResults(pageAble.getSize()).getResultList();
        return cars;
    }

    @Modifying
    public long count(String keySearch , String keySearch2, String keySearch3, String keySearch4, String keySearch5, String keySearch6) {
        Long result = null;
        Session session = sessionFactory.getCurrentSession();
            result = session.createQuery("SELECT COUNT(*) FROM Car p where p.メーカー LIKE :updatekey"
                    + " and p.搬入場所 LIKE :updatekey2"
                    + " and p.manufacturerPartNumber LIKE :updatekey3"
                    + " and p.出荷デポ LIKE :updatekey4"
                    + " and p.SS LIKE :updatekey5"
                    + " and p.車種 LIKE :updatekey6", Long.class)
                    .setParameter("updatekey", "%" + keySearch + "%")
                    .setParameter("updatekey2", "%" + keySearch2 + "%")
                    .setParameter("updatekey3", "%" + keySearch3 + "%")
                    .setParameter("updatekey4", "%" + keySearch4 + "%")
                    .setParameter("updatekey5", "%" + keySearch5 + "%")
                    .setParameter("updatekey6", "%" + keySearch6 + "%")
                    .getSingleResult();
        return result;
    }

	@Modifying 
    public void writeFile(List<Car> carList){
        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";
        String FILE_HEADER = "stt, メーカー, メーカー名 , SS, SS名, 搬入場所, manufacturerPartNumber, 出荷デポ, 出荷デポ名, 車種";
        String fileName = "D://FRESHERJAVA22_20_FPT/JVSPRING/AssigmentWorkPlace/spring-mvc-mock-AUTA821/AUTA821Export/ResultExport.csv";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Car c : carList) {
                fileWriter.append(String.valueOf(c.getStt()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.getメーカー());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.getメーカー名());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.getSS());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.getSS名());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.get搬入場所());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.getManufacturerPartNumber());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.get出荷デポ());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.get出荷デポ名());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.get車種());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Modifying
    public void updateOneItem(String stt, String メーカー, String メーカー名, String SS, String SS名, String 搬入場所, String newQty, String oldQty, String manufacturerPartNumber, String 車種 ) {
        Session session = sessionFactory.getCurrentSession();
        Query<?> createQuery = session
                .createQuery("update Car p set p.メーカー = :updateKey, p.メーカー名 = :updateKeyメーカー名, p.SS = :updateKeySS, p.SS名 = :updateKeySS名, p.搬入場所 = :updateKey搬入場所, p.出荷デポ = :updateKey出荷デポ, p.出荷デポ名 = :updateKey出荷デポ名, p.manufacturerPartNumber = :updateKeymanufacturerPartNumber, p.車種 = :updateKey車種 where stt = :updateKeyStt ");
        createQuery.setParameter("updateKey", メーカー);
        createQuery.setParameter("updateKeyメーカー名", メーカー名);
        createQuery.setParameter("updateKeySS", SS);
        createQuery.setParameter("updateKeySS名", SS名);
        createQuery.setParameter("updateKey搬入場所", 搬入場所);
        createQuery.setParameter("updateKey出荷デポ", newQty);
        createQuery.setParameter("updateKey出荷デポ名", oldQty);
        createQuery.setParameter("updateKeymanufacturerPartNumber", manufacturerPartNumber);
        createQuery.setParameter("updateKey車種", 車種);
        createQuery.setParameter("updateKeyStt", Long.parseLong(stt));
        createQuery.executeUpdate();
    }
}
