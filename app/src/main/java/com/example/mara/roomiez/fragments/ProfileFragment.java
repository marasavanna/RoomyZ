package com.example.mara.roomiez.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mara.roomiez.R;
import com.example.mara.roomiez.activities.MainActivity;
import com.example.mara.roomiez.activities.UserDescriptionActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mara on 2/27/2018.
 */

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private ImageView goToProfile, goToWishList, goToMessages;
    private FloatingActionButton logOut;
    private CircleImageView profileImg;

    private FirebaseAuth auth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        auth = FirebaseAuth.getInstance();

        logOut = getActivity().findViewById(R.id.log_out);
        logOut.setOnClickListener(this);

        profileImg = getActivity().findViewById(R.id.user_photo);
        Picasso.with(getContext()).load(auth.getCurrentUser().getPhotoUrl()).into(profileImg);

        goToProfile = getActivity().findViewById(R.id.go_to_profile_arrow);
        goToProfile.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.log_out:{

                //Firebase signOut()
                auth.signOut();

                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
                break;
            }

            case R.id.go_to_profile_arrow:{
                startActivity(new Intent(getActivity(), UserDescriptionActivity.class));
                break;
            }
        }
    }
}
