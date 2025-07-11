package com.BC.SzakGyak;

import com.twilio.Twilio;
import com.twilio.http.NetworkHttpClient;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.HttpClientBuilder;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class WhatsAppSender {

    public static final String ACCOUNT_SID = "AC18668f10cf413def84ff762579e51b14";
    public static final String AUTH_TOKEN = "d27f34b6ea2313d32df3aa7734dbeae7";


    public static void sendMessage(String to, String text) {
        // Proxy beállítása
        HttpHost proxy = new HttpHost("kaz0vlpx05ContGW.emea.whchem.com", 8080, "http");
        HttpClientBuilder clientBuilder = HttpClientBuilder.create().setProxy(proxy);
        NetworkHttpClient httpClient = new NetworkHttpClient(clientBuilder);

        // Twilio kliens létrehozása proxyval
        TwilioRestClient client = new TwilioRestClient.Builder(ACCOUNT_SID, AUTH_TOKEN)
                .httpClient(httpClient)
                .build();

        // Üzenet küldése
        Message message = Message.creator(
                new PhoneNumber("whatsapp:" + to),
                new PhoneNumber("whatsapp:+14155238886"),
                text
        ).create(client);

        System.out.println("Message SID: " + message.getSid());
    }
}
