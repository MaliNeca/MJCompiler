// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class ActParsDesignatorOptionY extends ActParsDesignatorOption {

    private ActParsOption ActParsOption;

    public ActParsDesignatorOptionY (ActParsOption ActParsOption) {
        this.ActParsOption=ActParsOption;
        if(ActParsOption!=null) ActParsOption.setParent(this);
    }

    public ActParsOption getActParsOption() {
        return ActParsOption;
    }

    public void setActParsOption(ActParsOption ActParsOption) {
        this.ActParsOption=ActParsOption;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsOption!=null) ActParsOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsOption!=null) ActParsOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsOption!=null) ActParsOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsDesignatorOptionY(\n");

        if(ActParsOption!=null)
            buffer.append(ActParsOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsDesignatorOptionY]");
        return buffer.toString();
    }
}
