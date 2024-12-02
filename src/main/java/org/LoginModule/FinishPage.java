package org.LoginModule;

import org.LibraryFiles.BaseClass;
import org.jspecify.annotations.Nullable;

public class FinishPage extends BaseClass
{
	public String getCurrentURLFinishPage()
	{
		
		String actualURL = driver.getCurrentUrl();
		return actualURL;
	}
	

}
