// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class Inheritance extends ClassDecl {

    private String I1;
    private ExtendsOption ExtendsOption;
    private ImplementsOption ImplementsOption;
    private VarDecl VarDecl;
    private MethodDeclOption MethodDeclOption;

    public Inheritance (String I1, ExtendsOption ExtendsOption, ImplementsOption ImplementsOption, VarDecl VarDecl, MethodDeclOption MethodDeclOption) {
        this.I1=I1;
        this.ExtendsOption=ExtendsOption;
        if(ExtendsOption!=null) ExtendsOption.setParent(this);
        this.ImplementsOption=ImplementsOption;
        if(ImplementsOption!=null) ImplementsOption.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
        this.MethodDeclOption=MethodDeclOption;
        if(MethodDeclOption!=null) MethodDeclOption.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ExtendsOption getExtendsOption() {
        return ExtendsOption;
    }

    public void setExtendsOption(ExtendsOption ExtendsOption) {
        this.ExtendsOption=ExtendsOption;
    }

    public ImplementsOption getImplementsOption() {
        return ImplementsOption;
    }

    public void setImplementsOption(ImplementsOption ImplementsOption) {
        this.ImplementsOption=ImplementsOption;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public MethodDeclOption getMethodDeclOption() {
        return MethodDeclOption;
    }

    public void setMethodDeclOption(MethodDeclOption MethodDeclOption) {
        this.MethodDeclOption=MethodDeclOption;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExtendsOption!=null) ExtendsOption.accept(visitor);
        if(ImplementsOption!=null) ImplementsOption.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
        if(MethodDeclOption!=null) MethodDeclOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExtendsOption!=null) ExtendsOption.traverseTopDown(visitor);
        if(ImplementsOption!=null) ImplementsOption.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
        if(MethodDeclOption!=null) MethodDeclOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExtendsOption!=null) ExtendsOption.traverseBottomUp(visitor);
        if(ImplementsOption!=null) ImplementsOption.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        if(MethodDeclOption!=null) MethodDeclOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Inheritance(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ExtendsOption!=null)
            buffer.append(ExtendsOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ImplementsOption!=null)
            buffer.append(ImplementsOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclOption!=null)
            buffer.append(MethodDeclOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Inheritance]");
        return buffer.toString();
    }
}
