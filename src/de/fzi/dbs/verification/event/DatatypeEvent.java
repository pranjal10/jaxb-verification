package de.fzi.dbs.verification.event;

import de.fzi.dbs.verification.problem.Problem;

/**
 * Datatype event describes a problem with data.
 *
 * @author Aleksei Valikov
 */
public class DatatypeEvent extends VerificationEvent
{
  /**
   * Constructs a new datatype event.
   *
   * @param locator locator (where).
   * @param problem problem (what).
   */
  public DatatypeEvent(final VerificationEventLocator locator, final Problem problem)
  {
    super(locator, problem);
  }

  public String getMessage()
  {
    // todo
    return "todo";
  }
}
