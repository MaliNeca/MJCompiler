// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:6


package rs.ac.bg.etf.pp1.ast;

public class NumConst extends ConstType {

    private String identName;
    private Integer number;

    public NumConst (String identName, Integer number) {
        this.identName=identName;
        this.number=number;
    }

    public String getIdentName() {
        return identName;
    }

    public void setIdentName(String identName) {
        this.identName=identName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number=number;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NumConst(\n");

        buffer.append(" "+tab+identName);
        buffer.append("\n");

        buffer.append(" "+tab+number);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NumConst]");
        return buffer.toString();
    }
}
