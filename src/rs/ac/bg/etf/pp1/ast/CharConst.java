// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:6


package rs.ac.bg.etf.pp1.ast;

public class CharConst extends ConstType {

    private String identName;
    private Character charr;

    public CharConst (String identName, Character charr) {
        this.identName=identName;
        this.charr=charr;
    }

    public String getIdentName() {
        return identName;
    }

    public void setIdentName(String identName) {
        this.identName=identName;
    }

    public Character getCharr() {
        return charr;
    }

    public void setCharr(Character charr) {
        this.charr=charr;
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
        buffer.append("CharConst(\n");

        buffer.append(" "+tab+identName);
        buffer.append("\n");

        buffer.append(" "+tab+charr);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CharConst]");
        return buffer.toString();
    }
}
