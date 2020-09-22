// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class EnumI extends IdentEnumList {

    private EnumIdent EnumIdent;

    public EnumI (EnumIdent EnumIdent) {
        this.EnumIdent=EnumIdent;
        if(EnumIdent!=null) EnumIdent.setParent(this);
    }

    public EnumIdent getEnumIdent() {
        return EnumIdent;
    }

    public void setEnumIdent(EnumIdent EnumIdent) {
        this.EnumIdent=EnumIdent;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(EnumIdent!=null) EnumIdent.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(EnumIdent!=null) EnumIdent.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(EnumIdent!=null) EnumIdent.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumI(\n");

        if(EnumIdent!=null)
            buffer.append(EnumIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumI]");
        return buffer.toString();
    }
}
