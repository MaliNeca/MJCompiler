// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class ImplTypeMany extends ImplementsTypeList {

    private ImplementsTypeList ImplementsTypeList;
    private Type Type;

    public ImplTypeMany (ImplementsTypeList ImplementsTypeList, Type Type) {
        this.ImplementsTypeList=ImplementsTypeList;
        if(ImplementsTypeList!=null) ImplementsTypeList.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
    }

    public ImplementsTypeList getImplementsTypeList() {
        return ImplementsTypeList;
    }

    public void setImplementsTypeList(ImplementsTypeList ImplementsTypeList) {
        this.ImplementsTypeList=ImplementsTypeList;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ImplementsTypeList!=null) ImplementsTypeList.accept(visitor);
        if(Type!=null) Type.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ImplementsTypeList!=null) ImplementsTypeList.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ImplementsTypeList!=null) ImplementsTypeList.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ImplTypeMany(\n");

        if(ImplementsTypeList!=null)
            buffer.append(ImplementsTypeList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ImplTypeMany]");
        return buffer.toString();
    }
}
