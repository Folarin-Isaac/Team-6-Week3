package com.example.talku_talku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class OnboardingScreen extends AppCompatActivity {
    private OnboardingAdapter onboardingAdapter;
    private ImageButton button;
    private LinearLayout layoutOnboardingIndicators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_screen);
        button = findViewById(R.id.next_button);
        layoutOnboardingIndicators = findViewById(R.id.layoutOnboardingIndicators);

        // next button to open the welcome activity when clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnboardingScreen.this, WelcomeScreen.class);
                startActivity(intent);
            }
        });

        setUpOnboardingItem();
        setUpOnboardingIndicators();
        setCurrentOnboardingIndicators(0);

        ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicators(position);
            }
        });


    }

    // Onboarding data to be displayed in each slide
    private void setUpOnboardingItem(){
        List<OnboardingItem> onboardingItems = new ArrayList<>();

        // first onboard screen details
        OnboardingItem firstOnboard = new OnboardingItem();
        firstOnboard.setTitle("Learn anywhere, anytime");
        firstOnboard.setDescription("Learn languages across all devices, pc, tablets and mobiles phone, anywhere and anytime.");
        firstOnboard.setImage(R.drawable.fist_onboard);

        // second onboard screen details
        OnboardingItem secondOnboard = new OnboardingItem();
        secondOnboard.setTitle("Learn in a Personalised way");
        secondOnboard.setDescription("Learning with Talku-talku you personalised your learning, to your desires.");
        secondOnboard.setImage(R.drawable.second_onboard);

        // third onboard screen details
        OnboardingItem thirdOnboard = new OnboardingItem();
        thirdOnboard.setTitle("Improve Quickly");
        thirdOnboard.setDescription("Learning with Talku-talku makes you learn faster and efficiently with in weeks.");
        thirdOnboard.setImage(R.drawable.third_onboard);

        onboardingItems.add(firstOnboard);
        onboardingItems.add(secondOnboard);
        onboardingItems.add(thirdOnboard);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);
    }

    private void setUpOnboardingIndicators(){
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(8,0,8,0);
        for (int i = 0; i < indicators.length; i++){
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                    R.drawable.onboarding_inactive));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicators.addView(indicators[i]);

        }
}
private void setCurrentOnboardingIndicators(int index){
    int childCount = layoutOnboardingIndicators.getChildCount();
    for (int i = 0; i < childCount; i++){
        ImageView imageView = (ImageView)layoutOnboardingIndicators.getChildAt(i);
        if (i == index){
            imageView.setImageDrawable(
                    ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_active)
            );
        }else {
            imageView.setImageDrawable(
                    ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_inactive)
            );
        }
    }



}
}