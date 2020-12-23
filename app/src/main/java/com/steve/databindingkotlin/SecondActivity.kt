package com.steve.databindingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.steve.databindingkotlin.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
     lateinit var binding:ActivitySecondBinding
     lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_second)
        viewModel=ViewModelProvider(this).get(ViewModel::class.java)
        binding.viewmodel=viewModel
        binding.lifecycleOwner=this
        binding.mcontext=this
        viewModel.textData.value="Steve Test"
        viewModel.btnText.value="OK"
        viewModel.editText.observe(this, Observer {
            Log.d("TextWatcher",it.toString())
        })
        viewModel.emailText.observe(this, Observer {
            if (viewModel.isEmailValid(it.toString())){
            Log.d("EmailText:",it.toString())
            }else{
                viewModel.error.value="this is not valid"
            }
        })

    }

}