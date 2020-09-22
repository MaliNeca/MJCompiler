// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class EnumIdent implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String identName;
    private ValueOption ValueOption;

    public EnumIdent (String identName, ValueOption ValueOption) {
        this.identName=identName;
        this.ValueOption=ValueOption;
        if(ValueOption!=null) ValueOption.setParent(this);
    }

    public String getIdentName() {
        return identName;
    }

    public void setIdentName(String identName) {
        this.identName=identName;
    }

    public ValueOption getValueOption() {
        return ValueOption;
    }

    public void setValueOption(ValueOption ValueOption) {
        this.ValueOption=ValueOption;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ValueOption!=null) ValueOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ValueOption!=null) ValueOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ValueOption!=null) ValueOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumIdent(\n");

        buffer.append(" "+tab+identName);
        buffer.append("\n");

        if(ValueOption!=null)
            buffer.append(ValueOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumIdent]");
        return buffer.toString();
    }
}
