package com.stechtricker.scimastercalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.stechtricker.scimastercalculator.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    ImageView btmnav;
    RelativeLayout home, contact;
    CardView cal1, cal2, cal3, cal4, cal5, cal6, cal7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bottom dialog
        btmnav = findViewById(R.id.bottom_nav);
        btmnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });

        cal1 = findViewById(R.id.cal1);
        cal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NormalCalculator.class);
                startActivity(i);
            }
        });

        cal2 = findViewById(R.id.cal2);
        cal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, BMICalculator.class);
                startActivity(i);
            }
        });

        cal3 = findViewById(R.id.cal3);
        cal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AgeCalculator.class);
                startActivity(i);
            }
        });

        cal4 = findViewById(R.id.cal4);
        cal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DiscountCalculator.class);
                startActivity(i);
            }
        });

        cal5 = findViewById(R.id.cal5);
        cal5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ScientificCalculator.class);
                startActivity(i);
            }
        });

        cal6 = findViewById(R.id.cal6);
        cal6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EMICalculator.class);
                startActivity(i);
            }
        });

        cal7 = findViewById(R.id.cal7);
        cal7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PercentageCalculator.class);
                startActivity(i);
            }
        });

        // Bottom navigation setup
        home = findViewById(R.id.home);
        contact = findViewById(R.id.contact);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent(MainActivity.this, Contact.class);
                startActivity(g);
            }
        });
    }

    // BottomSheet implementation
    private void showBottomSheetDialog() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_layout);

        LinearLayout share = bottomSheetDialog.findViewById(R.id.share);
        LinearLayout rating = bottomSheetDialog.findViewById(R.id.rating);
        LinearLayout contact = bottomSheetDialog.findViewById(R.id.contact);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Share intent
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Check out SciMasterCalculator app!");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Download SciMasterCalculator app from the Play Store: https://play.google.com/store/apps/details?id=com.stechtricker.scimastercalculator");
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Play Store for rating
                Intent ratingIntent = new Intent(Intent.ACTION_VIEW);
                ratingIntent.setData(Uri.parse("market://details?id=com.stechtricker.scimastercalculator"));
                try {
                    startActivity(ratingIntent);
                } catch (android.content.ActivityNotFoundException anfe) {
                    // Fallback to using the web URL if Play Store is not available
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.stechtricker.scimastercalculator")));
                }
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Play Store for update
                Intent updateIntent = new Intent(Intent.ACTION_VIEW);
                updateIntent.setData(Uri.parse("market://details?id=com.stechtricker.scimastercalculator"));
                try {
                    startActivity(updateIntent);
                } catch (android.content.ActivityNotFoundException anfe) {
                    // Fallback to using the web URL if Play Store is not available
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.stechtricker.scimastercalculator")));
                }
            }
        });

        bottomSheetDialog.show();
    }
}
