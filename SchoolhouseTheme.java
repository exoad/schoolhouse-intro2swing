import com.formdev.flatlaf.FlatDarkLaf;

public class SchoolhouseTheme
	extends FlatDarkLaf
{
	public static final String NAME = "SchoolhouseTheme";

	public static boolean setup() {
		return setup( new SchoolhouseTheme() );
	}

	public static void installLafInfo() {
		installLafInfo( NAME, SchoolhouseTheme.class );
	}

	@Override
	public String getName() {
		return NAME;
	}
}
