package dao.impl;

import bean.Medicine;
import dao.MedicineDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.DruidPool;

import java.sql.SQLException;
import java.util.List;

public class MedicineImpl implements MedicineDao {
    @Override
    public List<Medicine> findAllMedicine() {
        String sql = "select * from medicine order by mno";
        JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
        List<Medicine> medicines = template.query(sql, new BeanPropertyRowMapper<Medicine>(Medicine.class));
        System.out.println(medicines);
        return medicines;
    }

    @Override
    public void addMedicine(Medicine medicine) {
        String sql = "insert into medicine values (?, ?, ?, ?)";
        JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
        template.update(sql, medicine.getMno(), medicine.getMname(), medicine.getMmode(), medicine.getMefficacy());
    }

    @Override
    public List<Medicine> searchMedicine(String key1, String value1, String key2, String value2, int start, int rows) {
        String sql = "select * from medicine order by mno limit ? , ?";
        if(value1 != null || value2 != null)
        {
            if(value1 == null)
                sql = "select * from medicine where " + key2 + " like '%" + value2 + "%' order by mno limit ? , ?";
            else if(value2 == null)
                sql = "select * from medicine where " + key1 + " like '%" + value1 + "%' order by mno limit ? , ?";
            else
                sql = "select * from medicine where " + key1 + " like '%" + value1 + "%' and " +
                        key2 + " like '%" + value2 + "%' order by mno limit ? , ?";
        }
        JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
        System.out.println(key1);
        System.out.println(value1);
        System.out.println(key2);
        System.out.println(value2);
        System.out.println(sql);
        List<Medicine> medicines = template.query(sql, new BeanPropertyRowMapper<Medicine>(Medicine.class), start, rows);
        System.out.println(medicines);
        return medicines;
    }

    @Override
    public void deleteMedicine(String mno) {
        try{
            String sql = "delete from medicine where mno = ?";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            template.update(sql, mno);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Medicine findMedicineByMno(String mno) {
        String sql = "select * from medicine where mno = " + mno;
        JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
        List<Medicine> agencies = template.query(sql, new BeanPropertyRowMapper<Medicine>(Medicine.class));
        if(agencies != null)
            return agencies.get(0);
        return null;
    }

    @Override
    public void reviseMedicine(Medicine medicine, String mno) {
        try{
            System.out.println("revise");
            System.out.println(medicine);
            String sql = "update medicine set mno = ?, mname = ?, mmode = ?, mefficacy = ? where mno = ?";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            template.update(sql, medicine.getMno(), medicine.getMname(), medicine.getMmode(), medicine.getMefficacy()
                    , medicine.getMno());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from medicine";
        JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
        int count = template.queryForObject(sql, Integer.class);
        System.out.println(count);
        return count;
    }

    @Override
    public List<Medicine> findByPage(int start, int rows) {
        String sql = "select * from medicine limit ? , ?";//sql中分页查询的方法，初始索引，记录数
        JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
        List<Medicine> medicineList = template.query(sql, new BeanPropertyRowMapper<Medicine>(Medicine.class), start, rows);
        return medicineList;
    }
}
