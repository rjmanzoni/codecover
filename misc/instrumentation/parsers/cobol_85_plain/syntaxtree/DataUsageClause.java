//
// Generated by JTB 1.3.2
//

package org.codecover.instrumentation.cobol85.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * f0 -> [ &lt;USAGE&gt; [ &lt;IS&gt; ] ]
 * f1 -> ( &lt;BINARY&gt; | &lt;COMP&gt; | &lt;COMP_1&gt; | &lt;COMP_2&gt; | &lt;COMP_3&gt; | &lt;COMP_4&gt; | &lt;COMPUTATIONAL&gt; | &lt;COMPUTATIONAL_1&gt; | &lt;COMPUTATIONAL_2&gt; | &lt;COMPUTATIONAL_3&gt; | &lt;COMPUTATIONAL_4&gt; | &lt;DISPLAY&gt; | &lt;DISPLAY_1&gt; | &lt;INDEX&gt; | &lt;PACKED_DECIMAL&gt; | &lt;POINTER&gt; )
 * </PRE>
 */
public class DataUsageClause implements Node {
   private Node parent;
   public NodeOptional f0;
   public NodeChoice f1;

   public DataUsageClause(NodeOptional n0, NodeChoice n1) {
      f0 = n0;
      if ( f0 != null ) f0.setParent(this);
      f1 = n1;
      if ( f1 != null ) f1.setParent(this);
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

