// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:6


package rs.ac.bg.etf.pp1.ast;

public class VarDeclarationTrue extends VarDecl {

    private Type Type;
    private IdentVarList IdentVarList;

    public VarDeclarationTrue (Type Type, IdentVarList IdentVarList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.IdentVarList=IdentVarList;
        if(IdentVarList!=null) IdentVarList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(Type!=null) Type.accept(visitor);
        if(IdentVarList!=null) IdentVarList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(IdentVarList!=null) IdentVarList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(IdentVarList!=null) IdentVarList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclarationTrue(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentVarList!=null)
            buffer.append(IdentVarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclarationTrue]");
        return buffer.toString();
    }
}
