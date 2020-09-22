// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:6


package rs.ac.bg.etf.pp1.ast;

public class IdentCL extends IdentConstList {

    private IdentConstList IdentConstList;
    private ConstType ConstType;

    public IdentCL (IdentConstList IdentConstList, ConstType ConstType) {
        this.IdentConstList=IdentConstList;
        if(IdentConstList!=null) IdentConstList.setParent(this);
        this.ConstType=ConstType;
        if(ConstType!=null) ConstType.setParent(this);
    }

    public IdentConstList getIdentConstList() {
        return IdentConstList;
    }

    public void setIdentConstList(IdentConstList IdentConstList) {
        this.IdentConstList=IdentConstList;
    }

    public ConstType getConstType() {
        return ConstType;
    }

    public void setConstType(ConstType ConstType) {
        this.ConstType=ConstType;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IdentConstList!=null) IdentConstList.accept(visitor);
        if(ConstType!=null) ConstType.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentConstList!=null) IdentConstList.traverseTopDown(visitor);
        if(ConstType!=null) ConstType.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentConstList!=null) IdentConstList.traverseBottomUp(visitor);
        if(ConstType!=null) ConstType.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentCL(\n");

        if(IdentConstList!=null)
            buffer.append(IdentConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstType!=null)
            buffer.append(ConstType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentCL]");
        return buffer.toString();
    }
}
