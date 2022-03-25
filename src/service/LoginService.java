package service;


import bean.Login;
import bean.Page;
import dao.impl.LoginImpl;

import java.util.List;

public class LoginService {
    public Login login(String username, String password)
    {
        LoginImpl dao = new LoginImpl();
        return dao.login(username, password);
    }
    public List<Login> findAllLogin() {
        LoginImpl dao = new LoginImpl();
        return dao.findAllLogin();
    }
    public void addLogin(Login login)
    {
        LoginImpl dao = new LoginImpl();
        dao.addLogin(login);
        return;
    }
    public void deleteLogin(String username)
    {
        LoginImpl dao = new LoginImpl();
        dao.deleteLogin(username);
    }
    public Login findLoginByUsername(String username)
    {
        LoginImpl dao = new LoginImpl();
        return dao.findLoginByUsername(username);
    }
    public void reviseLogin(Login login, String username)
    {
        LoginImpl dao = new LoginImpl();
        dao.reviseLogin(login, username);
    }
    public void deleteSelectLogin(String[] usernames)
    {
        for(String username : usernames)
        {
            LoginImpl dao = new LoginImpl();
            dao.deleteLogin(username);
        }
    }
    public Page<Login> findLoginByPage(String _currentPage, String _rows)
    {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        Page<Login> loginPage = new Page<Login>();
        loginPage.setCurrentPage(currentPage);//当前页码
        loginPage.setRows(rows);//每页记录数
        LoginImpl dao = new LoginImpl();
        //1.调用dao查询总记录数
        int totalCount = dao.findTotalCount();//总记录数
        loginPage.setTotalCount(totalCount);
        //2.调用dao查询List集合
        int start = (currentPage - 1) * rows;//计算开始的记录索引
        List<Login> list = dao.findByPage(start, rows);//查询集合，开始索引，记录数
        loginPage.setList(list);
        //3.计算总页码
        int totalPage = (totalCount % rows == 0) ? totalCount/rows : totalCount/rows + 1;//总页码
        loginPage.setTotalPage(totalPage);
        return loginPage;
    }
    public Page<Login> searchLoginByPage(String _currentPage, String _rows, String username)
    {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        Page<Login> loginPage = new Page<Login>();
        loginPage.setCurrentPage(currentPage);//当前页码
        loginPage.setRows(rows);//每页记录数
        LoginImpl dao = new LoginImpl();
        //1.调用dao查询List集合
        int start = (currentPage - 1) * rows;//计算开始的记录索引
        List<Login> list = dao.searchLogin(username, start, rows);
        loginPage.setList(list);
        //2.调用dao查询总记录数
        int totalCount = list.size();
        loginPage.setTotalCount(totalCount);
        //3.计算总页码
        int totalPage = (totalCount % rows == 0) ? totalCount/rows : totalCount/rows + 1;//总页码
        loginPage.setTotalPage(totalPage);
        return loginPage;
    }
}
