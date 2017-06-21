package ru.cwasp.demo.rest.resteasy;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.ProxyAuthenticationStrategy;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;

import javax.net.ssl.SSLContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ResteasyClientProxied {

    private static final String PROXY_HOST = "localhost";
    private static final int PROXY_PORT = 808;
    private static final String PROXY_USER = "test";
    private static final String PROXY_PASS = "test";
    private static final String URI = "https://httpbin.org/get";

    public static void main(String[] args) throws Exception {
        final SSLContext sslContext = new org.apache.http.ssl.SSLContextBuilder()
                .loadTrustMaterial(null, (x509CertChain, authType) -> true).build();

        CredentialsProvider credProvider = new BasicCredentialsProvider();
        Credentials credentials = new UsernamePasswordCredentials(PROXY_USER, PROXY_PASS);
        credProvider.setCredentials(new AuthScope(PROXY_HOST, PROXY_PORT), credentials);

        HttpClient httpClient = HttpClientBuilder.create()
                .setProxy(new HttpHost(PROXY_HOST, PROXY_PORT))
                .setDefaultCredentialsProvider(credProvider)
                .setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy())
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .setSSLContext(sslContext)
                .build();

        ApacheHttpClient4Engine engine = new ApacheHttpClient4Engine(httpClient);
        ResteasyClient client = new ResteasyClientBuilder().httpEngine(engine).build();
        ResteasyWebTarget target = client.target(URI);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        System.out.println(response.readEntity(String.class));
        response.close();
    }
}
