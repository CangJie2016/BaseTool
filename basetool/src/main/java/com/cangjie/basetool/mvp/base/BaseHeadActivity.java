package com.cangjie.basetool.mvp.base;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cangjie.basetool.BaseToolStyle;
import com.cangjie.basetool.R;
import com.cangjie.basetool.utils.AnimationHelper;

import static com.cangjie.basetool.R.id.iv_base_head_back;


public abstract class BaseHeadActivity extends BaseActivity {

    public RelativeLayout rel_contentArea;
    TextView tv_headTitle;

    private FrameLayout fl_back_container;
    ImageView iv_backButton;

    RelativeLayout mLoading;
    RelativeLayout rel_base_headArea;

    View mContantArea;

    private FrameLayout fl_right_container;
    private ImageButton ib_base_head_right_button;
    private TextView tv_base_head_right_button;
    private View view_divide_line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_head);
        assignViews();
        defineHeadStyle();
    }

    @Override
    public void setContentView(int layoutResID) {
        // 判断是否有网络
        mContantArea = getLayoutInflater().inflate(layoutResID, rel_contentArea, false);
        setContentView(mContantArea);
    }

    @Override
    public void setContentView(View view) {
        setContentView(view, view.getLayoutParams());
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        rel_contentArea.addView(view, params);

    }

    protected void hideHeadArea() {
        rel_base_headArea.setVisibility(View.GONE);
    }

    protected void showHeadArea(){
        rel_base_headArea.setVisibility(View.VISIBLE);
    }


    public void showLoading() {
        mLoading.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        AnimationHelper.crossfade(mLoading, rel_contentArea, getResources().getInteger(android.R.integer.config_shortAnimTime));
    }

    public void showBackButton() {
        this.showBackButton(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void showBackButton(OnClickListener listener) {
        fl_back_container.setOnClickListener(listener);
        fl_back_container.setVisibility(View.VISIBLE);
    }

    public void showTitle(String title) {
        tv_headTitle.setText(title);
    }

    public void hideTitle() {
        tv_headTitle.setVisibility(View.GONE);
    }

    public void showRightImageButton(int drawable, OnClickListener listener){
        ib_base_head_right_button.setBackground(getResources().getDrawable(drawable));
        ib_base_head_right_button.setOnClickListener(listener);
        fl_right_container.setVisibility(View.VISIBLE);
        ib_base_head_right_button.setVisibility(View.VISIBLE);
    }

    /**
     * tv_base_head_right_button  android:maxLength="6"
     */
    public void showRightTextView(String text, int size, int color, boolean isBold, OnClickListener listener){
        tv_base_head_right_button.setText(text);
        tv_base_head_right_button.setOnClickListener(listener);
        tv_base_head_right_button.setTextColor(getResources().getColor(color));
        tv_base_head_right_button.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        if (isBold){
            tv_base_head_right_button.setTypeface(null, Typeface.BOLD);
        }
        fl_right_container.setVisibility(View.VISIBLE);
        tv_base_head_right_button.setVisibility(View.VISIBLE);
    }

    private void assignViews() {
        rel_contentArea = (RelativeLayout) findViewById(R.id.rel_base_contentArea);

        fl_back_container = (FrameLayout) findViewById(R.id.fl_back);
        iv_backButton = (ImageView) findViewById(iv_base_head_back);
        tv_headTitle = (TextView) findViewById(R.id.tv_base_head_title);

        fl_right_container = (FrameLayout) findViewById(R.id.fl_right_container);
        ib_base_head_right_button = (ImageButton) findViewById(R.id.ib_base_head_right_button);
        tv_base_head_right_button = (TextView) findViewById(R.id.tv_base_head_right_button);


        mLoading = (RelativeLayout) findViewById(R.id.rel_base_loading);
        rel_base_headArea = (RelativeLayout) findViewById(R.id.rel_base_headArea);

        view_divide_line = (View) findViewById(R.id.view_divide_line);
    }

    /**
     *
     textView.setTypeface(null, Typeface.BOLD_ITALIC);
     textView.setTypeface(null, Typeface.BOLD);
     textView.setTypeface(null, Typeface.ITALIC);
     textView.setTypeface(null, Typeface.NORMAL);
     */
    private void defineHeadStyle() {
        rel_base_headArea.setBackgroundColor(getResources().getColor(BaseToolStyle.CONTENT_BACKGROUND_COLOR));
        iv_backButton.setBackground(getResources().getDrawable(BaseToolStyle.BACK_BUTTON_DRAWABLE));
        tv_headTitle.setTextColor(getResources().getColor(BaseToolStyle.TITLE_TEXT_COLOR));
        tv_headTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, BaseToolStyle.TITLE_TEXT_SIZE);
        if (BaseToolStyle.TITLE_IS_BOLD){
            tv_headTitle.setTypeface(null, Typeface.BOLD);
        }
    }

    public void showDivideLine(){
        view_divide_line.setVisibility(View.VISIBLE);
    }
    public void showDivideLine(int color){
        view_divide_line.setBackgroundColor(color);
        showDivideLine();
    }

    public void hideDivideLine(){
        view_divide_line.setVisibility(View.GONE);
    }
}
