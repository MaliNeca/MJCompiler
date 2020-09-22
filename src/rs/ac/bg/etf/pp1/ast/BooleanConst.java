// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:6


package rs.ac.bg.etf.pp1.ast;

public class BooleanConst extends ConstType {

    private String identName;
    private Boolean bool;

    public BooleanConst (String identName, Boolean bool) {
        this.identName=identName;
        this.bool=bool;
    }

    public String getIdentName() {
        return identName;
    }

    public void setIdentName(String identName) {
        this.identName=identName;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool=bool;
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
        buffer.append("BooleanConst(\n");

        buffer.append(" "+tab+identName);
        buffer.append("\n");

        buffer.append(" "+tab+bool);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BooleanConst]");
        return buffer.toString();
    }
}
