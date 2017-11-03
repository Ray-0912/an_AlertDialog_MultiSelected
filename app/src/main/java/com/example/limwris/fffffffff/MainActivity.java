package com.example.limwris.fffffffff;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    boolean[] selected = new boolean[]{false, false, false, false, false, false};
    private EditText tv_grasslandGreatType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_grasslandGreatType = (EditText)findViewById(R.id.test);
        tv_grasslandGreatType.setOnClickListener(new EditText.OnClickListener(){

            @Override
            public void onClick(View view) {
                showMutiDialog();
            }
        });
    }


    private void showMutiDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("fuck");
        DialogInterface.OnMultiChoiceClickListener mutiListerner = new DialogInterface.OnMultiChoiceClickListener() {

            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                selected[which] = isChecked;
            }
        };


        builder.setMultiChoiceItems(R.array.arrtest, selected, mutiListerner);
        DialogInterface.OnClickListener btnListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                String selectedStr = "";
                for (int i = 0; i < selected.length; i++) {
                    if (selected[i] == true) {
                        selectedStr = selectedStr + " " + getResources().getStringArray(R.array.arrtest)[i];
                    }
                }
                if (!TextUtils.isEmpty(selectedStr)) {
                    tv_grasslandGreatType.setText(selectedStr);
                } else {
                    tv_grasslandGreatType.setText("請選擇身分類別");
                }
            }
        };
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("確定", btnListener);
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(true);
        // dialog彈出後，點擊界面其他部分dialog消失 }

    }
}
