package bean;

public class Agency {
    private String ano;//编号
    private String aname;//姓名
    private String asex;//性别
    private String aphone;//电话
    private String aremark;//备注

    public Agency() {
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAsex() {
        return asex;
    }

    public void setAsex(String asex) {
        this.asex = asex;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public String getAremark() {
        return aremark;
    }

    public void setAremark(String aremark) {
        this.aremark = aremark;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "ano='" + ano + '\'' +
                ", aname='" + aname + '\'' +
                ", asex='" + asex + '\'' +
                ", aphone='" + aphone + '\'' +
                ", aremark='" + aremark + '\'' +
                '}';
    }
}
