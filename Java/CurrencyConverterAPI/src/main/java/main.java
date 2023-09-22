import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class main {

    public static void main(String[]args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Currency to convert from: ");
        String convFrom = sc.nextLine();
        System.out.println("Currency to convert to: ");
        String convTo = sc.nextLine();
        System.out.println("Amount: ");
        BigDecimal amount = sc.nextBigDecimal();

        String route = "https://api.exchangerate.host/latest?base=" + convFrom.toUpperCase();

        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder()
                .url(route)
                .get()
                .build();

        Response resp = client.newCall(req).execute();
        String strResponse = resp.body().string();
        JSONObject jsonObj = new JSONObject(strResponse);
        JSONObject ratesObj = jsonObj.getJSONObject("rates");
        BigDecimal rate = ratesObj.getBigDecimal(convTo.toUpperCase());

        BigDecimal result = rate.multiply(amount);
        System.out.println(result);
    }
}
