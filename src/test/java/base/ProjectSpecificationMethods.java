package base;

import utils.Utility;

public class ProjectSpecificationMethods extends Utility{
	
	public void browserLaunchAndUrlLoad(String browser,String url) {
		
		launchBrowserAndLoadUrl(browser,url);
	}
	
	public void closeBrowser() {
		
		browserClose();
	}
	

}
