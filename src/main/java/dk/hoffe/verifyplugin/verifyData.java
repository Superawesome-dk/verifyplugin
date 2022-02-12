package dk.hoffe.verifyplugin;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;
import java.util.UUID;

public class verifyData {

    public static Number opretKode(UUID uuid) {
        RequestBody formBody = new FormBody.Builder()
                .add("uuid", String.valueOf(uuid))
                .build();

        Request request = new Request.Builder()
                .url("https://api.whysoshy.dk/api/verify")
                .addHeader("root", "yUy_ivJ.$a7gScfrO;0DVzI'/]KKaAN`GS[=sd2{)#ZQV~w2)6ir/e7m2yov<f;")
                .post(formBody)
                .build();
        OkHttpClient httpClient = new OkHttpClient();
        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            JsonObject json = JsonParser.parseString(response.body().string()).getAsJsonObject();
            System.out.println(json.toString());
            return json.get("code").getAsNumber();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
