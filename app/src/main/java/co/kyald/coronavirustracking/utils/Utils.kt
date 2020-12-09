package co.kyald.coronavirustracking.utils

import android.content.Context
import android.content.DialogInterface
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AlertDialog


class Utils {

    fun aboutAlert(context: Context, title: String, message: String) {

        val builder = AlertDialog.Builder(context)

        with(builder)
        {
            setTitle("About")
            setMessage("Corona Virus live Tracking Map")
            setPositiveButton("OK") { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
            }
            show()
        }

    }

    fun rotatingAnimation() : Animation {

        val rotate = RotateAnimation(0f,
            180f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotate.duration = 500
        rotate.repeatCount = Animation.INFINITE
        rotate.interpolator = LinearInterpolator()

        return rotate
    }

}