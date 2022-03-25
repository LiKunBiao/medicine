package dao.impl;

import bean.Client;
import bean.Login;
import dao.LoginDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.DruidPool;

import java.util.List;

public class LoginImpl implements LoginDao {
    @Override
    public Login login(String username, String password) {
        try{
            String sql = "select * from login where username like '" + username
                    + "' and password = " + password;
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            List<Login> query = template.query(sql, new BeanPropertyRowMapper<Login>(Login.class));
            System.out.println(query);
            System.out.println("123");
            if(query != null)
                return query.get(0);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Login> findAllLogin() {
        try{

        }catch (Exception e)
        {
            String sql = "select * from login where usertype = '普通用户'";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            List<Login> logins= template.query(sql, new BeanPropertyRowMapper<Login>(Login.class));
            System.out.println(logins);
            return logins;
        }
        return null;
    }
    @Override
    public void addLogin(Login login) {
        try{
            String sql = "insert into login values (?, ?, ?)";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            template.update(sql, login.getUsername(), login.getPassword(), login.getUsertype());
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteLogin(String username) {
        try{
            String sql = "delete from login where username = ?";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            template.update(sql, username);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<Login> searchLogin(String username, int start, int rows) {
        try{
            String sql = "select * from login where usertype = '普通用户' limit ? , ?";
            if(username != null)
            {
                sql = "select * from login where usertype = '普通用户' and  username like '%" + username + "%' limit ? , ?";
            }
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            List<Login> logins = template.query(sql, new BeanPropertyRowMapper<Login>(Login.class), start, rows);
            System.out.println(logins);
            return logins;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Login findLoginByUsername(String username) {
        try{

        }catch (Exception e){
            String sql = "select * from login where usertype = '普通用户' and username like '%" + username + "%'";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            List<Login> logins = template.query(sql, new BeanPropertyRowMapper<Login>(Login.class));
            if(logins != null)
                return logins.get(0);
        }
        return null;
    }

    @Override
    public void reviseLogin(Login login, String username) {
        try{
            String sql = "update login set username = ?, password = ?, usertype = ? where username = ?";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            template.update(sql, login.getUsername(), login.getPassword(), login.getUsertype(), login.getUsername());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int findTotalCount() {
        try{
            String sql = "select count(*) from login where usertype = '普通用户'";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            int count = template.queryForObject(sql, Integer.class);
            return count;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Login> findByPage(int start, int rows) {
        try{
            String sql = "select * from login where usertype = '普通用户' limit ? , ?";//sql中分页查询的方法，初始索引，记录数
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            List<Login> loginList = template.query(sql, new BeanPropertyRowMapper<Login>(Login.class), start, rows);
            return loginList;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
