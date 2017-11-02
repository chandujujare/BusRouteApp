package com.busrouteapp.busroutes.model;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by chandrasekharrao.j on 02-11-2017.
 */

public class RestClient {

    private OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private Retrofit.Builder builder;
    private static Retrofit retrofit;
    private static RestClient mInstance = new RestClient();

    public static void configure(String baseUrl) {
        mInstance.builder = new Retrofit.Builder().baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create());
        mInstance.httpClient.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static <S> S createService(Class<S> serviceClass) {

        if (mInstance.builder == null) {
            throw new RuntimeException("Rest client is not configured. Please configure first before any call");
        }
        Retrofit retro = mInstance.builder.client(mInstance.httpClient.build()).build();
        retrofit = retro;
        return retro.create(serviceClass);
    }


}
