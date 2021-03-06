package de.fzi.dbs.verification.addon.datatype.facet;

import com.sun.codemodel.JAssignmentTarget;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JStatement;
import com.sun.codemodel.JDefinedClass;
import com.sun.msv.datatype.DatabindableDatatype;
import com.sun.msv.datatype.xsd.DataTypeWithFacet;
import com.sun.msv.datatype.xsd.XSDatatype;
import de.fzi.dbs.verification.addon.datatype.AbstractVC;
import de.fzi.dbs.verification.addon.datatype.VerificatorConstructor;
import de.fzi.dbs.verification.addon.datatype.VerificatorConstructorFactory;

/**
 * Base VC for datatypes with facets.
 *
 * @author Aleksei Valikov
 */
public abstract class DataTypeWithFacetVC extends AbstractVC
{
  public JStatement verify(final DatabindableDatatype datatype, final JCodeModel codeModel, final JDefinedClass theClass, final JExpression value, final JAssignmentTarget problem)
  {
    final JBlock block = newBlock();
    final DataTypeWithFacet dataTypeWithFacet = (DataTypeWithFacet) datatype;
    final XSDatatype baseType = dataTypeWithFacet.baseType;
    final VerificatorConstructor vc = VerificatorConstructorFactory.getVerificatorConstructor(baseType);
    block.add(vc.verify(baseType, codeModel, theClass, value, problem));
    block.add(diagnoseByFacet(dataTypeWithFacet, codeModel, theClass, value, problem));
    return block;
  }

  /**
   * Diagnose the value by facet.
   *
   * @param datatype  datatype.
   * @param codeModel code model.
   * @param theClass
   * @param value     value.
   * @param problem   problem variable.
   * @return Facet verification statement.
   */
  public abstract JStatement diagnoseByFacet(DataTypeWithFacet datatype, JCodeModel codeModel, JDefinedClass theClass, JExpression value, JAssignmentTarget problem);

  public JExpression create(final DatabindableDatatype datatype, final JCodeModel codeModel, final Object object)
  {
    final DataTypeWithFacet dataTypeWithFacet = (DataTypeWithFacet) datatype;
    final XSDatatype baseType = dataTypeWithFacet.baseType;
    final VerificatorConstructor vc = VerificatorConstructorFactory.getVerificatorConstructor(baseType);
    return vc.create(baseType, codeModel, object);
  }
}
