package com.example.calendar

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.navigation.fragment.findNavController
import com.example.calendar.databinding.FragmentSecondBinding
import java.util.Calendar

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnCheckedChangeListener{ buttonView, isChecked->
            if(isChecked)
                binding.calendar.visibility = View.GONE;
            else
                binding.calendar.visibility = View.VISIBLE
        }

        binding.savebutton.setOnClickListener{
            val placeText: String = binding.placetext.text.toString()
            val alarmtimeText: String = binding.alarmtimetext.text.toString()
            val emailText: String = binding.emailtext.text.toString()
            val memoText: String = binding.memotext.text.toString()
            val timeText: String = binding.timetext.text.toString()
            val repeaText: String = binding.repeattext.text.toString()
            Log.d("UserInput", placeText)
            Log.d("UserInput", alarmtimeText)
            Log.d("UserInput", emailText)
            Log.d("UserInput", memoText)
            Log.d("UserInput", timeText)
            Log.d("UserInput", repeaText)
        }

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
