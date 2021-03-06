package com.awesomedialog.blennersilva.awesomedialoglibrary;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;

/**
 * Created by blennersilva on 21/08/17.
 */

@SuppressWarnings("WeakerAccess")
public class AwesomeNoticeDialog extends AwesomeDialogBuilder<AwesomeNoticeDialog> {
    private Button btDialogOk;

    public AwesomeNoticeDialog(Context context) {
        super(context);

        setColoredCircle(R.color.dialogNoticeBackgroundColor);
        setDialogIconAndColor(R.drawable.ic_notice, R.color.white);
        setButtonBackgroundColor(R.color.dialogNoticeBackgroundColor);
        setCancelable(true);
    }

    {
        btDialogOk = findView(R.id.btDialogOk);
    }

    public AwesomeNoticeDialog setNoticeButtonClick(@Nullable final Closure selecteOk) {
        btDialogOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selecteOk != null) {
                    selecteOk.exec();
                }

                hide();
            }
        });
        return this;
    }

    public AwesomeNoticeDialog setButtonBackgroundColor(int buttonBackground) {
        if (btDialogOk != null) {
            btDialogOk.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
        }
        return this;
    }

    public AwesomeNoticeDialog setButtonTextColor(int textColor) {
        if (btDialogOk != null) {
            btDialogOk.setTextColor(ContextCompat.getColor(getContext(), textColor));
        }
        return this;
    }

    public AwesomeNoticeDialog setButtonText(String text) {
        if (btDialogOk != null) {
            btDialogOk.setText(text);
            btDialogOk.setVisibility(View.VISIBLE);
        }
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_notice;
    }
}
