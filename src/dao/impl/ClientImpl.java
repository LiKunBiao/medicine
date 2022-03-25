package dao.impl;

import bean.Client;
import dao.ClientDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.DruidPool;

import java.sql.SQLException;
import java.util.List;

public class ClientImpl implements ClientDao {
    @Override
    public List<Client> findAllClient() {
        String sql = "select * from client order by cno";
        JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
        List<Client> clients = template.query(sql, new BeanPropertyRowMapper<Client>(Client.class));
        System.out.println(clients);
        return clients;
    }

    @Override
    public void addClient(Client client) {
        String sql = "insert into client values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
        template.update(sql, client.getCno(), client.getCname(), client.getCsex(), client.getCage(), client.getCaddress()
        , client.getCphone(), client.getCsymptom(), client.getMno(), client.getAno(), client.getCdate(), client.getCremark());
    }

    @Override
    public List<Client> searchClient(String key1, String value1, String key2, String value2, int start, int rows) {
        String sql = "select * from client order by cno";
        if(value1 != null || value2 != null)
        {
            if(value1 == null)
                sql = "select * from client where " + key2 + " like '%" + value2 + "%' order by cno";
            else if(value2 == null)
                sql = "select * from client where " + key1 + " like '%" + value1 + "%' order by cno";
            else
                sql = "select * from client where " + key1 + " like '%" + value1 + "%' and " +
                        key2 + " like '%" + value2 + "%' order by cno";
        }
        JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
        System.out.println(key1);
        System.out.println(value1);
        System.out.println(key2);
        System.out.println(value2);
        System.out.println(sql);
        List<Client> clients = template.query(sql, new BeanPropertyRowMapper<Client>(Client.class));
        System.out.println(clients);
        return clients;
    }

    @Override
    public void deleteClient(String cno) {
        try{
            String sql = "delete from client where cno = ?";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            template.update(sql, cno);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Client findClientByCno(String cno) {
        String sql = "select * from client where cno = " + cno;
        JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
        List<Client> agencies = template.query(sql, new BeanPropertyRowMapper<Client>(Client.class));
        if(agencies != null)
            return agencies.get(0);
        return null;
    }

    @Override
    public void reviseClient(Client client, String cno) {
        try{
            System.out.println("revise");
            System.out.println(client);
            String sql = "update client set cno = ?, cname = ?, csex = ?, cage = ?,  caddress = ?, cphone = ?, csymptom = ?, " +
                    "mno = ?, ano = ?, cdate = ?, cremark = ? where cno = ?";
            JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
            template.update(sql, client.getCno(), client.getCname(), client.getCsex(), client.getCage(), client.getCaddress()
                    , client.getCphone(), client.getCsymptom(), client.getMno(), client.getAno(), client.getCdate(), client.getCremark(),
                    client.getCno());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from client";
        JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
        int count = template.queryForObject(sql, Integer.class);
        System.out.println(count);
        return count;
    }

    @Override
    public List<Client> findByPage(int start, int rows) {
        String sql = "select * from client limit ? , ?";//sql中分页查询的方法，初始索引，记录数
        JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
        List<Client> clientList = template.query(sql, new BeanPropertyRowMapper<Client>(Client.class), start, rows);
        return clientList;
    }
}
