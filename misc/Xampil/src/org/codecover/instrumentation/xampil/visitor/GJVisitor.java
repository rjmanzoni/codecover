//
// Generated by JTB 1.3.2
//

package org.codecover.instrumentation.xampil.visitor;
import org.codecover.instrumentation.xampil.syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors must implement this interface.
 */

public interface GJVisitor<R,A> {

   //
   // GJ Auto class visitors
   //

   public R visit(NodeList n, A argu);
   public R visit(NodeListOptional n, A argu);
   public R visit(NodeOptional n, A argu);
   public R visit(NodeSequence n, A argu);
   public R visit(NodeToken n, A argu);

   //
   // User-generated visitor methods below
   //

   /**
    * <PRE>
    * f0 -> Declaration()
    * f1 -> Program()
    * f2 -> ( &lt;EOL&gt; )?
    * f3 -> &lt;EOF&gt;
    * </PRE>
    */
   public R visit(CompilationUnit n, A argu);

   /**
    * <PRE>
    * f0 -> &lt;DECLARATION&gt;
    * f1 -> &lt;EOL&gt;
    * f2 -> ( SimpleDeclaration() )*
    * </PRE>
    */
   public R visit(Declaration n, A argu);

   /**
    * <PRE>
    * f0 -> ( &lt;BOOLEAN&gt; | &lt;INTEGER&gt; | &lt;STRING&gt; )
    * f1 -> &lt;IDENTIFIER&gt;
    * f2 -> ( &lt;ASSIGN&gt; ( &lt;INTEGER_LITERAL&gt; | &lt;STRING_LITERAL&gt; | &lt;TRUE&gt; | &lt;FALSE&gt; ) )?
    * f3 -> &lt;EOL&gt;
    * </PRE>
    */
   public R visit(SimpleDeclaration n, A argu);

   /**
    * <PRE>
    * f0 -> &lt;PROGRAM&gt;
    * f1 -> &lt;EOL&gt;
    * f2 -> ( Statement() )*
    * f3 -> &lt;ENDPROGRAM&gt;
    * </PRE>
    */
   public R visit(Program n, A argu);

   /**
    * <PRE>
    * f0 -> AssignmentStatement()
    *       | IfStatement()
    *       | WhileStatement()
    *       | SwitchStatement()
    *       | FileStatement()
    * </PRE>
    */
   public R visit(Statement n, A argu);

   /**
    * <PRE>
    * f0 -> &lt;IDENTIFIER&gt;
    * f1 -> &lt;ASSIGN&gt;
    * f2 -> Expression(DUMMY_CONTAINER)
    * f3 -> &lt;EOL&gt;
    * </PRE>
    */
   public R visit(AssignmentStatement n, A argu);

   /**
    * <PRE>
    * f0 -> &lt;IF&gt;
    * f1 -> Expression(basicBooleanCounter)
    * f2 -> &lt;THEN&gt;
    * f3 -> &lt;EOL&gt;
    * f4 -> ( Statement() )*
    * f5 -> ( &lt;ELSE&gt; &lt;EOL&gt; ( Statement() )* )?
    * f6 -> &lt;ENDIF&gt;
    * f7 -> &lt;EOL&gt;
    * </PRE>
    */
   public R visit(IfStatement n, A argu);

   /**
    * <PRE>
    * f0 -> &lt;WHILE&gt;
    * f1 -> Expression(basicBooleanCounter)
    * f2 -> &lt;DO&gt;
    * f3 -> &lt;EOL&gt;
    * f4 -> ( Statement() )*
    * f5 -> &lt;ENDWHILE&gt;
    * f6 -> &lt;EOL&gt;
    * </PRE>
    */
   public R visit(WhileStatement n, A argu);

   /**
    * <PRE>
    * f0 -> &lt;SWITCH&gt;
    * f1 -> &lt;IDENTIFIER&gt;
    * f2 -> &lt;EOL&gt;
    * f3 -> ( &lt;CASE&gt; Expression(DUMMY_CONTAINER) &lt;COLON&gt; ( &lt;EOL&gt; )? ( Statement() )* &lt;ENDCASE&gt; &lt;EOL&gt; )+
    * f4 -> ( &lt;CASE_DEFAULT&gt; &lt;COLON&gt; ( &lt;EOL&gt; )? ( Statement() )* &lt;ENDCASE&gt; &lt;EOL&gt; )?
    * f5 -> &lt;ENDSWITCH&gt;
    * f6 -> &lt;EOL&gt;
    * </PRE>
    */
   public R visit(SwitchStatement n, A argu);

   /**
    * <PRE>
    * f0 -> &lt;FILE&gt;
    * f1 -> ( &lt;OVERWRITE&gt; | &lt;APPEND&gt; )
    * f2 -> ( &lt;STRING_LITERAL&gt; | &lt;IDENTIFIER&gt; )
    * f3 -> Expression(DUMMY_CONTAINER)
    * f4 -> &lt;EOL&gt;
    * </PRE>
    */
   public R visit(FileStatement n, A argu);

   /**
    * <PRE>
    * f0 -> OrExpression(basicBooleanCounter)
    * </PRE>
    */
   public R visit(Expression n, A argu);

   /**
    * <PRE>
    * f0 -> AndExpression(basicBooleanCounter)
    * f1 -> ( &lt;OR&gt; AndExpression(basicBooleanCounter) )*
    * </PRE>
    */
   public R visit(OrExpression n, A argu);

   /**
    * <PRE>
    * f0 -> NotExpression(basicBooleanCounter)
    * f1 -> ( &lt;AND&gt; NotExpression(basicBooleanCounter) )*
    * </PRE>
    */
   public R visit(AndExpression n, A argu);

   /**
    * <PRE>
    * f0 -> ( &lt;NOT&gt; )?
    * f1 -> EqualityExpression(basicBooleanCounter)
    * </PRE>
    */
   public R visit(NotExpression n, A argu);

   /**
    * <PRE>
    * f0 -> RelationalExpression(basicBooleanCounter)
    * f1 -> ( ( &lt;EQ&gt; | &lt;NEQ&gt; ) RelationalExpression(basicBooleanCounter) )?
    * </PRE>
    */
   public R visit(EqualityExpression n, A argu);

   /**
    * <PRE>
    * f0 -> AdditiveExpression(basicBooleanCounter)
    * f1 -> ( ( &lt;LT&gt; | &lt;GT&gt; | &lt;LE&gt; | &lt;GE&gt; ) AdditiveExpression(basicBooleanCounter) )?
    * </PRE>
    */
   public R visit(RelationalExpression n, A argu);

   /**
    * <PRE>
    * f0 -> MultiplicativeExpression(basicBooleanCounter)
    * f1 -> ( ( &lt;PLUS&gt; | &lt;MINUS&gt; ) MultiplicativeExpression(basicBooleanCounter) )*
    * </PRE>
    */
   public R visit(AdditiveExpression n, A argu);

   /**
    * <PRE>
    * f0 -> BasicExpression(basicBooleanCounter)
    * f1 -> ( ( &lt;STAR&gt; | &lt;SLASH&gt; ) BasicExpression(basicBooleanCounter) )*
    * </PRE>
    */
   public R visit(MultiplicativeExpression n, A argu);

   /**
    * <PRE>
    * f0 -> &lt;IDENTIFIER&gt;
    *       | &lt;INTEGER_LITERAL&gt;
    *       | &lt;STRING_LITERAL&gt;
    *       | &lt;TRUE&gt;
    *       | &lt;FALSE&gt;
    *       | &lt;LPAREN&gt; Expression(basicBooleanCounter) &lt;RPAREN&gt;
    * </PRE>
    */
   public R visit(BasicExpression n, A argu);

}
