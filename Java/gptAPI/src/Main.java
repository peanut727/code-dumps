import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    private static final String API_KEY = "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"; // Store your API key securely

    public static void main(String[] args) {
        String response = chatGPT("hello, how are you?");
        System.out.println("Response: " + response);
    }

    public static String chatGPT(String message) {
        String url = "https://api.openai.com/v1/chat/completions";
        String model = "gpt-3.5-turbo";

        try {
            // Create the HTTP POST request
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setRequestProperty("Content-Type", "application/json");

            // Build the request body using JSON serialization
            String jsonBody = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}]}";

            // Send the request
            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Get the response
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                return extractContentFromResponse(response.toString());
            } catch (IOException e) {
                // Handle response reading error
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }
        } catch (IOException e) {
            // Handle connection setup error
            e.printStackTrace();
        }
        return null;
    }

    // This method extracts the response expected from chatgpt and returns it.
    public static String extractContentFromResponse(String response) {
        // Implement a safer and more robust way to extract content from the JSON response.
        // You can use a JSON parsing library for this purpose.
        // Example: return parsedJsonObject.getString("content");
        return "Extracted Content"; // Replace with the actual parsing logic
    }
}
