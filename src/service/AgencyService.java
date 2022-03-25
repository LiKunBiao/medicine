package service;

import bean.Agency;
import bean.Page;
import dao.impl.AgencyImpl;

import java.util.List;

public class AgencyService {
    public List<Agency> findAllAgency() {
        AgencyImpl dao = new AgencyImpl();
        return dao.findAllAgency();
    }
    public void addAgency(Agency agency)
    {
        AgencyImpl dao = new AgencyImpl();
        dao.addAgency(agency);
        return;
    }
    public void deleteAgency(String ano)
    {
        AgencyImpl dao = new AgencyImpl();
        dao.deleteAgency(ano);
    }
    public Agency findAgencyByAno(String ano)
    {
        AgencyImpl dao = new AgencyImpl();
        return dao.findAgencyByAno(ano);
    }
    public void reviseAgency(Agency agency, String ano)
    {
        AgencyImpl dao = new AgencyImpl();
        dao.reviseAgency(agency, ano);
    }
    public void deleteSelectAgency(String[] anos)
    {
        for(String ano : anos)
        {
            AgencyImpl dao = new AgencyImpl();
            dao.deleteAgency(ano);
        }
    }
    public Page<Agency> findAgencyByPage(String _currentPage, String _rows, String key1, String value1, String key2, String value2)
    {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        Page<Agency> agencyPage = new Page<Agency>();
        agencyPage.setCurrentPage(currentPage);//当前页码
        agencyPage.setRows(rows);//每页记录数
        AgencyImpl dao = new AgencyImpl();
        int start = (currentPage - 1) * rows;//计算开始的记录索引
        //1.调用dao查询总记录数
        if(key1 != null)
        {
            List<Agency> list = dao.searchAgency(key1, value1, key2, value2, start, rows);
            agencyPage.setList(list);
            //2.调用dao查询总记录数
            int totalCount = dao.findSearchCount(key1, value1, key2, value2);
            agencyPage.setTotalCount(totalCount);
            //3.计算总页码
            int totalPage = (totalCount % rows == 0) ? totalCount/rows : totalCount/rows + 1;//总页码
            agencyPage.setTotalPage(totalPage);
        }
        else
        {
            int totalCount = dao.findTotalCount();//总记录数
            agencyPage.setTotalCount(totalCount);
            //2.调用dao查询List集合
            List<Agency> list = dao.findByPage(start, rows);//查询集合，开始索引，记录数
            agencyPage.setList(list);
            //3.计算总页码
            int totalPage = (totalCount % rows == 0) ? totalCount/rows : totalCount/rows + 1;//总页码
            agencyPage.setTotalPage(totalPage);
        }

        return agencyPage;
    }
    public Page<Agency> searchAgencyByPage(String _currentPage, String _rows, String key1, String value1, String key2, String value2)
    {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        System.out.println("行：" + rows);
        Page<Agency> agencyPage = new Page<Agency>();
        agencyPage.setCurrentPage(currentPage);//当前页码
        agencyPage.setRows(rows);//每页记录数
        AgencyImpl dao = new AgencyImpl();
        //1.调用dao查询List集合
        int start = (currentPage - 1) * rows;//计算开始的记录索引
        List<Agency> list = dao.searchAgency(key1, value1, key2, value2, start, rows);
        agencyPage.setList(list);
        //2.调用dao查询总记录数
        int totalCount = dao.findSearchCount(key1, value1, key2, value2);
        agencyPage.setTotalCount(totalCount);
        //3.计算总页码
        int totalPage = (totalCount % rows == 0) ? totalCount/rows : totalCount/rows + 1;//总页码
        agencyPage.setTotalPage(totalPage);
        return agencyPage;
    }
}
