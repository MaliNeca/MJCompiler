// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class EnumDeclaration extends EnumDecl {

    private String identName;
    private IdentEnumList IdentEnumList;

    public EnumDeclaration (String identName, IdentEnumList IdentEnumList) {
        this.identName=identName;
        this.IdentEnumList=IdentEnumList;
        if(IdentEnumList!=null) IdentEnumList.setParent(this);
    }

    public String getIdentName() {
        return identName;
    }

    public void setIdentName(String identName) {
        this.identName=identName;
    }

    public IdentEnumList getIdentEnumList() {
        return IdentEnumList;
    }

    public void setIdentEnumList(IdentEnumList IdentEnumList) {
        this.IdentEnumList=IdentEnumList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IdentEnumList!=null) IdentEnumList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentEnumList!=null) IdentEnumList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentEnumList!=null) IdentEnumList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumDeclaration(\n");

        buffer.append(" "+tab+identName);
        buffer.append("\n");

        if(IdentEnumList!=null)
            buffer.append(IdentEnumList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumDeclaration]");
        return buffer.toString();
    }
}
