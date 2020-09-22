// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class InterfaceMethDeclaration extends InterfaceMethDecl {

    private MethodTypeName MethodTypeName;
    private FormParsOption FormParsOption;

    public InterfaceMethDeclaration (MethodTypeName MethodTypeName, FormParsOption FormParsOption) {
        this.MethodTypeName=MethodTypeName;
        if(MethodTypeName!=null) MethodTypeName.setParent(this);
        this.FormParsOption=FormParsOption;
        if(FormParsOption!=null) FormParsOption.setParent(this);
    }

    public MethodTypeName getMethodTypeName() {
        return MethodTypeName;
    }

    public void setMethodTypeName(MethodTypeName MethodTypeName) {
        this.MethodTypeName=MethodTypeName;
    }

    public FormParsOption getFormParsOption() {
        return FormParsOption;
    }

    public void setFormParsOption(FormParsOption FormParsOption) {
        this.FormParsOption=FormParsOption;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodTypeName!=null) MethodTypeName.accept(visitor);
        if(FormParsOption!=null) FormParsOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodTypeName!=null) MethodTypeName.traverseTopDown(visitor);
        if(FormParsOption!=null) FormParsOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodTypeName!=null) MethodTypeName.traverseBottomUp(visitor);
        if(FormParsOption!=null) FormParsOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("InterfaceMethDeclaration(\n");

        if(MethodTypeName!=null)
            buffer.append(MethodTypeName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsOption!=null)
            buffer.append(FormParsOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [InterfaceMethDeclaration]");
        return buffer.toString();
    }
}
