///////////////////////////////////////////////////////////////////////////////
//
// $Id$
//
///////////////////////////////////////////////////////////////////////////////

//
// Generated by JTB 1.3.2
//

package org.gbt2.instrumentation.cobol85.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * f0 -> &lt;COMPUTE&gt;
 * f1 -> ( Identifier() [ &lt;ROUNDED&gt; ] )+
 * f2 -> ( &lt;EQUALCHAR&gt; | &lt;EQUAL&gt; )
 * f3 -> ArithmeticExpression()
 * f4 -> [ [ &lt;ON&gt; ] &lt;SIZE&gt; &lt;ERROR&gt; StatementList() ]
 * f5 -> [ &lt;NOT&gt; [ &lt;ON&gt; ] &lt;SIZE&gt; &lt;ERROR&gt; StatementList() ]
 * f6 -> [ &lt;END_COMPUTE&gt; ]
 * </PRE>
 */
public class ComputeStatement implements Node {
   private Node parent;
   public NodeToken f0;
   public NodeList f1;
   public NodeChoice f2;
   public ArithmeticExpression f3;
   public NodeOptional f4;
   public NodeOptional f5;
   public NodeOptional f6;

   public ComputeStatement(NodeToken n0, NodeList n1, NodeChoice n2, ArithmeticExpression n3, NodeOptional n4, NodeOptional n5, NodeOptional n6) {
      f0 = n0;
      if ( f0 != null ) f0.setParent(this);
      f1 = n1;
      if ( f1 != null ) f1.setParent(this);
      f2 = n2;
      if ( f2 != null ) f2.setParent(this);
      f3 = n3;
      if ( f3 != null ) f3.setParent(this);
      f4 = n4;
      if ( f4 != null ) f4.setParent(this);
      f5 = n5;
      if ( f5 != null ) f5.setParent(this);
      f6 = n6;
      if ( f6 != null ) f6.setParent(this);
   }

   public ComputeStatement(NodeList n0, NodeChoice n1, ArithmeticExpression n2, NodeOptional n3, NodeOptional n4, NodeOptional n5) {
      f0 = new NodeToken("compute");
      if ( f0 != null ) f0.setParent(this);
      f1 = n0;
      if ( f1 != null ) f1.setParent(this);
      f2 = n1;
      if ( f2 != null ) f2.setParent(this);
      f3 = n2;
      if ( f3 != null ) f3.setParent(this);
      f4 = n3;
      if ( f4 != null ) f4.setParent(this);
      f5 = n4;
      if ( f5 != null ) f5.setParent(this);
      f6 = n5;
      if ( f6 != null ) f6.setParent(this);
   }

   public void accept(org.gbt2.instrumentation.cobol85.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(org.gbt2.instrumentation.cobol85.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(org.gbt2.instrumentation.cobol85.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(org.gbt2.instrumentation.cobol85.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
   public void setParent(Node n) { parent = n; }
   public Node getParent()       { return parent; }
}

