package com.example.android.aiquiz;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("WrongConstant")
public class MainActivity extends AppCompatActivity {

    static final String STATE_TEXT_REQUEST_NAME_TEXT = "STATE_TEXT_REQUEST_NAME_TEXT";
    static final String STATE_TEXT_DISPLAY_NAME_VISIBILITY = "STATE_TEXT_DISPLAY_NAME_VISIBILITY";
    static final String STATE_EDIT_PLAYER_NAME_VISIBILITY = "STATE_EDIT_PLAYER_NAME_VISIBILITY";
    static final String STATE_EDIT_PLAYER_NAME = "STATE_EDIT_PLAYER_NAME";
    static final String STATE_PLAYER_NAME = "STATE_PLAYER_NAME";
    static final String STATE_BUTTON_SAVE_EDIT_PLAYER_NAME = "STATE_BUTTON_SAVE_EDIT_PLAYER_NAME";
    static final String STATE_PLAYER_NAME_IS_VALIDATED = "STATE_PLAYER_NAME_IS_VALIDATED";
    static final String STATE_TEXT_DISPLAY_ANSWER_7_VISIBILITY = "STATE_TEXT_DISPLAY_ANSWER_7_VISIBILITY";
    static final String STATE_EDIT_Q7_INPUT_VISIBILITY = "STATE_EDIT_Q7_INPUT_VISIBILITY";
    static final String STATE_EDIT_Q7_INPUT = "STATE_EDIT_Q7_INPUT";
    static final String STATE_ANSWER_Q7 = "STATE_ANSWER_Q7";
    static final String STATE_BUTTON_SAVE_EDIT_ANSWER_7 = "STATE_BUTTON_SAVE_EDIT_ANSWER_7";
    static final String STATE_Q7_IS_ANSWERED  = "STATE_Q7_IS_ANSWERED";
    static final String STATE_TEXT_DISPLAY_ANSWER_9_VISIBILITY = "STATE_TEXT_DISPLAY_ANSWER_9_VISIBILITY";
    static final String STATE_EDIT_Q9_INPUT_VISIBILITY = "STATE_EDIT_Q9_INPUT_VISIBILITY";
    static final String STATE_EDIT_Q9_INPUT = "STATE_EDIT_Q9_INPUT";
    static final String STATE_ANSWER_Q9 = "STATE_ANSWER_Q9";
    static final String STATE_BUTTON_SAVE_EDIT_ANSWER_9 = "STATE_BUTTON_SAVE_EDIT_ANSWER_9";
    static final String STATE_Q9_IS_ANSWERED  = "STATE_Q9_IS_ANSWERED";
    private ScrollView scrollViewRoot;
    private CheckBox q1aA;
    private CheckBox q1aB;
    private CheckBox q1aC;
    private CheckBox q1aD;
    private CheckBox q2aA;
    private CheckBox q2aB;
    private CheckBox q2aC;
    private CheckBox q2aD;
    private CheckBox q8aA;
    private CheckBox q8aB;
    private CheckBox q8aC;
    private CheckBox q8aD;
    private RadioButton q3aA;
    private RadioButton q3aB;
    private RadioButton q3aC;
    private RadioButton q3aD;
    private RadioButton q4aA;
    private RadioButton q4aB;
    private RadioButton q4aC;
    private RadioButton q4aD;
    private RadioButton q5aA;
    private RadioButton q5aB;
    private RadioButton q5aC;
    private RadioButton q5aD;
    private RadioButton q6aA;
    private RadioButton q6aB;
    private RadioButton q6aC;
    private RadioButton q6aD;
    private RadioButton q10aA;
    private RadioButton q10aB;
    private RadioButton q10aC;
    private RadioButton q10aD;
    private RadioGroup q3ABCD;
    private RadioGroup q4ABCD;
    private RadioGroup q5ABCD;
    private RadioGroup q6ABCD;
    private RadioGroup q10ABCD;
    private EditText editPlayerName;
    private EditText editQ7Input;
    private EditText editQ9Input;
    private TextView textRequestPlayerName;
    private TextView textDisplayPlayerName;
    private TextView textDisplayAnswer7;
    private TextView textDisplayAnswer9;
    private Button buttonSaveEditPlayerName;
    private Button buttonSaveEditAnswer7;
    private Button buttonSaveEditAnswer9;
    private String playerName;
    private String answerQ7;
    private String answerQ9;
    private String levelReached;
    private String resultsToastComment;
    private String resultsToastMessage;
    private int scoreQ1 = 0;
    private int scoreQ2 = 0;
    private int scoreQ3 = 0;
    private int scoreQ4 = 0;
    private int scoreQ5 = 0;
    private int scoreQ6 = 0;
    private int scoreQ7 = 0;
    private int scoreQ8 = 0;
    private int scoreQ9 = 0;
    private int scoreQ10 = 0;
    private int totalScore = 0;
    private Boolean playerNameIsValidated = false;
    private Boolean q1IsAnswered = false;
    private Boolean q2IsAnswered = false;
    private Boolean q3IsAnswered = false;
    private Boolean q4IsAnswered = false;
    private Boolean q5IsAnswered = false;
    private Boolean q6IsAnswered = false;
    private Boolean q8IsAnswered = false;
    private Boolean q10IsAnswered = false;
    private Boolean answerQ7IsValidated = false;
    private Boolean answerQ9IsValidated = false;
    private Boolean quizIsCompleted = false;

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putString(STATE_TEXT_REQUEST_NAME_TEXT, textRequestPlayerName.getText().toString());
        outState.putInt(STATE_TEXT_DISPLAY_NAME_VISIBILITY, textDisplayPlayerName.getVisibility());
        outState.putInt(STATE_EDIT_PLAYER_NAME_VISIBILITY, editPlayerName.getVisibility());
        outState.putString(STATE_EDIT_PLAYER_NAME, editPlayerName.getText().toString());
        outState.putString(STATE_PLAYER_NAME, playerName);
        outState.putString(STATE_BUTTON_SAVE_EDIT_PLAYER_NAME, buttonSaveEditPlayerName.getText().toString());
        outState.putBoolean(STATE_PLAYER_NAME_IS_VALIDATED, playerNameIsValidated);

        outState.putInt(STATE_TEXT_DISPLAY_ANSWER_7_VISIBILITY, textDisplayAnswer7.getVisibility());
        outState.putInt(STATE_EDIT_Q7_INPUT_VISIBILITY, editQ7Input.getVisibility());
        outState.putString(STATE_EDIT_Q7_INPUT, editQ7Input.getText().toString());
        outState.putString(STATE_ANSWER_Q7, answerQ7);
        outState.putString(STATE_BUTTON_SAVE_EDIT_ANSWER_7, buttonSaveEditAnswer7.getText().toString());
        outState.putBoolean(STATE_Q7_IS_ANSWERED, answerQ7IsValidated);

        outState.putInt(STATE_TEXT_DISPLAY_ANSWER_9_VISIBILITY, textDisplayAnswer9.getVisibility());
        outState.putInt(STATE_EDIT_Q9_INPUT_VISIBILITY, editQ9Input.getVisibility());
        outState.putString(STATE_EDIT_Q9_INPUT, editQ9Input.getText().toString());
        outState.putString(STATE_ANSWER_Q9, answerQ9);
        outState.putString(STATE_BUTTON_SAVE_EDIT_ANSWER_9, buttonSaveEditAnswer9.getText().toString());
        outState.putBoolean(STATE_Q9_IS_ANSWERED, answerQ9IsValidated);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollViewRoot = (ScrollView) findViewById(R.id.scroll_view_root);

        q1aA = (CheckBox) findViewById(R.id.q1aA);
        q1aB = (CheckBox) findViewById(R.id.q1aB);
        q1aC = (CheckBox) findViewById(R.id.q1aC);
        q1aD = (CheckBox) findViewById(R.id.q1aD);
        q2aA = (CheckBox) findViewById(R.id.q2aA);
        q2aB = (CheckBox) findViewById(R.id.q2aB);
        q2aC = (CheckBox) findViewById(R.id.q2aC);
        q2aD = (CheckBox) findViewById(R.id.q2aD);
        q8aA = (CheckBox) findViewById(R.id.q8aA);
        q8aB = (CheckBox) findViewById(R.id.q8aB);
        q8aC = (CheckBox) findViewById(R.id.q8aC);
        q8aD = (CheckBox) findViewById(R.id.q8aD);

        q3aA = (RadioButton) findViewById(R.id.q3aA);
        q3aB = (RadioButton) findViewById(R.id.q3aB);
        q3aC = (RadioButton) findViewById(R.id.q3aC);
        q3aD = (RadioButton) findViewById(R.id.q3aD);
        q4aA = (RadioButton) findViewById(R.id.q4aA);
        q4aB = (RadioButton) findViewById(R.id.q4aB);
        q4aC = (RadioButton) findViewById(R.id.q4aC);
        q4aD = (RadioButton) findViewById(R.id.q4aD);
        q5aA = (RadioButton) findViewById(R.id.q5aA);
        q5aB = (RadioButton) findViewById(R.id.q5aB);
        q5aC = (RadioButton) findViewById(R.id.q5aC);
        q5aD = (RadioButton) findViewById(R.id.q5aD);
        q6aA = (RadioButton) findViewById(R.id.q6aA);
        q6aB = (RadioButton) findViewById(R.id.q6aB);
        q6aC = (RadioButton) findViewById(R.id.q6aC);
        q6aD = (RadioButton) findViewById(R.id.q6aD);
        q10aA = (RadioButton) findViewById(R.id.q10aA);
        q10aB = (RadioButton) findViewById(R.id.q10aB);
        q10aC = (RadioButton) findViewById(R.id.q10aC);
        q10aD = (RadioButton) findViewById(R.id.q10aD);

        q3ABCD = (RadioGroup) findViewById(R.id.q3ABCD);
        q4ABCD = (RadioGroup) findViewById(R.id.q4ABCD);
        q5ABCD = (RadioGroup) findViewById(R.id.q5ABCD);
        q6ABCD = (RadioGroup) findViewById(R.id.q6ABCD);
        q10ABCD = (RadioGroup) findViewById(R.id.q10ABCD);

        editQ7Input = (EditText) findViewById(R.id.edit_Q7_input);
        editQ9Input = (EditText) findViewById(R.id.edit_Q9_input);
        editPlayerName = (EditText) findViewById(R.id.edit_player_name);

        textRequestPlayerName = (TextView) findViewById(R.id.text_request_player_name);
        textDisplayPlayerName = (TextView) findViewById(R.id.text_display_player_name);
        textDisplayAnswer7 = (TextView) findViewById(R.id.text_display_answer_7);
        textDisplayAnswer9 = (TextView) findViewById(R.id.text_display_answer_9);

        buttonSaveEditPlayerName = (Button) findViewById(R.id.button_save_edit_player_name);
        buttonSaveEditAnswer7 = (Button) findViewById(R.id.button_save_edit_answer_7);
        buttonSaveEditAnswer9 = (Button) findViewById(R.id.button_save_edit_answer_9);

        if (savedInstanceState != null) {
            playerName = savedInstanceState.getString(STATE_PLAYER_NAME);
            textRequestPlayerName.setText(savedInstanceState.getString(STATE_TEXT_REQUEST_NAME_TEXT));
            textDisplayPlayerName.setVisibility(savedInstanceState.getInt(STATE_TEXT_DISPLAY_NAME_VISIBILITY));
            textDisplayPlayerName.setText(playerName);
            editPlayerName.setVisibility(savedInstanceState.getInt(STATE_EDIT_PLAYER_NAME_VISIBILITY));
            editPlayerName.setText(savedInstanceState.getString(STATE_EDIT_PLAYER_NAME));
            buttonSaveEditPlayerName.setText(savedInstanceState.getString(STATE_BUTTON_SAVE_EDIT_PLAYER_NAME));
            playerNameIsValidated = savedInstanceState.getBoolean(STATE_PLAYER_NAME_IS_VALIDATED);

            answerQ7 = savedInstanceState.getString(STATE_ANSWER_Q7);
            textDisplayAnswer7.setVisibility(savedInstanceState.getInt(STATE_TEXT_DISPLAY_ANSWER_7_VISIBILITY));
            textDisplayAnswer7.setText(answerQ7);
            editQ7Input.setVisibility(savedInstanceState.getInt(STATE_EDIT_Q7_INPUT_VISIBILITY));
            editQ7Input.setText(savedInstanceState.getString(STATE_EDIT_Q7_INPUT));
            buttonSaveEditAnswer7.setText(savedInstanceState.getString(STATE_BUTTON_SAVE_EDIT_ANSWER_7));
            answerQ7IsValidated = savedInstanceState.getBoolean(STATE_Q7_IS_ANSWERED);

            answerQ9 = savedInstanceState.getString(STATE_ANSWER_Q9);
            textDisplayAnswer9.setVisibility(savedInstanceState.getInt(STATE_TEXT_DISPLAY_ANSWER_9_VISIBILITY));
            textDisplayAnswer9.setText(answerQ9);
            editQ9Input.setVisibility(savedInstanceState.getInt(STATE_EDIT_Q9_INPUT_VISIBILITY));
            editQ9Input.setText(savedInstanceState.getString(STATE_EDIT_Q9_INPUT));
            buttonSaveEditAnswer9.setText(savedInstanceState.getString(STATE_BUTTON_SAVE_EDIT_ANSWER_9));
            answerQ9IsValidated = savedInstanceState.getBoolean(STATE_Q9_IS_ANSWERED);
        }
    }
    /**
     * This method gets the user to the bottom of the scrollview to quickly access the submit button
     */
    public void jump_to_submit(View view) {
        scrollViewRoot.fullScroll(ScrollView.FOCUS_DOWN);
    }
    /**
     * This method is called when the 'save / edit' button for the player's name is clicked
     */
    public void save_edit_name(View view) {
        if (textDisplayPlayerName.getVisibility() == View.GONE) {
            playerNameIsValidated = true;
            textRequestPlayerName.setText(R.string.player_name_is);
            editPlayerName.setVisibility(View.GONE);
            getPlayerName();
            textDisplayPlayerName.setText(playerName);
            textDisplayPlayerName.setVisibility(View.VISIBLE);
            buttonSaveEditPlayerName.setText(R.string.edit_player_name);
        }
        else if (textDisplayPlayerName.getVisibility() == View.VISIBLE) {
            playerNameIsValidated = false;
            textRequestPlayerName.setText(R.string.player_name_request);
            editPlayerName.setVisibility(View.VISIBLE);
            textDisplayPlayerName.setVisibility(View.GONE);
            buttonSaveEditPlayerName.setText(R.string.save_player_name);
        }
    }
    /**
     * This method is called when the 'save / edit' button for the answer of question 7 is clicked
     */
    public void save_edit_answer_7(View view) {
        if (textDisplayAnswer7.getVisibility() == View.GONE) {
            getAnswerQuestion7();
            if (getAnswerQuestion7().equals("")) {
                displayToast("error", getResources().getString(R.string.missing_answer_error_message));
            }
            else {
                answerQ7IsValidated = true;
                editQ7Input.setVisibility(View.GONE);
                textDisplayAnswer7.setText(answerQ7);
                textDisplayAnswer7.setVisibility(View.VISIBLE);
                buttonSaveEditAnswer7.setText(R.string.edit_answer);
            }
        }
        else if (textDisplayAnswer7.getVisibility() == View.VISIBLE) {
            answerQ7IsValidated = false;
            editQ7Input.setVisibility(View.VISIBLE);
            textDisplayAnswer7.setVisibility(View.GONE);
            buttonSaveEditAnswer7.setText(R.string.save_answer);
        }
    }
    /**
     * This method is called when the 'save / edit' button for the answer of question 9 is clicked
     */
    public void save_edit_answer_9(View view) {
        if (textDisplayAnswer9.getVisibility() == View.GONE) {
            getAnswerQuestion9();
            if (getAnswerQuestion9().equals("")) {
                displayToast("error", getResources().getString(R.string.missing_answer_error_message));
            }
            else {
                answerQ9IsValidated = true;
                editQ9Input.setVisibility(View.GONE);
                textDisplayAnswer9.setText(answerQ9);
                textDisplayAnswer9.setVisibility(View.VISIBLE);
                buttonSaveEditAnswer9.setText(R.string.edit_answer);
            }
        }
        else if (textDisplayAnswer9.getVisibility() == View.VISIBLE) {
            answerQ9IsValidated = false;
            editQ9Input.setVisibility(View.VISIBLE);
            textDisplayAnswer9.setVisibility(View.GONE);
            buttonSaveEditAnswer9.setText(R.string.save_answer);
        }
    }
    /**
     * This method is called when the 'submit answers' button is clicked
     */
    public void submitAnswers(View view) {
        checkQuizCompletion();
        if (!playerNameIsValidated) {
            scrollViewRoot.fullScroll(ScrollView.FOCUS_UP);
            displayToast("error", getResources().getString(R.string.missing_player_name_error_message));
        }
        else if (!quizIsCompleted) {
            displayToast("error", getResources().getString(R.string.quiz_not_completed_error_message));
        }
        else {
            resetScores();
            evalAnswers();
            evalTotalScore();
            resetResultsToastMessage();
            createResultsToastMessage();
            scrollViewRoot.fullScroll(ScrollView.FOCUS_UP);
            displayToast("results", resultsToastMessage);
        }
    }
    /**
     * This method is called when the 'reset quiz" button is clicked
     */
    public void resetQuiz(View view) {
        resetScores();
        resetResultsToastMessage();

        playerNameIsValidated = false;
        q1IsAnswered = false;
        q2IsAnswered = false;
        q3IsAnswered = false;
        q4IsAnswered = false;
        q5IsAnswered = false;
        q6IsAnswered = false;
        q8IsAnswered = false;
        q10IsAnswered = false;
        answerQ7IsValidated = false;
        answerQ9IsValidated = false;
        quizIsCompleted = false;

        editPlayerName.setText("");
        editQ7Input.setText("");
        editQ9Input.setText("");

        textRequestPlayerName.setText(R.string.player_name_request);
        buttonSaveEditPlayerName.setText(R.string.save_player_name);
        buttonSaveEditAnswer7.setText(R.string.save_answer);
        buttonSaveEditAnswer9.setText(R.string.save_answer);
        textDisplayPlayerName.setVisibility(View.GONE);
        textDisplayAnswer7.setVisibility(View.GONE);
        textDisplayAnswer9.setVisibility(View.GONE);
        editPlayerName.setVisibility(View.VISIBLE);
        editQ7Input.setVisibility(View.VISIBLE);
        editQ9Input.setVisibility(View.VISIBLE);

        q1aA.setChecked(false);
        q1aB.setChecked(false);
        q1aC.setChecked(false);
        q1aD.setChecked(false);
        q2aA.setChecked(false);
        q2aB.setChecked(false);
        q2aC.setChecked(false);
        q2aD.setChecked(false);
        q8aA.setChecked(false);
        q8aB.setChecked(false);
        q8aC.setChecked(false);
        q8aD.setChecked(false);
        q3aA.setChecked(false);
        q3aB.setChecked(false);
        q3aC.setChecked(false);
        q3aD.setChecked(false);
        q4aA.setChecked(false);
        q4aB.setChecked(false);
        q4aC.setChecked(false);
        q4aD.setChecked(false);
        q5aA.setChecked(false);
        q5aB.setChecked(false);
        q5aC.setChecked(false);
        q5aD.setChecked(false);
        q6aA.setChecked(false);
        q6aB.setChecked(false);
        q6aC.setChecked(false);
        q6aD.setChecked(false);
        q10aA.setChecked(false);
        q10aB.setChecked(false);
        q10aC.setChecked(false);
        q10aD.setChecked(false);

        q3ABCD.clearCheck();
        q4ABCD.clearCheck();
        q5ABCD.clearCheck();
        q6ABCD.clearCheck();
        q10ABCD.clearCheck();

        scrollViewRoot.fullScroll(ScrollView.FOCUS_UP);

        displayToast("reset", getResources().getString(R.string.reset_quiz_message));
    }
    /**
     * This method is called to get the name input by the player
     */
    private void getPlayerName() {
        playerName = editPlayerName.getText().toString().trim();
        if (playerName.isEmpty()) {
            playerName = getResources().getString(R.string.anonymous_player);
        }
    }
    /**
     * This method is called to get the answer input to question #7
     */
    private String getAnswerQuestion7() {
        answerQ7 = editQ7Input.getText().toString().trim();
        return answerQ7;
    }
    /**
     * This method is called to get the answer input to question #9
     */
    private String getAnswerQuestion9() {
        answerQ9 = editQ9Input.getText().toString().trim();
        return answerQ9;
    }
    /**
     * This method checks if all the questions of the quiz have been completely answered / validated
     */
    private void checkQuizCompletion() {
        if (q1aA.isChecked() || q1aB.isChecked() || q1aC.isChecked() || q1aD.isChecked()) {
            q1IsAnswered = true;
        }
        if (q2aA.isChecked() || q2aB.isChecked() || q2aC.isChecked() || q2aD.isChecked()) {
            q2IsAnswered = true;
        }
        if (q3ABCD.getCheckedRadioButtonId() != -1) {
            q3IsAnswered = true;
        }
        if (q4ABCD.getCheckedRadioButtonId() != -1) {
            q4IsAnswered = true;
        }
        if (q5ABCD.getCheckedRadioButtonId() != -1) {
            q5IsAnswered = true;
        }
        if (q6ABCD.getCheckedRadioButtonId() != -1) {
            q6IsAnswered = true;
        }
        if (q8aA.isChecked() || q8aB.isChecked() || q8aC.isChecked() || q8aD.isChecked()) {
            q8IsAnswered = true;
        }
        if (q10ABCD.getCheckedRadioButtonId() != -1) {
            q10IsAnswered = true;
        }
        if (q1IsAnswered && q2IsAnswered && q3IsAnswered && q4IsAnswered && q5IsAnswered &&
                q6IsAnswered && answerQ7IsValidated && q8IsAnswered && answerQ9IsValidated && q10IsAnswered) {
            quizIsCompleted = true;
        }
    }
    /**
     * This method evaluates the answers submitted for all questions of the quiz
     */
    private void evalAnswers() {
        getAnswerQuestion7();
        getAnswerQuestion9();
        if (q1aA.isChecked() && !q1aB.isChecked() && q1aC.isChecked() && !q1aD.isChecked()) {
            scoreQ1 = 10;
        }
        if (q2aA.isChecked() && q2aB.isChecked() && !q2aC.isChecked() && q2aD.isChecked()) {
            scoreQ2 = 10;
        }
        if (q3aA.isChecked()) {
            scoreQ3 = 10;
        }
        if (q4aD.isChecked()) {
            scoreQ4 = 10;
        }
        if (q5aC.isChecked()) {
            scoreQ5 = 10;
        }
        if (q6aB.isChecked()) {
            scoreQ6 = 10;
        }
        if (answerQ7.equalsIgnoreCase(getResources().getString(R.string.accepted_answer_1_Q7))
                || answerQ7.equalsIgnoreCase(getResources().getString(R.string.accepted_answer_2_Q7))) {
            scoreQ7 = 10;
        }
        if (q8aA.isChecked() && q8aB.isChecked() && !q8aC.isChecked() && q8aD.isChecked()) {
            scoreQ8 = 10;
        }
        if (answerQ9.equalsIgnoreCase(getResources().getString(R.string.accepted_answer_1_Q9))
                || answerQ9.equalsIgnoreCase(getResources().getString(R.string.accepted_answer_2_Q9))
                || answerQ9.equalsIgnoreCase(getResources().getString(R.string.accepted_answer_3_Q9))
                || answerQ9.equalsIgnoreCase(getResources().getString(R.string.accepted_answer_4_Q9))
                || answerQ9.equalsIgnoreCase(getResources().getString(R.string.accepted_answer_5_Q9))
                || answerQ9.equalsIgnoreCase(getResources().getString(R.string.accepted_answer_6_Q9))) {
            scoreQ9 = 10;
        }
        if (q10aC.isChecked()) {
            scoreQ10 = 10;
        }
    }
    /**
     * This method evaluates the total score
     */
    private void evalTotalScore() {
        totalScore = scoreQ1 + scoreQ2 + scoreQ3 + scoreQ4 + scoreQ5 + scoreQ6 + scoreQ7 + scoreQ8 + scoreQ9 + scoreQ10;
    }
    /**
     * This method reinitiates the score variables
     */
    private void resetScores() {
        scoreQ1 = 0;
        scoreQ2 = 0;
        scoreQ3 = 0;
        scoreQ4 = 0;
        scoreQ5 = 0;
        scoreQ6 = 0;
        scoreQ7 = 0;
        scoreQ8 = 0;
        scoreQ9 = 0;
        scoreQ10 = 0;
        totalScore = 0;
        levelReached = "";
    }
    /**
     * This method reinitiates the results toast message
     */
    private void resetResultsToastMessage() {
        resultsToastMessage = "";
    }
    /**
     * This method creates the toast message to display the results
     */
    private void createResultsToastMessage() {
        getPlayerName();
        setLevelComment();
        resultsToastMessage += playerName;
        resultsToastMessage += getResources().getString(R.string.comma_drop_two_lines);
        resultsToastMessage += getResources().getString(R.string.results_toast_msg_part_1);
        resultsToastMessage += totalScore + getResources().getString(R.string.results_toast_msg_part_2);
        resultsToastMessage += resultsToastComment;
    }
    /**
     * This method is called to select a customized message depending on the total score of the user
     */
    private void setLevelComment() {
        if (totalScore <= 20) {
            levelReached = "very low";
            resultsToastComment = getResources().getString(R.string.results_toast_comment_very_low);
        } else if (30 <= totalScore && totalScore <= 40) {
            levelReached = "low";
            resultsToastComment = getResources().getString(R.string.results_toast_comment_low);
        } else if (50 <= totalScore && totalScore <= 70) {
            levelReached = "medium";
            resultsToastComment = getResources().getString(R.string.results_toast_comment_medium);
        } else if (80 <= totalScore && totalScore < 100) {
            levelReached = "high";
            resultsToastComment = getResources().getString(R.string.results_toast_comment_high);
        } else {
            levelReached = "master";
            resultsToastComment = getResources().getString(R.string.results_toast_comment_mastered);
        }
    }
    /**
     * This method displays a custom toast depending on the context
     */
    private void displayToast(String toastType, String toastMessage) {

        Context context = getApplicationContext();
        LayoutInflater inflater = getLayoutInflater();

        View customToastRoot = inflater.inflate(R.layout.custom_toast, null);
        Toast toast = new Toast(context);

        ImageView imageToastIcon = (ImageView) customToastRoot.findViewById(R.id.image_toast_icon);
        TextView textToastMessage = (TextView) customToastRoot.findViewById(R.id.text_toast_message);
        GradientDrawable drawable = (GradientDrawable) customToastRoot.getBackground();

        switch (toastType) {
            case "error":
                drawable.setStroke(8, Color.parseColor("#EC407A"));
                textToastMessage.setTextColor(Color.parseColor("#EC407A"));
                imageToastIcon.setImageResource(R.drawable.ic_red_warning_sign);
                toast.setDuration(Toast.LENGTH_SHORT);
                break;
            case "reset":
                drawable.setStroke(8, Color.parseColor("#616161"));
                textToastMessage.setTextColor(Color.parseColor("#616161"));
                imageToastIcon.setImageResource(R.drawable.ic_reset);
                toast.setDuration(Toast.LENGTH_LONG);
                break;
            case "results":

                toast.setDuration(Toast.LENGTH_LONG);
                switch (levelReached) {
                    case "very low":
                        drawable.setStroke(10, Color.parseColor("#E57373"));
                        textToastMessage.setTextColor(Color.parseColor("#E57373"));
                        imageToastIcon.setImageResource(R.drawable.ic_score_20_red);
                        break;
                    case "low":
                        drawable.setStroke(10, Color.parseColor("#FF9800"));
                        textToastMessage.setTextColor(Color.parseColor("#FF9800"));
                        imageToastIcon.setImageResource(R.drawable.ic_score_40_orange);
                        break;
                    case "medium":
                        drawable.setStroke(10, Color.parseColor("#FFA000"));
                        textToastMessage.setTextColor(Color.parseColor("#FFA000"));
                        imageToastIcon.setImageResource(R.drawable.ic_score_60_yellow);
                        break;
                    case "high":
                        drawable.setStroke(10, Color.parseColor("#8BC34A"));
                        textToastMessage.setTextColor(Color.parseColor("#8BC34A"));
                        imageToastIcon.setImageResource(R.drawable.ic_score_80_light_green);
                        break;
                    case "master":
                        drawable.setStroke(10, Color.parseColor("#388E3C"));
                        textToastMessage.setTextColor(Color.parseColor("#388E3C"));
                        imageToastIcon.setImageResource(R.drawable.ic_score_100_dark_green);
                        break;
                }
        }
        textToastMessage.setText(toastMessage);
        toast.setView(customToastRoot);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}