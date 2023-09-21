import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("gay", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher("test gay gay moo moo");
    boolean matchFound = matcher.find();
    if(matchFound) {
      System.out.println("Match found");
    } else {
      System.out.println("Match not found");
    }
  }
}