// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class IdentEL extends IdentEnumList {

    private IdentEnumList IdentEnumList;
    private EnumIdent EnumIdent;

    public IdentEL (IdentEnumList IdentEnumList, EnumIdent EnumIdent) {
        this.IdentEnumList=IdentEnumList;
        if(IdentEnumList!=null) IdentEnumList.setParent(this);
        this.EnumIdent=EnumIdent;
        if(EnumIdent!=null) EnumIdent.setParent(this);
    }

    public IdentEnumList getIdentEnumList() {
        return IdentEnumList;
    }

    public void setIdentEnumList(IdentEnumList IdentEnumList) {
        this.IdentEnumList=IdentEnumList;
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
        if(IdentEnumList!=null) IdentEnumList.accept(visitor);
        if(EnumIdent!=null) EnumIdent.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentEnumList!=null) IdentEnumList.traverseTopDown(visitor);
        if(EnumIdent!=null) EnumIdent.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentEnumList!=null) IdentEnumList.traverseBottomUp(visitor);
        if(EnumIdent!=null) EnumIdent.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentEL(\n");

        if(IdentEnumList!=null)
            buffer.append(IdentEnumList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EnumIdent!=null)
            buffer.append(EnumIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentEL]");
        return buffer.toString();
    }
}
