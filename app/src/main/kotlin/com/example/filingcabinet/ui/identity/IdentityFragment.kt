package com.example.filingcabinet.ui.identity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.filingcabinet.R
import com.example.filingcabinet.databinding.FragmentIdentityBinding

class IdentityFragment : Fragment(R.layout.fragment_identity) {

    private val viewBinding: FragmentIdentityBinding by viewBinding()

    private val args: IdentityFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(args.employee)
    }

    private fun initViews(identity: IdentityUiModel) = viewBinding.run {

        if (identity.avatar.isNullOrBlank()) photo.setImageResource(R.drawable.ic_no_photo)
        else photo.load(identity.avatar) {
            crossfade(true)
            placeholder(R.drawable.ic_no_photo)
            error(R.drawable.ic_no_photo)
        }

        fullName.text = identity.fullName

        birthday.title.text = getString(R.string.employee_birthday_title)
        birthday.body.text =
            if (identity.birthday.isNotBlank()) getString(R.string.employee_birthday, identity.birthday, identity.age)
            else "-"

        specialty.title.text = getString(R.string.employee_specialty_title)
        specialty.body.text = identity.specialty

    }

}