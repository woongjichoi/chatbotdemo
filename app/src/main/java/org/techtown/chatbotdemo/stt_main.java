package org.techtown.chatbotdemo;

import android.Manifest;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

// STT는 주석처리하고 음성 녹음만 우선 구현함
// 에뮬레이터에서 녹음되는지 확인해보려면 점 세개 > Microphone > 전부 초록색으로!

public class stt_main extends AppCompatActivity {
    MediaRecorder recorder;
    String fileName;
    MediaPlayer player;
    int position=0;

    Button sttBtn; // 누르면 녹음 시작
    Button stop; // 누르면 녹음 중지
    Button record; // 누르면 녹음 재생

    /*
    Intent intent;
    SpeechRecognizer mRecognizer;
    Button sttBtn;
    TextView textView;
    final int PERMISSION = 1;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileName=getExternalCacheDir().getAbsolutePath();
        fileName+="/audiorecordtest.3gp";

        sttBtn=(Button)findViewById(R.id.sttStart);
        sttBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordAudio();
            }
        });

        stop=(Button)findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopRecording();
            }
        });

        record=(Button)findViewById(R.id.record);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAudio();
            }
        });

        /*
        // 퍼미션 체크
        if ( Build.VERSION.SDK_INT >= 23 ){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET, Manifest.permission.RECORD_AUDIO},PERMISSION);
        }

        // xml의 버튼과 텍스트 뷰 연결
        textView = (TextView)findViewById(R.id.sttResult);
        sttBtn = (Button) findViewById(R.id.sttStart);

        // RecognizerIntent 객체 생성
        intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR");

        // 버튼을 클릭 이벤트 - 객체에 Context와 listener를 할당한 후 실행
        sttBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecognizer=SpeechRecognizer.createSpeechRecognizer(stt_main.this);
                mRecognizer.setRecognitionListener(listener);
                mRecognizer.startListening(intent);
            }

        });
        */
    }

    public void recordAudio(){
        recorder=new MediaRecorder();

        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        recorder.setOutputFile(fileName);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        try{
            recorder.prepare();
            Toast.makeText(this, "녹음 시작됨", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        recorder.start();
    }

    public void stopRecording(){
        if (recorder!=null){
            recorder.stop();
            recorder.release();
            recorder=null;

            Toast.makeText(this, "녹음 중지됨", Toast.LENGTH_LONG).show();
        }
    }

    public void playAudio(){
        try{
            closePlayer();
            player=new MediaPlayer();
            player.setDataSource(fileName);
            player.prepare();
            player.start();

            Toast.makeText(this, "재생 시작됨", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closePlayer(){
        if (player!=null){
            player.release();
            player=null;
        }
    }
    /*
    private RecognitionListener listener = new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle params) {
            Toast.makeText(getApplicationContext(),"어서오세요.",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBeginningOfSpeech() {}

        @Override
        public void onRmsChanged(float rmsdB) {}

        @Override
        public void onBufferReceived(byte[] buffer) {}

        @Override
        public void onEndOfSpeech() {}

        @Override
        public void onError(int error) {
            String message ;

            switch (error) {
                case SpeechRecognizer.ERROR_AUDIO:
                    message = "오디오 에러";
                    break;
                case SpeechRecognizer.ERROR_CLIENT:
                    message = "클라이언트 에러";
                    break;
                case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                    message = "퍼미션 없음";
                    break;
                case SpeechRecognizer.ERROR_NETWORK:
                    message = "네트워크 에러";
                    break;
                case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                    message = "네트웍 타임아웃";
                    break;
                case SpeechRecognizer.ERROR_NO_MATCH:
                    message = "찾을 수 없음";
                    break;
                case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                    message = "RECOGNIZER가 바쁨";
                    break;
                case SpeechRecognizer.ERROR_SERVER:
                    message = "서버가 이상함";
                    break;
                case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                    message = "말하는 시간초과";
                    break;
                default:
                    message = "알 수 없는 오류임";
                    break;
            }

            Toast.makeText(getApplicationContext(), "에러가 발생하였습니다. : " + message,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResults(Bundle results) {
            // 말을 하면 ArrayList에 단어를 넣고 textView에 단어를 이어줍니다.
            ArrayList<String> matches =
                    results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

            for(int i = 0; i < matches.size() ; i++){
                textView.setText(matches.get(i));
            }
        }

        @Override
        public void onPartialResults(Bundle partialResults) {}

        @Override
        public void onEvent(int eventType, Bundle params) {}
    };*/
}
