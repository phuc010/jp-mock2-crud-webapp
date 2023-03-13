package phuc.com.fa.demomvc.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phuc.com.fa.demomvc.entity.Car;
import phuc.com.fa.demomvc.page.PageAble;
import phuc.com.fa.demomvc.repository.CarRepositoryImpl;

/* class OrganisationServiceImpl Performing operations and processing logic */
@Service
public class CarServiceImpl {
    @Autowired
    private CarRepositoryImpl carRepositoryImpl;

    @Transactional
    public List<Car> findWithPageAble(PageAble pageAble, String keySearch, String keySearch2,  String keySearch3,  String keySearch4,  String keySearch5,  String keySearch6) {
        return carRepositoryImpl.findWithPageAble(pageAble, keySearch, keySearch2, keySearch3, keySearch4, keySearch5, keySearch6);
    }

    @Transactional
    public List<Car> listNoPage(String keySearch, String keySearch2,  String keySearch3,  String keySearch4,  String keySearch5,  String keySearch6) {
        return carRepositoryImpl.listNoPage(keySearch, keySearch2, keySearch3, keySearch4, keySearch5, keySearch6);
    }

    @Transactional
    public int totalPages(PageAble pageAble, String keySearch , String keySearch2, String keySearch3, String keySearch4, String keySearch5, String keySearch6) {
        long totalRecord = carRepositoryImpl.count(keySearch, keySearch2, keySearch3, keySearch4, keySearch5, keySearch6);
        return (int) Math.ceil((double) totalRecord / pageAble.getSize());
    }

    @Transactional
    public void writeFile(List<Car> carList) {
    	carRepositoryImpl.writeFile(carList);
    }

    @Transactional
    public void delete(long stt) {
        Car car = carRepositoryImpl.findById(stt);
        if (car != null) {
            carRepositoryImpl.delete(car);
        }
    }

    @Transactional
    public Car findById(long stt) {
        return carRepositoryImpl.findById(stt);
    }

    @Transactional
    public void updateOneItem(String stt, String メーカー, String メーカー名, String SS, String SS名, String 搬入場所, String newQty, String oldQty, String manufacturerPartNumber, String 車種 ) {
        carRepositoryImpl.updateOneItem(stt, メーカー, メーカー名,SS,SS名,搬入場所, newQty, oldQty, manufacturerPartNumber, 車種);
    }
}
