// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:6


package rs.ac.bg.etf.pp1.ast;

public class IdentVLErrorL extends IdentVarList {

    private IdentVarList IdentVarList;

    public IdentVLErrorL (IdentVarList IdentVarList) {
        this.IdentVarList=IdentVarList;
        if(IdentVarList!=null) IdentVarList.setParent(this);
    }

    public IdentVarList getIdentVarList() {
        return IdentVarList;
    }

    public void setIdentVarList(IdentVarList IdentVarList) {
        this.IdentVarList=IdentVarList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IdentVarList!=null) IdentVarList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentVarList!=null) IdentVarList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentVarList!=null) IdentVarList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentVLErrorL(\n");

        if(IdentVarList!=null)
            buffer.append(IdentVarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentVLErrorL]");
        return buffer.toString();
    }
}
