package smartcommunity.hwpeng.com.smartcommunity.utils;

import android.widget.EditText;

/**
 * Created by hwpeng on 2017/9/28.
 */

public class EditTextCheckNull {

    public static boolean isNull(EditText editText){
        if(editText.getText().toString().trim().length() == 0){
            return true;
        }else{
            return false;
        }
    }
}
