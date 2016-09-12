package com.sso.receiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

import com.sso.activity.LoginActivity;
import com.sso.service.ForceOfflineService;
import com.sso.utils.ActivityController;

/**
 * @author 王立强
 * @Date 2016/7/29.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
    /*
     * (non-Javadoc)
     *
     * @see android.content.BroadcastReceiver#onReceive(android.content.Context,
     * android.content.Intent)
     */
    @Override
    public void onReceive(final Context context, Intent intent) {
        // TODO Auto-generated method stub
        intent = new Intent(context, ForceOfflineService.class);
        context.stopService(intent);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("已下线");
        dialogBuilder.setMessage("您的账户已在另一个设备登录,请尝试重新登陆");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("登   录", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO Auto-generated method stub
                ActivityController.getInstance().finishActivity();
                Intent intent = new Intent(context, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setType(
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
}
