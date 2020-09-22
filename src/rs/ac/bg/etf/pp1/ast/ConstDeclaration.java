// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:6


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclaration extends ConstDecl {

    private Type Type;
    private IdentConstList IdentConstList;

    public ConstDeclaration (Type Type, IdentConstList IdentConstList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.IdentConstList=IdentConstList;
        if(IdentConstList!=null) IdentConstList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public IdentConstList getIdentConstList() {
        return IdentConstList;
    }

    public void setIdentConstList(IdentConstList IdentConstList) {
        this.IdentConstList=IdentConstList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(IdentConstList!=null) IdentConstList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(IdentConstList!=null) IdentConstList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(IdentConstList!=null) IdentConstList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentConstList!=null)
            buffer.append(IdentConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclaration]");
        return buffer.toString();
    }
}
