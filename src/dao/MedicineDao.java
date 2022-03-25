package dao;

import bean.Medicine;
import bean.Page;

import java.util.List;

public interface MedicineDao {
    public List<Medicine> findAllMedicine();
    public void addMedicine(Medicine medicine);
    public List<Medicine> searchMedicine(String key1, String value1, String key2, String value2, int start, int rows);
    public void deleteMedicine(String mno);
    public Medicine findMedicineByMno(String mno);
    public void reviseMedicine(Medicine medicine, String mno);
    public int findTotalCount();
    public List<Medicine> findByPage(int start, int rows);
}
