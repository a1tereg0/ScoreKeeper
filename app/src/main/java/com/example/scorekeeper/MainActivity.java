package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText teamAName;
    EditText teamBName;
    Button addScoreTeamA;
    Button addScoreTeamB;
    TextView teamAScore;
    TextView teamBScore;
    Button removeScoreTeamA;
    Button removeScoreTeamB;
    RadioGroup scoresGroup;
    int changeByScore = 1;

    enum ACTIONS {
            ADD_SCORE,
            REMOVE_SCORE
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamAName = findViewById(R.id.view_teamA);
        teamBName = findViewById(R.id.view_teamB);
        addScoreTeamA = findViewById(R.id.button_addScoreTeamA);
        addScoreTeamB = findViewById(R.id.button_addScoreTeamB);
        teamAScore = findViewById(R.id.show_scoreTeamA);
        teamBScore = findViewById(R.id.show_scoreTeamB);
        removeScoreTeamA = findViewById(R.id.button_removeScoreTeamA);
        removeScoreTeamB = findViewById(R.id.button_removeScoreTeamB);
        scoresGroup = findViewById(R.id.radioGroup_score);

        addScoreTeamA.setOnClickListener(v -> performAction(v, ACTIONS.ADD_SCORE));
        addScoreTeamB.setOnClickListener(v -> performAction(v, ACTIONS.ADD_SCORE));
        removeScoreTeamA.setOnClickListener(v -> performAction(v, ACTIONS.REMOVE_SCORE));
        removeScoreTeamB.setOnClickListener(v -> performAction(v, ACTIONS.REMOVE_SCORE));
        scoresGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton_score1) {
                    changeByScore = 1;
                } else if (checkedId == R.id.radioButton_score2) {
                    changeByScore = 2;
                } else if (checkedId == R.id.radioButton_score3) {
                    changeByScore = 3;
                }
            }
        });


    }

    public void performAction(View v, ACTIONS action) {
        int currentScore, newScore;
        switch (action) {
            case ADD_SCORE:
                if (v.getId() == addScoreTeamA.getId()) {
                    currentScore = Integer.parseInt(teamAScore.getText().toString());
                    newScore = currentScore+ changeByScore;
                    teamAScore.setText(String.valueOf(newScore));
                } else if (v.getId() == addScoreTeamB.getId()) {
                    currentScore = Integer.parseInt(teamBScore.getText().toString());
                    newScore = currentScore + changeByScore;
                    teamBScore.setText(String.valueOf(newScore));
                }
                break;
            case REMOVE_SCORE:
                if (v.getId() == removeScoreTeamA.getId()) {
                    currentScore = Integer.parseInt(teamAScore.getText().toString());
                    newScore = currentScore - changeByScore;
                    if (newScore < 0) newScore = 0;
                    teamAScore.setText(String.valueOf(newScore));
                } else if (v.getId() == removeScoreTeamB.getId()) {
                    currentScore = Integer.parseInt(teamBScore.getText().toString());
                    newScore = currentScore - changeByScore;
                    if (newScore < 0) newScore = 0;
                    teamBScore.setText(String.valueOf(newScore));
                }
        }


    }

}