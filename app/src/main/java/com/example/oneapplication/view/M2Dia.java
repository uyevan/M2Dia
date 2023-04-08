package com.example.oneapplication.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

import com.airbnb.lottie.LottieAnimationView;
import com.example.oneapplication.R;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @noinspection ALL
 * 2023-04-08
 * Evan
 * uyevan@163.com
 * China NingXia
 */

public class M2Dia extends Dialog {

    // 必备参数
    private TextView title;
    // 可选参数
    private TextView titles;
    private LottieAnimationView lottie;

    // 取消 确认 按钮
    private LinearLayout close;
    private LinearLayout confirm;

    // 按钮Text 可变
    private TextView con_text;
    private TextView clo_text;

    // 可变资源
    private static int diaAnimXml = R.style.DialogAnimation;
    private static boolean isCancelable = true; // 返回键是否允许关闭
    private static boolean isCanceledOnTouchOutside = true; // 点击界面是否允许关闭
    private int RepeatCoun = 0; // Lottie循环播放次数

    // 点击事件处理
    private View.OnClickListener clo = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
        }
    };
    private View.OnClickListener con = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
        }
    };

    // 三类View资源
    private static final Map<M2Type, Integer> LAYOUT_MAP = new HashMap<>();

    static {
        LAYOUT_MAP.put(M2Type.SUCCESS, R.layout.dia_view_s);
        LAYOUT_MAP.put(M2Type.ERROR, R.layout.dia_view_e);
        LAYOUT_MAP.put(M2Type.WARNING, R.layout.dia_view_w);
    }

    // 三类JsonLottie资源
    private static final Map<M2Type, String> LOTTIE_MAP = new HashMap<>();

    static {
        LOTTIE_MAP.put(M2Type.SUCCESS, "success.json");
        LOTTIE_MAP.put(M2Type.ERROR, "error.json");
        LOTTIE_MAP.put(M2Type.WARNING, "warning.json");
    }

    // 有取消，确认按钮DiaLog
    public M2Dia(@NonNull Context context, M2Type dType, String title, M2ButTpe T) {
        super(context, R.style.Dialog);
        int layoutResId = LAYOUT_MAP.get(dType);
        setContentView(layoutResId);
        setCancelable(this.isCancelable); // 返回键是否允许关闭
        setCanceledOnTouchOutside(this.isCanceledOnTouchOutside); // 点击界面是否允许关闭
        initView();
        this.title.setText(title);
        this.lottie.setAnimation(LOTTIE_MAP.get(dType));
        this.lottie.setRepeatCount(this.RepeatCoun);
        if (T == M2ButTpe.HAVE_ALL_BUT) {
            this.close.setVisibility(View.VISIBLE);
        } else if (T == M2ButTpe.NO_CLOSE_BUT) {
            this.close.setVisibility(View.GONE);
        }
        setClickListener(this.con, this.clo);
    }

    private void initView() {
        this.title = findViewById(R.id.title);
        this.titles = findViewById(R.id.titles);
        this.lottie = findViewById(R.id.lottie);
        this.confirm = findViewById(R.id.confirm);
        this.con_text = findViewById(R.id.con_text);
        this.clo_text = findViewById(R.id.clo_text);
        this.close = findViewById(R.id.close);
    }

    // 确认按钮文本
    @CheckResult
    public M2Dia setConfirmButText(String text) {
        this.con_text.setText(text);
        return this;
    }

    // 取消按钮文本
    @CheckResult
    public M2Dia setCloseButText(String text) {
        this.clo_text.setText(text);
        return this;
    }

    // 副标题设置
    @CheckResult
    public M2Dia setContent(String content) {
        this.titles.setText(content);
        return this;
    }

    // 确定按钮方法
    public M2Dia setConfirmClick(View.OnClickListener click) {
        this.con = click;
        setClickListener(this.con, this.clo); //事件的处理
        return this;
    }

    // 取消按钮方法
    public M2Dia setCloseClick(View.OnClickListener click) {
        this.clo = click;
        setClickListener(this.con, this.clo); //事件的处理
        return this;
    }

    // 设置Lottie
    @CheckResult
    public M2Dia setLottieJson(M2Type type, String resource) {
        if (resource == null || !isAssetsExists(getContext(), resource)) {
            this.lottie.setAnimation(LOTTIE_MAP.get(type));
        } else {
            this.lottie.setAnimation(resource);
        }
        return this;
    }

    // 设置Lottie循环次数
    @CheckResult
    public M2Dia setRepeatCount(int count) {
        this.RepeatCoun = count;
        this.lottie.setRepeatCount(this.RepeatCoun);
        return this;
    }

    // 动画样式设置
    @CheckResult
    public M2Dia setAnimationXml(int AnimationXmlResouse) {
        getWindow().getAttributes().windowAnimations = AnimationXmlResouse;
        return this;
    }

    // 点击返回键是否允许关闭
    @CheckResult
    public M2Dia setCanceledOnTouchOutsides(boolean canceledOnTouchOutsides) {
        this.isCanceledOnTouchOutside = canceledOnTouchOutsides;
        setCanceledOnTouchOutside(this.isCanceledOnTouchOutside); // 点击界面是否允许关闭
        return this;
    }

    // 点击屏幕是否允许关闭
    @CheckResult
    public M2Dia setCancelables(boolean cancelable) {
        this.isCancelable = cancelable;
        setCancelable(this.isCancelable); // 返回键是否允许关闭
        return this;
    }

    // 启动
    @CheckResult
    public M2Dia showM2() {
        show();
        return this;
    }

    /*成功*/
    @CheckResult
    public static M2Dia createSuccess(@NonNull Context context, String title, M2ButTpe T) {
        return new M2Dia(context, M2Type.SUCCESS, title, T);
    }

    /*失败*/
    @CheckResult
    public static M2Dia createError(@NonNull Context context, String title, M2ButTpe T) {
        return new M2Dia(context, M2Type.ERROR, title, T);
    }

    /*警告*/
    @CheckResult
    public static M2Dia createWarning(@NonNull Context context, String title, M2ButTpe T) {
        return new M2Dia(context, M2Type.WARNING, title, T);
    }

    // Assets资源检测
    private static boolean isAssetsExists(Context context, String fileName) {
        AssetManager assetManager = context.getAssets();
        try {
            //获取指定目录下的所有文件名及子目录名
            String[] files = assetManager.list("");
            for (String file : files) {
                if (file.equals(fileName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 启动实现类
    @Override
    public void show() {
        super.show();
    }

    // 关闭实现类
    @Override
    public void dismiss() {
        super.dismiss();
    }

    // 取消，确认操作
    private void setClickListener(View.OnClickListener... listeners) {
        //判断listeners数组的大小
        switch (listeners.length) {
            case 1:
                this.confirm.setOnClickListener(listeners[0]);
                break;
            case 2:
                this.confirm.setOnClickListener(listeners[0]);
                this.close.setOnClickListener(listeners[1]);
                break;
            default:
                throw new IllegalArgumentException("参数个数不正确");
        }
    }

    // 三种类型
    public enum M2Type {
        ERROR,
        SUCCESS,
        WARNING;
    }

    // 三种模式
    public enum M2ButTpe {
        HAVE_ALL_BUT,
        NO_CLOSE_BUT
    }
}