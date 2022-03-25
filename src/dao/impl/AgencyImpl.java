package dao.impl;

import bean.Agency;
import dao.AgencyDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.DruidPool;

import java.sql.SQLException;
import java.util.List;

public class AgencyImpl implements AgencyDao {
    @Override
    public List<Agency> findAllAgency() {
        List<Agency> agencys = null;
        try{
            String sql = "select * from agency order by ano";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            agencys = template.query(sql, new BeanPropertyRowMapper<Agency>(Agency.class));
            System.out.println(agencys);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return agencys;
    }

    @Override
    public void addAgency(Agency agency) {
        try{
            String sql = "insert into agency values (?, ?, ?, ?, ?)";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            template.update(sql, agency.getAno(),agency.getAname(),agency.getAsex(),agency.getAphone(),agency.getAremark());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<Agency> searchAgency(String key1, String value1, String key2, String value2, int start, int rows) {
        List<Agency> agencys = null;
        try{
            String sql = "select * from agency order by ano limit ? , ?";
            if(value1 != null || value2 != null)
            {
                if(value1 == null)
                    sql = "select * from agency where " + key2 + " like '%" + value2 + "%' order by ano limit ? , ?";
                else if(value2 == null)
                    sql = "select * from agency where " + key1 + " like '%" + value1 + "%' order by ano limit ? , ?";
                else
                    sql = "select * from agency where " + key1 + " like '%" + value1 + "%' and " +
                            key2 + " like '%" + value2 + "%' order by ano limit ? , ?";
            }
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            System.out.println(key1);
            System.out.println(value1);
            System.out.println(key2);
            System.out.println(value2);
            System.out.println(sql);
            agencys = template.query(sql, new BeanPropertyRowMapper<Agency>(Agency.class), start, rows);
            System.out.println(agencys);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return agencys;
    }

    @Override
    public void deleteAgency(String ano) {
        try{
            String sql = "delete from agency where ano = ?";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            template.update(sql, ano);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Agency findAgencyByAno(String ano) {
        List<Agency> agencies = null;
        try{
            String sql = "select * from agency where ano = " + ano;
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            agencies = template.query(sql, new BeanPropertyRowMapper<Agency>(Agency.class));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if(agencies != null)
            return agencies.get(0);
        return null;
    }

    @Override
    public void reviseAgency(Agency agency, String ano) {
        try{
            System.out.println("revise");
            System.out.println(agency);
            String sql = "update agency set ano = ?, aname = ?, asex = ?, aphone = ?, aremark = ? where ano = ?";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            template.update(sql, agency.getAno(), agency.getAname(), agency.getAsex(), agency.getAphone(), agency.getAremark()
            , agency.getAno());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int findTotalCount() {
        int count = 0;
        try{
            String sql = "select count(*) from agency";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            count = template.queryForObject(sql, Integer.class);
            System.out.println(count);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int findSearchCount(String key1, String value1, String key2, String value2) {
        int count = 0;
        try{
            String sql = "select count(ano) from agency";
            if(value1 != null || value2 != null)
            {
                if(value1 == null)
                    sql = "select count(ano) from agency where " + key2 + " like '%" + value2 + "%'";
                else if(value2 == null)
                    sql = "select count(ano) from agency where " + key1 + " like '%" + value1 + "%'";
                else
                    sql = "select count(ano) from agency where " + key1 + " like '%" + value1 + "%' and " +
                            key2 + " like '%" + value2 + "%'";
            }
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            count = template.queryForObject(sql, Integer.class);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Agency> findByPage(int start, int rows) {
        List<Agency> agencyList = null;
        try{
            String sql = "select * from agency limit ? , ?";//sql中分页查询的方法，初始索引，记录数
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            agencyList = template.query(sql, new BeanPropertyRowMapper<Agency>(Agency.class), start, rows);
        }catch (Exception e){
            e.printStackTrace();
        }
        return agencyList;
    }
}
