// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class FactorDesig extends Factor {

    private Designator Designator;
    private ActParsDesignatorOption ActParsDesignatorOption;

    public FactorDesig (Designator Designator, ActParsDesignatorOption ActParsDesignatorOption) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsDesignatorOption=ActParsDesignatorOption;
        if(ActParsDesignatorOption!=null) ActParsDesignatorOption.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsDesignatorOption getActParsDesignatorOption() {
        return ActParsDesignatorOption;
    }

    public void setActParsDesignatorOption(ActParsDesignatorOption ActParsDesignatorOption) {
        this.ActParsDesignatorOption=ActParsDesignatorOption;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsDesignatorOption!=null) ActParsDesignatorOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsDesignatorOption!=null) ActParsDesignatorOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsDesignatorOption!=null) ActParsDesignatorOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesig(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsDesignatorOption!=null)
            buffer.append(ActParsDesignatorOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesig]");
        return buffer.toString();
    }
}
