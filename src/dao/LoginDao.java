package dao;

import bean.Client;
import bean.Login;
import bean.Page;

import java.util.List;

public interface LoginDao {
    public Login login(String username, String password);
    public List<Login> findAllLogin();
    public void addLogin(Login login);
    public void deleteLogin(String username);
    public List<Login> searchLogin(String username, int start, int rows);
    public Login findLoginByUsername(String username);
    public void reviseLogin(Login login, String username);
    public int findTotalCount();
    public List<Login> findByPage(int start, int rows);
}
