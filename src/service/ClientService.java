package service;

import bean.Client;
import bean.Page;
import dao.impl.ClientImpl;

import java.util.List;

public class ClientService {
    public List<Client> findAllClient() {
        ClientImpl dao = new ClientImpl();
        return dao.findAllClient();
    }
    public void addClient(Client Client)
    {
        ClientImpl dao = new ClientImpl();
        dao.addClient(Client);
        return;
    }
    public void deleteClient(String cno)
    {
        ClientImpl dao = new ClientImpl();
        dao.deleteClient(cno);
    }
    public Client findClientByCno(String cno)
    {
        ClientImpl dao = new ClientImpl();
        return dao.findClientByCno(cno);
    }
    public void reviseClient(Client client, String cno)
    {
        ClientImpl dao = new ClientImpl();
        dao.reviseClient(client, cno);
    }
    public void deleteSelectClient(String[] cnos)
    {
        for(String cno : cnos)
        {
            ClientImpl dao = new ClientImpl();
            dao.deleteClient(cno);
        }
    }
    public Page<Client> findClientByPage(String _currentPage, String _rows)
    {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        Page<Client> clientPage = new Page<Client>();
        clientPage.setCurrentPage(currentPage);//当前页码
        clientPage.setRows(rows);//每页记录数
        ClientImpl dao = new ClientImpl();
        //1.调用dao查询总记录数
        int totalCount = dao.findTotalCount();//总记录数
        clientPage.setTotalCount(totalCount);
        //2.调用dao查询List集合
        int start = (currentPage - 1) * rows;//计算开始的记录索引
        List<Client> list = dao.findByPage(start, rows);//查询集合，开始索引，记录数
        clientPage.setList(list);
        //3.计算总页码
        int totalPage = (totalCount % rows == 0) ? totalCount/rows : totalCount/rows + 1;//总页码
        clientPage.setTotalPage(totalPage);
        return clientPage;
    }
    public Page<Client> searchClientByPage(String _currentPage, String _rows, String key1, String value1, String key2, String value2)
    {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        Page<Client> clientPage = new Page<Client>();
        clientPage.setCurrentPage(currentPage);//当前页码
        clientPage.setRows(rows);//每页记录数
        ClientImpl dao = new ClientImpl();
        //1.调用dao查询List集合
        int start = (currentPage - 1) * rows;//计算开始的记录索引
        List<Client> list = dao.searchClient(key1, value1, key2, value2, start, rows);
        clientPage.setList(list);
        //2.调用dao查询总记录数
        int totalCount = list.size();
        clientPage.setTotalCount(totalCount);
        //3.计算总页码
        int totalPage = (totalCount % rows == 0) ? totalCount/rows : totalCount/rows + 1;//总页码
        clientPage.setTotalPage(totalPage);
        return clientPage;
    }
}
