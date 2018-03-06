package com.example.mara.roomiez.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mara.roomiez.R;
import com.example.mara.roomiez.adapters.SlideAdapter;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_GOOGLE = 1;
    private ViewPager viewPager;
    private LinearLayout dots;
    private SlideAdapter adapter;
    private TextView[] myDots;
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private FirebaseAuth auth;
    private GoogleSignInClient googleSignInClient;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.slide_view_pager);
        dots = findViewById(R.id.dots);


        auth = FirebaseAuth.getInstance();
        googleSignIn();
        callbackManager = CallbackManager.Factory.create();

        //Facebook signOut()
        LoginManager.getInstance().logOut();
        //Google signOut()
        googleSignInClient.signOut();

        adapter = new SlideAdapter(this, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        startActivityForResult(googleSignInClient.getSignInIntent(), 1);
                    }
                });

            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginWithFacebook();
            }
        });

        viewPager.setAdapter(adapter);

        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);

        if(auth.getCurrentUser() != null) {
            startActivity(new Intent(this, TabNavigationActivity.class));
            finish();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            switch (requestCode){
                case REQUEST_CODE_GOOGLE: {
                    GoogleSignInResult res = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                    if(res.isSuccess()){
                        AuthCredential credential = GoogleAuthProvider.getCredential(res.getSignInAccount().getIdToken(), null);
                        auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                        startActivity(new Intent(MainActivity.this, TabNavigationActivity.class));
                                        finish();
                                }else{
                                    Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                    break;
                }
                default:
                    callbackManager.onActivityResult(requestCode, resultCode, data);
            }
    }

    public void googleSignIn(){

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);

    }

    private void loginWithFacebook() {
        LoginManager loginFacebook = LoginManager.getInstance();
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "user_photos", "public_profile"));
        loginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookAccessToken(loginResult.getAccessToken());

            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException error) {
            }
        });
    }

    public void addDotsIndicator(int position) {

        dots.removeAllViews();

        myDots = new TextView[3];

        dots.removeAllViews();
        myDots = new TextView[3];

        for (int i = 0; i < myDots.length; i++) {
            myDots[i] = new TextView(this);
            myDots[i].setText(Html.fromHtml("&#8226;"));
            myDots[i].setTextSize(35);
            myDots[i].setTextColor(getResources().getColor(R.color.transparentWhite));

            dots.addView(myDots[i]);
        }

        if (myDots.length > 0) {
            myDots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }

    private void handleFacebookAccessToken(AccessToken token) {
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                                startActivity(new Intent(MainActivity.this, TabNavigationActivity.class));
                                finish();
                        } else {
                            Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}
