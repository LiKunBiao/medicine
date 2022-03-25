package service;

import bean.Medicine;
import bean.Page;
import dao.impl.MedicineImpl;

import java.util.List;

public class MedicineService {
    public List<Medicine> findAllMedicine() {
        MedicineImpl dao = new MedicineImpl();
        return dao.findAllMedicine();
    }
    public void addMedicine(Medicine medicine)
    {
        MedicineImpl dao = new MedicineImpl();
        dao.addMedicine(medicine);
        return;
    }
    public void deleteMedicine(String mno)
    {
        MedicineImpl dao = new MedicineImpl();
        dao.deleteMedicine(mno);
    }
    public Medicine findMedicineByMno(String mno)
    {
        MedicineImpl dao = new MedicineImpl();
        return dao.findMedicineByMno(mno);
    }
    public void reviseMedicine(Medicine medicine, String mno)
    {
        MedicineImpl dao = new MedicineImpl();
        dao.reviseMedicine(medicine, mno);
    }
    public void deleteSelectMedicine(String[] mnos)
    {
        for(String mno : mnos)
        {
            MedicineImpl dao = new MedicineImpl();
            dao.deleteMedicine(mno);
        }
    }
    public Page<Medicine> findMedicineByPage(String _currentPage, String _rows)
    {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        Page<Medicine> medicinePage = new Page<Medicine>();
        medicinePage.setCurrentPage(currentPage);//当前页码
        medicinePage.setRows(rows);//每页记录数
        MedicineImpl dao = new MedicineImpl();
        //1.调用dao查询总记录数
        int totalCount = dao.findTotalCount();//总记录数
        medicinePage.setTotalCount(totalCount);
        //2.调用dao查询List集合
        int start = (currentPage - 1) * rows;//计算开始的记录索引
        List<Medicine> list = dao.findByPage(start, rows);//查询集合，开始索引，记录数
        medicinePage.setList(list);
        //3.计算总页码
        int totalPage = (totalCount % rows == 0) ? totalCount/rows : totalCount/rows + 1;//总页码
        medicinePage.setTotalPage(totalPage);
        return medicinePage;
    }
    public Page<Medicine> searchMedicineByPage(String _currentPage, String _rows, String key1, String value1, String key2, String value2)
    {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        Page<Medicine> medicinePage = new Page<Medicine>();
        medicinePage.setCurrentPage(currentPage);//当前页码
        medicinePage.setRows(rows);//每页记录数
        MedicineImpl dao = new MedicineImpl();
        //1.调用dao查询List集合
        int start = (currentPage - 1) * rows;//计算开始的记录索引
        List<Medicine> list = dao.searchMedicine(key1, value1, key2, value2, start, rows);
        medicinePage.setList(list);
        //2.调用dao查询总记录数
        int totalCount = list.size();
        medicinePage.setTotalCount(totalCount);
        //3.计算总页码
        int totalPage = (totalCount % rows == 0) ? totalCount/rows : totalCount/rows + 1;//总页码
        medicinePage.setTotalPage(totalPage);
        return medicinePage;
    }
}
