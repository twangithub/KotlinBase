package com.twan.kotlinbase.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.twan.kotlinbase.R;

public class TogglePasswordVisibilityEditText extends androidx.appcompat.widget.AppCompatEditText {

    //切换drawable的引用
    private Drawable visibilityDrawable;

    private boolean visibililty = false;

    public TogglePasswordVisibilityEditText(Context context) {
        this(context, null);
    }

    public TogglePasswordVisibilityEditText(Context context, AttributeSet attrs) {
        //指定了默认的style属性
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public TogglePasswordVisibilityEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        //获得该EditText的left ,top ,right,bottom四个方向的drawable
        Drawable[] compoundDrawables = getCompoundDrawables();
        visibilityDrawable = compoundDrawables[2];
        if (visibilityDrawable == null) {
            visibilityDrawable = getResources().getDrawable(R.mipmap.icon_eyeclose);
        }
    }

    /**
     * 用按下的位置来模拟点击事件
     * 当按下的点的位置 在  EditText的宽度 - (图标到控件右边的间距 + 图标的宽度)  和
     * EditText的宽度 - 图标到控件右边的间距 之间就模拟点击事件，
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_UP) {

            if (getCompoundDrawables()[2] != null) {
                boolean xFlag = false;
                boolean yFlag = false;
                //得到用户的点击位置，模拟点击事件
                xFlag = event.getX() > getWidth() - (visibilityDrawable.getIntrinsicWidth() + getCompoundPaddingRight
                        ()) &&
                        event.getX() < getWidth() - (getTotalPaddingRight() - getCompoundPaddingRight());

                if (xFlag) {
                    visibililty = !visibililty;
                    if (visibililty) {
                        visibilityDrawable = getResources().getDrawable(R.mipmap.icon_eye);
                        /*this.setInputType(EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);*/

                        this.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    } else {
                        //隐藏密码
                        visibilityDrawable = getResources().getDrawable(R.mipmap.icon_eyeclose);
                        //this.setInputType(EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
                        this.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }

                    //将光标定位到指定的位置
                    CharSequence text = this.getText();
                    if (text instanceof Spannable) {
                        Spannable spanText = (Spannable) text;
                        Selection.setSelection(spanText, text.length());
                    }
                    //调用setCompoundDrawables方法时，必须要为drawable指定大小，不然不会显示在界面上
                    visibilityDrawable.setBounds(0, 0, visibilityDrawable.getMinimumWidth(),
                            visibilityDrawable.getMinimumHeight());
                    setCompoundDrawables(getCompoundDrawables()[0],
                            getCompoundDrawables()[1], visibilityDrawable, getCompoundDrawables()[3]);
                }
            }
        }
        return super.onTouchEvent(event);
    }
}
