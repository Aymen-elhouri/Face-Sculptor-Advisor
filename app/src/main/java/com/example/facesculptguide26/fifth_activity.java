package com.example.facesculptguide26;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.concurrent.TimeUnit;

public class fifth_activity extends AppCompatActivity  {


    private AdView mAdView;
    private AdView mAdView2;
    private int retryAttempt;
    private int currentImageResource;
    private String currentText;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTheme(R.style.Theme_MobiOptionsGuideApp);
        setContentView(R.layout.activity_fifth);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        mAdView2 = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView2.loadAd(adRequest);





        // Define buttons and set onClick listeners
        // Example for button1
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(v -> {
            String buttonText = getString(R.string.Tip1);
            loadInterstitialAd();
            navigateToActivity(R.drawable.btn1, buttonText);
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            String buttonText = getString(R.string.Tip2);
            loadInterstitialAd();
            navigateToActivity(R.drawable.btn2, buttonText);
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(v -> {
            String buttonText = getString(R.string.Tip3);
            loadInterstitialAd();
            navigateToActivity(R.drawable.btn3, buttonText);
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(v -> {
            String buttonText = getString(R.string.Tip4);
            loadInterstitialAd();
            navigateToActivity(R.drawable.btn4, buttonText);
        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(v -> {
            String buttonText = getString(R.string.Tip5);
            loadInterstitialAd();
            navigateToActivity(R.drawable.btn5, buttonText);
        });

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(v -> {
            String buttonText = getString(R.string.Tip6);
            loadInterstitialAd();
            navigateToActivity(R.drawable.btn6, buttonText);
        });

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(v -> {
            String buttonText = getString(R.string.Tip7);
            loadInterstitialAd();
            navigateToActivity(R.drawable.btn7, buttonText);
        });

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(v -> {
            String buttonText = getString(R.string.Tip8);
            loadInterstitialAd();
            navigateToActivity(R.drawable.btn8, buttonText);
        });

        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(v -> {
            String buttonText = getString(R.string.Tip9);
            loadInterstitialAd();
            navigateToActivity(R.drawable.btn9, buttonText);
        });

        Button button10 = findViewById(R.id.button10);
        button10.setOnClickListener(v -> {
            String buttonText = getString(R.string.Tip10);
            loadInterstitialAd();
            navigateToActivity(R.drawable.btn10, buttonText);
        });

    }

    ///InterstitialAd:
    private void loadInterstitialAd() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, "ca-app-pub-5729388434628876/9906376262", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                        showInterstitialAd();
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });
    }

    private void showInterstitialAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);
        } else {
            // The ad wasn't loaded yet, handle accordingly
        }
    }////////InterstitialAd


    private void navigateToActivity(int imageResource, String text) {
        currentImageResource = imageResource;
        currentText = text;

            startDetailActivity(imageResource, text);

    }

    private void startDetailActivity(int imageResource, String text) {
        Intent intent = new Intent(this, Forth_activity.class);
        intent.putExtra("imageResource", imageResource);
        intent.putExtra("text", text);
        startActivity(intent);
    }




}