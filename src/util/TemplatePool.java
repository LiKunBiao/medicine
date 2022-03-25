package util;

import org.springframework.jdbc.core.JdbcTemplate;

public class TemplatePool {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(DruidPool.getDataSource());
        //3.调用方法
        //update():执行DML语句。增、删、改语句
        //queryForMap():查询结果将结果集封装为map集合，将列名作为key，将值作为value，将这条记录封装为一个map集合
        //queryForList():查询结果将结果集封装为list集合，将每条记录封装为一个map集合，再将这条记录封装为一个list集合
        //query():将结果封装为JavaBean对象，(sql, new BeanPropertyRowMapper<User>(User.class))
                    //属性名字和表字段保持一致
        //queryForObject:查询结果，将结果封装为对象
                    //select count(*) from Emp;
                    //(sql, 返回类型.class),一般用于聚合函数的查询
    }
}
