package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView storyTextView;
    private Button buttonTop;
    private Button buttonBottom;
    private int currStory = R.string.T1_Story;
    private int currTop = R.string.T1_Ans1;
    private int currBottom = R.string.T1_Ans2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = (TextView) findViewById(R.id.storyTextView);
        buttonTop = (Button) findViewById(R.id.buttonTop);
        buttonBottom = (Button) findViewById(R.id.buttonBottom);

        if (savedInstanceState != null) {
            currStory = savedInstanceState.getInt("StoryKey");
            currTop = savedInstanceState.getInt("TopKey");
            currBottom = savedInstanceState.getInt("BottomKey");
            if (currStory == R.string.T6_End || currStory == R.string.T5_End || currStory == R.string.T4_End) {
                buttonTop.setVisibility(View.GONE);
                buttonBottom.setVisibility(View.GONE);
            } else {
                buttonTop.setText(currTop);
                buttonBottom.setText(currBottom);
            }
            storyTextView.setText(currStory);

        }
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currStory == R.string.T1_Story || currStory == R.string.T2_Story) {
                    currStory = R.string.T3_Story;
                    currTop = R.string.T3_Ans1;
                    currBottom = R.string.T3_Ans2;
                    storyTextView.setText(currStory);
                    buttonTop.setText(currTop);
                    buttonBottom.setText(currBottom);
                } else if (currStory == R.string.T3_Story) {
                    currStory = R.string.T6_End;
                    storyTextView.setText(currStory);
                    buttonTop.setVisibility(View.GONE);
                    buttonBottom.setVisibility(View.GONE);
                }
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currStory == R.string.T1_Story) {
                    currStory = R.string.T2_Story;
                    currTop = R.string.T2_Ans1;
                    currBottom = R.string.T2_Ans2;
                    storyTextView.setText(currStory);
                    buttonTop.setText(currTop);
                    buttonBottom.setText(currBottom);
                } else if (currStory == R.string.T3_Story) {
                    currStory = R.string.T5_End;
                    storyTextView.setText(currStory);
                    buttonTop.setVisibility(View.GONE);
                    buttonBottom.setVisibility(View.GONE);
                } else if (currStory == R.string.T2_Story) {
                    currStory = R.string.T4_End;
                    storyTextView.setText(currStory);
                    buttonTop.setVisibility(View.GONE);
                    buttonBottom.setVisibility(View.GONE);
                }
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryKey", currStory);
        outState.putInt("TopKey", currTop);
        outState.putInt("BottomKey", currBottom);
    }
}
