package de.fzi.dbs.verification.addon.datatype.atomic.binary;

import com.sun.codemodel.JAssignmentTarget;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JStatement;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JArray;
import com.sun.msv.datatype.DatabindableDatatype;
import de.fzi.dbs.verification.addon.datatype.AbstractVC;
import de.fzi.dbs.verification.addon.datatype.DiscreteVC;

/**
 * Base VC for binary types.
 *
 * @author Aleksei Valikov
 */
public abstract class BinaryBaseTypeVC extends AbstractVC implements DiscreteVC
{
  public JStatement verify(final DatabindableDatatype datatype, final JCodeModel codeModel, final JDefinedClass theClass, final JExpression value, final JAssignmentTarget problem)
  {
    final JBlock block = newBlock();
    return block;
  }

  public JExpression countLength(final JCodeModel codeModel, final JExpression value)
  {
    return value.ref("length");
  }

  public JExpression create(final DatabindableDatatype datatype, final JCodeModel codeModel, final Object object)
  {
    final JArray array = JExpr.newArray(codeModel.BYTE);
    final byte[] bytes = (byte[]) object;
    for (int index = 0; index < bytes.length; index++)
    {
      array.add(JExpr.lit(bytes[index]));
    }
    return array;
  }
}
