package com.example.fitnesstracker;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class HomeFragment extends Fragment {

    // Declare UI components
    private TextView textView;
    private TextView caloriesBurnedText;
    private CardView caloriesCard;
    private TextView caloriesLabel;
    private TextView burnedLabel;
    private Button openBottomSheetButton;  // Button to open the bottom sheet

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize the UI components
        textView = view.findViewById(R.id.text_view);
        caloriesBurnedText = view.findViewById(R.id.calories_burned_text);
        caloriesCard = view.findViewById(R.id.calories_card);
        caloriesLabel = view.findViewById(R.id.calories_label);
        burnedLabel = view.findViewById(R.id.burned_label);
        openBottomSheetButton = view.findViewById(R.id.open_bottom_sheet_button);

        // Set the text or perform any actions needed
        textView.setText("Welcome Kay");
        caloriesBurnedText.setText("You have burned 500 calories in the past 3 weeks");
        caloriesLabel.setText("Calories: 500");
        burnedLabel.setText("Burned: 200");

        setupCardListeners();

        // Set click listener for the openBottomSheetButton
        openBottomSheetButton.setOnClickListener(v -> openBottomSheet());

        return view;  // Return the inflated view
    }

    private void setupCardListeners() {
        // Example of setting up a click listener for the caloriesCard
        caloriesCard.setOnClickListener(v -> {
            // Handle click event for caloriesCard
            // For example, navigate to another fragment or activity
        });


    }

    private void openBottomSheet() {
        // Create a BottomSheetDialog
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        // Inflate the bottom sheet layout
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);

        // Set the view to the dialog
        bottomSheetDialog.setContentView(bottomSheetView);
        // Show the bottom sheet
        bottomSheetDialog.show();
    }
}
