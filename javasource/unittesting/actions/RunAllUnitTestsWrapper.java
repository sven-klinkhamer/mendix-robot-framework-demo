// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package unittesting.actions;

import org.apache.commons.lang3.exception.ExceptionUtils;
import unittesting.TestManager;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;

public class RunAllUnitTestsWrapper extends CustomJavaAction<java.lang.Boolean>
{
	/** @deprecated use testRun.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __testRun;
	private final unittesting.proxies.TestSuite testRun;

	public RunAllUnitTestsWrapper(
		IContext context,
		IMendixObject _testRun
	)
	{
		super(context);
		this.__testRun = _testRun;
		this.testRun = _testRun == null ? null : unittesting.proxies.TestSuite.initialize(getContext(), _testRun);
	}

	@java.lang.Override
	public java.lang.Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
		try {
			//Run tests in a new context without transaction!
			TestManager.instance().runTestSuite(Core.createSystemContext(), testRun);
		}
		catch(Exception e) {
			TestManager.LOG.error("An error occurred while trying to run the unit tests: " + ExceptionUtils.getRootCauseMessage(e), e);
			return false;
		}
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "RunAllUnitTestsWrapper";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
