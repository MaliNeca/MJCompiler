// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class InterfaceMethDeclarations extends InterfaceMethDeclList {

    private InterfaceMethDeclList InterfaceMethDeclList;
    private InterfaceMethDecl InterfaceMethDecl;

    public InterfaceMethDeclarations (InterfaceMethDeclList InterfaceMethDeclList, InterfaceMethDecl InterfaceMethDecl) {
        this.InterfaceMethDeclList=InterfaceMethDeclList;
        if(InterfaceMethDeclList!=null) InterfaceMethDeclList.setParent(this);
        this.InterfaceMethDecl=InterfaceMethDecl;
        if(InterfaceMethDecl!=null) InterfaceMethDecl.setParent(this);
    }

    public InterfaceMethDeclList getInterfaceMethDeclList() {
        return InterfaceMethDeclList;
    }

    public void setInterfaceMethDeclList(InterfaceMethDeclList InterfaceMethDeclList) {
        this.InterfaceMethDeclList=InterfaceMethDeclList;
    }

    public InterfaceMethDecl getInterfaceMethDecl() {
        return InterfaceMethDecl;
    }

    public void setInterfaceMethDecl(InterfaceMethDecl InterfaceMethDecl) {
        this.InterfaceMethDecl=InterfaceMethDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(InterfaceMethDeclList!=null) InterfaceMethDeclList.accept(visitor);
        if(InterfaceMethDecl!=null) InterfaceMethDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(InterfaceMethDeclList!=null) InterfaceMethDeclList.traverseTopDown(visitor);
        if(InterfaceMethDecl!=null) InterfaceMethDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(InterfaceMethDeclList!=null) InterfaceMethDeclList.traverseBottomUp(visitor);
        if(InterfaceMethDecl!=null) InterfaceMethDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("InterfaceMethDeclarations(\n");

        if(InterfaceMethDeclList!=null)
            buffer.append(InterfaceMethDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(InterfaceMethDecl!=null)
            buffer.append(InterfaceMethDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [InterfaceMethDeclarations]");
        return buffer.toString();
    }
}
