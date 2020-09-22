// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:6


package rs.ac.bg.etf.pp1.ast;

public class IdentVL extends IdentVarList {

    private IdentVarList IdentVarList;
    private VarIdent VarIdent;

    public IdentVL (IdentVarList IdentVarList, VarIdent VarIdent) {
        this.IdentVarList=IdentVarList;
        if(IdentVarList!=null) IdentVarList.setParent(this);
        this.VarIdent=VarIdent;
        if(VarIdent!=null) VarIdent.setParent(this);
    }

    public IdentVarList getIdentVarList() {
        return IdentVarList;
    }

    public void setIdentVarList(IdentVarList IdentVarList) {
        this.IdentVarList=IdentVarList;
    }

    public VarIdent getVarIdent() {
        return VarIdent;
    }

    public void setVarIdent(VarIdent VarIdent) {
        this.VarIdent=VarIdent;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IdentVarList!=null) IdentVarList.accept(visitor);
        if(VarIdent!=null) VarIdent.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentVarList!=null) IdentVarList.traverseTopDown(visitor);
        if(VarIdent!=null) VarIdent.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentVarList!=null) IdentVarList.traverseBottomUp(visitor);
        if(VarIdent!=null) VarIdent.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentVL(\n");

        if(IdentVarList!=null)
            buffer.append(IdentVarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarIdent!=null)
            buffer.append(VarIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentVL]");
        return buffer.toString();
    }
}
