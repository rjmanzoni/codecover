//
// Generated by JTB 1.3.2
//

package org.codecover.instrumentation.cobol85.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * f0 -> &lt;RETURN&gt;
 * f1 -> FileName()
 * f2 -> [ &lt;RECORD&gt; ]
 * f3 -> [ &lt;INTO&gt; QualifiedDataName() ]
 * f4 -> [ &lt;AT&gt; ]
 * f5 -> &lt;END&gt;
 * f6 -> StatementList()
 * f7 -> [ &lt;NOT&gt; [ &lt;AT&gt; ] &lt;END&gt; StatementList() ]
 * f8 -> [ &lt;END_RETURN&gt; ]
 * </PRE>
 */
public class ReturnStatement implements Node {
   private Node parent;
   public NodeToken f0;
   public FileName f1;
   public NodeOptional f2;
   public NodeOptional f3;
   public NodeOptional f4;
   public NodeToken f5;
   public StatementList f6;
   public NodeOptional f7;
   public NodeOptional f8;

   public ReturnStatement(NodeToken n0, FileName n1, NodeOptional n2, NodeOptional n3, NodeOptional n4, NodeToken n5, StatementList n6, NodeOptional n7, NodeOptional n8) {
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
      f7 = n7;
      if ( f7 != null ) f7.setParent(this);
      f8 = n8;
      if ( f8 != null ) f8.setParent(this);
   }

   public ReturnStatement(FileName n0, NodeOptional n1, NodeOptional n2, NodeOptional n3, StatementList n4, NodeOptional n5, NodeOptional n6) {
      f0 = new NodeToken("return");
      if ( f0 != null ) f0.setParent(this);
      f1 = n0;
      if ( f1 != null ) f1.setParent(this);
      f2 = n1;
      if ( f2 != null ) f2.setParent(this);
      f3 = n2;
      if ( f3 != null ) f3.setParent(this);
      f4 = n3;
      if ( f4 != null ) f4.setParent(this);
      f5 = new NodeToken("end");
      if ( f5 != null ) f5.setParent(this);
      f6 = n4;
      if ( f6 != null ) f6.setParent(this);
      f7 = n5;
      if ( f7 != null ) f7.setParent(this);
      f8 = n6;
      if ( f8 != null ) f8.setParent(this);
   }

   public void accept(org.codecover.instrumentation.cobol85.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(org.codecover.instrumentation.cobol85.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(org.codecover.instrumentation.cobol85.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(org.codecover.instrumentation.cobol85.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
   public void setParent(Node n) { parent = n; }
   public Node getParent()       { return parent; }
}

