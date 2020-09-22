// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class InterfaceDelaration extends InterfaceDecl {

    private String I1;
    private InterfaceMethDeclList InterfaceMethDeclList;

    public InterfaceDelaration (String I1, InterfaceMethDeclList InterfaceMethDeclList) {
        this.I1=I1;
        this.InterfaceMethDeclList=InterfaceMethDeclList;
        if(InterfaceMethDeclList!=null) InterfaceMethDeclList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public InterfaceMethDeclList getInterfaceMethDeclList() {
        return InterfaceMethDeclList;
    }

    public void setInterfaceMethDeclList(InterfaceMethDeclList InterfaceMethDeclList) {
        this.InterfaceMethDeclList=InterfaceMethDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(InterfaceMethDeclList!=null) InterfaceMethDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(InterfaceMethDeclList!=null) InterfaceMethDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(InterfaceMethDeclList!=null) InterfaceMethDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("InterfaceDelaration(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(InterfaceMethDeclList!=null)
            buffer.append(InterfaceMethDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [InterfaceDelaration]");
        return buffer.toString();
    }
}
