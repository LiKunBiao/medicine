package bean;

public class Medicine {
    private String mno;//编号
    private String mname;//名称
    private String mmode;//服用方法
    private String mefficacy;//功效

    public Medicine() {
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMmode() {
        return mmode;
    }

    public void setMmode(String mmode) {
        this.mmode = mmode;
    }

    public String getMefficacy() {
        return mefficacy;
    }

    public void setMefficacy(String mefficacy) {
        this.mefficacy = mefficacy;
    }
}
