package automation.constants;

public class CT_UserListScreen {
	public static final String FILTER_BTN = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]";
	public static final String OCCUPATION_DROPDOWN = "//android.widget.ImageView[@content-desc=\"Occupation\"]";
	public static final String BUILDER_OCCUP = "//android.widget.Button[@content-desc=\"Builder\"]"; // not use
	public static final String ELECTRCIAN_OCCUP = "//android.widget.Button[@content-desc=\"Electrician\"]"; // not use
	public static final String CONSTRUCTION_OCCUP = "//android.widget.Button[@content-desc=\"Construction\"]"; // not use
	public static final String CONTRACTOR_OCCUP = "//android.widget.Button[@content-desc=\"Contractor\"]"; // not use
	public static final String BANKER_OCCUP = "//android.widget.Button[@content-desc=\"Banker\"]"; // not use
	public static final String OCCUPATION_OPTION = "//android.widget.Button[@content-desc=\"%s\"]";
	public static final String SHOW_RESULTS = "//android.widget.Button[@content-desc=\"Show results\"]";
	public static final String OCCUPATION_ALL = "//android.view.View[contains(@content-desc, '%s')]";
	public static final String STATUS_DROPDOWN = "//android.widget.ImageView[@content-desc=\"Status\"]";
	public static final String STATUS_OPTION = "//android.widget.Button[@content-desc=\"%s\"]"; // Signup, Registered, Deleted
	public static final String STAUS_ALL = "//android.view.View[contains(@content-desc, '%s')]";
}
