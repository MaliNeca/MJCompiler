// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class FormParsOne extends FormParsList {

    private FormParam FormParam;

    public FormParsOne (FormParam FormParam) {
        this.FormParam=FormParam;
        if(FormParam!=null) FormParam.setParent(this);
    }

    public FormParam getFormParam() {
        return FormParam;
    }

    public void setFormParam(FormParam FormParam) {
        this.FormParam=FormParam;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParam!=null) FormParam.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParam!=null) FormParam.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParam!=null) FormParam.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsOne(\n");

        if(FormParam!=null)
            buffer.append(FormParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsOne]");
        return buffer.toString();
    }
}
