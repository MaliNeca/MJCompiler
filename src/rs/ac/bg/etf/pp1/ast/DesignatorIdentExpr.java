// generated with ast extension for cup
// version 0.8
// 20/5/2019 20:50:7


package rs.ac.bg.etf.pp1.ast;

public class DesignatorIdentExpr extends Designator {

    private DesignatorExprLSquare DesignatorExprLSquare;
    private Expr Expr;

    public DesignatorIdentExpr (DesignatorExprLSquare DesignatorExprLSquare, Expr Expr) {
        this.DesignatorExprLSquare=DesignatorExprLSquare;
        if(DesignatorExprLSquare!=null) DesignatorExprLSquare.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public DesignatorExprLSquare getDesignatorExprLSquare() {
        return DesignatorExprLSquare;
    }

    public void setDesignatorExprLSquare(DesignatorExprLSquare DesignatorExprLSquare) {
        this.DesignatorExprLSquare=DesignatorExprLSquare;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorExprLSquare!=null) DesignatorExprLSquare.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorExprLSquare!=null) DesignatorExprLSquare.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorExprLSquare!=null) DesignatorExprLSquare.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorIdentExpr(\n");

        if(DesignatorExprLSquare!=null)
            buffer.append(DesignatorExprLSquare.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorIdentExpr]");
        return buffer.toString();
    }
}
