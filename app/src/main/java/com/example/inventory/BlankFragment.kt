package com.example.inventory

import android.R
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.inventory.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {
    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        setMarginTop()
        getDeviceNameID()
        return binding.root
    }

    private fun getDeviceNameID() {
        var s = "Debug-infos:\n"
        s += """
            OS Version: ${System.getProperty("os.version")}(${Build.VERSION.INCREMENTAL})
            
            """.trimIndent()
        s += """
            OS API Level: ${Build.VERSION.RELEASE}(${Build.VERSION.SDK_INT})
            
            """.trimIndent()
        s += """
            Device: ${Build.DEVICE}
            
            """.trimIndent()
        s += """Model (and Product): ${Build.MODEL} (${Build.PRODUCT})"""

        val deviceModel = Build.MODEL
        Log.i("Debug", "$s --- device model: $deviceModel")
    }

    private fun setMarginTop() {
        val deviceModel = Build.MODEL
        if (deviceModel.equals("Redmi Note 8 Pro")) {
            val layoutParams = binding.textviewTitle.layoutParams as ViewGroup.MarginLayoutParams
            val top = context?.dpToPixel(40) ?: 0
            // val top = context?.applicationContext!!.resources.getDimension(R.dimen.system_app_widget_inner_radius).toInt()
            layoutParams.setMargins(0, top, 0, 0)
            binding.textviewTitle.layoutParams = layoutParams
        }
    }

    private fun Context.dpToPixel(dp: Int): Int =
        (dp * applicationContext.resources.displayMetrics.density).toInt()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}