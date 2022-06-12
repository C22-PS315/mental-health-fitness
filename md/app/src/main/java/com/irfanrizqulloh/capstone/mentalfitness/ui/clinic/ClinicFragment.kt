package com.irfanrizqulloh.capstone.mentalfitness.ui.clinic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.irfanrizqulloh.capstone.mentalfitness.R


class ClinicFragment : Fragment() {

    private lateinit var clinicViewModel: ClinicViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        clinicViewModel =
                ViewModelProvider(this).get(ClinicViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_clinic, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
        val clinicLocation: Spinner = root.findViewById(R.id.clinicLocation)
        clinicViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
            val adapter = context?.let { it1 ->
                ArrayAdapter.createFromResource(
                    it1,
                    R.array.clinicLocation,
                    android.R.layout.simple_spinner_item
                )
            }

            adapter?.setDropDownViewResource(android.R.layout.simple_spinner_item)
            clinicLocation.setAdapter(adapter);
        })
        return root
    }

}