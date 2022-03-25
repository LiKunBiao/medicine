package dao;

import bean.Agency;
import bean.Page;

import java.util.List;

public interface AgencyDao {
    public List<Agency> findAllAgency();
    public void addAgency(Agency agency);
    public List<Agency> searchAgency(String key1, String value1, String key2, String value2, int start, int rows);
    public void deleteAgency(String ano);
    public Agency findAgencyByAno(String ano);
    public void reviseAgency(Agency agency, String ano);
    public int findTotalCount();
    public List<Agency> findByPage(int start, int rows);
    public int findSearchCount(String key1, String value1, String key2, String value2);
}
