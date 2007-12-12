﻿///////////////////////////////////////////////////////////////////////////////
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
 * f0 -> &lt;UNSTRING&gt;
 * f1 -> QualifiedDataName()
 * f2 -> [ &lt;DELIMITED&gt; [ &lt;BY&gt; ] [ &lt;ALL&gt; ] ( Identifier() | Literal() ) ( &lt;OR&gt; [ &lt;ALL&gt; ] ( Identifier() | Literal() ) )* ]
 * f3 -> &lt;INTO&gt;
 * f4 -> ( Identifier() [ &lt;DELIMITER&gt; [ &lt;IN&gt; ] Identifier() ] [ &lt;COUNT&gt; [ &lt;IN&gt; ] Identifier() ] )+
 * f5 -> [ [ &lt;WITH&gt; ] &lt;POINTER&gt; QualifiedDataName() ]
 * f6 -> [ &lt;TALLYING&gt; [ &lt;IN&gt; ] QualifiedDataName() ]
 * f7 -> [ [ &lt;ON&gt; ] &lt;OVERFLOW&gt; StatementList() ]
 * f8 -> [ &lt;NOT&gt; [ &lt;ON&gt; ] &lt;OVERFLOW&gt; StatementList() ]
 * f9 -> [ &lt;END_UNSTRING&gt; ]
 * </PRE>
 */
public class UnstringStatement implements Node {
   private Node parent;
   public NodeToken f0;
   public QualifiedDataName f1;
   public NodeOptional f2;
   public NodeToken f3;
   public NodeList f4;
   public NodeOptional f5;
   public NodeOptional f6;
   public NodeOptional f7;
   public NodeOptional f8;
   public NodeOptional f9;

   public UnstringStatement(NodeToken n0, QualifiedDataName n1, NodeOptional n2, NodeToken n3, NodeList n4, NodeOptional n5, NodeOptional n6, NodeOptional n7, NodeOptional n8, NodeOptional n9) {
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
      f9 = n9;
      if ( f9 != null ) f9.setParent(this);
   }

   public UnstringStatement(QualifiedDataName n0, NodeOptional n1, NodeList n2, NodeOptional n3, NodeOptional n4, NodeOptional n5, NodeOptional n6, NodeOptional n7) {
      f0 = new NodeToken("unstring");
      if ( f0 != null ) f0.setParent(this);
      f1 = n0;
      if ( f1 != null ) f1.setParent(this);
      f2 = n1;
      if ( f2 != null ) f2.setParent(this);
      f3 = new NodeToken("into");
      if ( f3 != null ) f3.setParent(this);
      f4 = n2;
      if ( f4 != null ) f4.setParent(this);
      f5 = n3;
      if ( f5 != null ) f5.setParent(this);
      f6 = n4;
      if ( f6 != null ) f6.setParent(this);
      f7 = n5;
      if ( f7 != null ) f7.setParent(this);
      f8 = n6;
      if ( f8 != null ) f8.setParent(this);
      f9 = n7;
      if ( f9 != null ) f9.setParent(this);
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

