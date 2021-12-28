package com.example.roomdatabasetest.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdatabasetest.R
import com.example.roomdatabasetest.model.User
import com.example.roomdatabasetest.viemodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)


        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.btnAdd.setOnClickListener{
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val firstName = etFirstName.text.toString()
        val lastName = etLastNAme.text.toString()
        val age = etAge.text


        if (inputCheck(firstName, lastName, age)) {
            // Create user object
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
            // Add data to database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"Succesfully added!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_LONG).show()
        }
    }

    // Checks that all fields are filled
    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || age.isEmpty())
    }
}