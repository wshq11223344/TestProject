package com.example.testpproject.dialog;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testpproject.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends AppCompatActivity {


    @BindView(R.id.tv_dialog)
    TextView tvDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_dialog)
    public void onViewClicked() {

//        showNormalDialog();
//        showMultiBtnDialog();
//        showListDialog();
//        showSingleChoiceDialog();
//        showMultiChoiceDialog();
//        showWaitingDialog();
//        showProgressDialog();
//        showInputDialog();
//        showCustomizeDialog();
        showListDialog2();
    }

    private void showNormalDialog() {
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(DialogActivity.this);
        normalDialog.setIcon(R.mipmap.live_head_passerby);
        normalDialog.setTitle("我是一个普通Dialog");
        normalDialog.setMessage("你要点击哪一个按钮呢?");
        normalDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
                //...To-do
            }
        });
        normalDialog.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //...To-do
                Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        normalDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                return false;
            }
        });
        normalDialog.setCancelable(false);
        // 显示
        normalDialog.show();
    }

    /* @setNeutralButton 设置中间的按钮
     * 若只需一个按钮，仅设置 setPositiveButton 即可
     */
    private void showMultiBtnDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(DialogActivity.this);
        normalDialog.setIcon(R.mipmap.live_head_passerby);
        normalDialog.setTitle("我是一个普通Dialog").setMessage("你要点击哪一个按钮呢?");
        normalDialog.setPositiveButton("按钮1", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // ...To-do
            }
        });
        normalDialog.setNeutralButton("按钮2", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // ...To-do
            }
        });
        normalDialog.setNegativeButton("按钮3", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // ...To-do
            }
        });
        // 创建实例并显示
        normalDialog.show();
    }

    private void showListDialog() {
        final String[] items = {"我是1", "我是2", "我是3", "我是4"};
        AlertDialog.Builder listDialog = new AlertDialog.Builder(DialogActivity.this);
        listDialog.setTitle("我是一个列表Dialog");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which 下标从0开始
                // ...To-do
                Toast.makeText(DialogActivity.this, "你点击了" + items[which], Toast.LENGTH_SHORT).show();
            }
        });
        listDialog.show();
    }

    int yourChoice;

    private void showSingleChoiceDialog() {
        final String[] items = {"我是1", "我是2", "我是3", "我是4"};
        yourChoice = -1;
        AlertDialog.Builder singleChoiceDialog = new AlertDialog.Builder(DialogActivity.this);
        singleChoiceDialog.setTitle("我是一个单选Dialog");
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                yourChoice = which;
                Log.e("======", which + "");
            }
        });
        singleChoiceDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (yourChoice != -1) {
                    Toast.makeText(DialogActivity.this, "你选择了" + items[yourChoice], Toast.LENGTH_SHORT).show();
                }
            }
        });
        singleChoiceDialog.show();
    }


    ArrayList<Integer> yourChoices = new ArrayList<>();

    private void showMultiChoiceDialog() {
        final String[] items = {"我是1", "我是2", "我是3", "我是4"};
        // 设置默认选中的选项，全为false默认均未选中
        final boolean initChoiceSets[] = {false, false, false, false};
        yourChoices.clear();
        AlertDialog.Builder multiChoiceDialog = new AlertDialog.Builder(DialogActivity.this);
        multiChoiceDialog.setTitle("我是一个多选Dialog");
        multiChoiceDialog.setMultiChoiceItems(items, initChoiceSets, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Log.e("====", which + "==" + isChecked);
                if (isChecked) {
                    yourChoices.add(which);
                } else {
                    yourChoices.remove(which);
                }
            }
        });
        multiChoiceDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.e("====", which + "");
                int size = yourChoices.size();
                String str = "";
                for (int i = 0; i < size; i++) {
                    str += items[yourChoices.get(i)] + " ";
                }
                Toast.makeText(DialogActivity.this, "你选中了" + str, Toast.LENGTH_SHORT).show();
            }
        });
        multiChoiceDialog.show();
    }

    private void showWaitingDialog() {
        /* 等待Dialog具有屏蔽其他控件的交互能力
         * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
         * 下载等事件完成后，主动调用函数关闭该Dialog
         */
        ProgressDialog waitingDialog = new ProgressDialog(DialogActivity.this);
        waitingDialog.setTitle("我是一个等待Dialog");
        waitingDialog.setMessage("等待中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }

    private void showProgressDialog() {
        /* @setProgress 设置初始进度
         * @setProgressStyle 设置样式（水平进度条）
         * @setMax 设置进度最大值
         */
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog = new ProgressDialog(DialogActivity.this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("我是一个进度条Dialog");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();
        /* 模拟进度增加的过程
         * 新开一个线程，每个100ms，进度增加1
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while (progress < MAX_PROGRESS) {
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 进度达到最大值后，窗口消失
                progressDialog.cancel();
            }
        }).start();
    }

    private void showInputDialog() {
        /*@setView 装入一个EditView
         */
        final EditText editText = new EditText(DialogActivity.this);
        AlertDialog.Builder inputDialog = new AlertDialog.Builder(DialogActivity.this);
        inputDialog.setTitle("我是一个输入Dialog");
        inputDialog.setView(editText);
        inputDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        }).show();
    }

    private void showCustomizeDialog() {
        /* @setView 装入自定义View ==> R.layout.dialog_customize
         * 由于dialog_customize.xml只放置了一个EditView，因此和图8一样
         * dialog_customize.xml可自定义更复杂的View
         */
        AlertDialog.Builder customizeDialog = new AlertDialog.Builder(DialogActivity.this);
        final View dialogView = LayoutInflater.from(DialogActivity.this).inflate(R.layout.dialog_customize, null);
        customizeDialog.setTitle("我是一个自定义Dialog");
        customizeDialog.setView(dialogView);
        customizeDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 获取EditView中的输入内容
                EditText edit_text = (EditText) dialogView.findViewById(R.id.edit_text);
                Toast.makeText(DialogActivity.this, edit_text.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        customizeDialog.show();
    }


    /* 复写Builder的create和show函数，可以在Dialog显示前实现必要设置
     * 例如初始化列表、默认选项等
     * @create 第一次创建时调用
     * @show 每次显示时调用
     */
    private void showListDialog2() {
        final String[] items = {"我是1", "我是2", "我是3", "我是4"};
        AlertDialog.Builder listDialog = new AlertDialog.Builder(DialogActivity.this) {
            @Override
            public AlertDialog create() {
                items[0] = "我是No.1";
                Log.e("=====", "第一次创建");
                return super.create();
            }

            @Override
            public AlertDialog show() {
                items[1] = "我是No.2";
                Log.e("=====", "每次显示");

                return super.show();
            }
        };
        listDialog.setTitle("我是一个列表Dialog");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // ...To-do
                Log.e("=====", which + "");

            }
        });
        /* @setOnDismissListener Dialog销毁时调用
         * @setOnCancelListener Dialog关闭时调用
         */
        listDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialog) {
                Log.e("=====", "Dialog销毁");
            }
        });

        listDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
                //...To-do
            }
        });

        listDialog.show();
    }

}