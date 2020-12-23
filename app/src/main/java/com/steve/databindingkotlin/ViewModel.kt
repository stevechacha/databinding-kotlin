package com.steve.databindingkotlin
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

class ViewModel : ViewModel() {
    var textData=MutableLiveData<String>()
    var btnText=MutableLiveData<String>()
    var editText=MutableLiveData<String>()
    var error=MutableLiveData<String>()
    var  emailText=MutableLiveData<String>()
    var imageUrl=MutableLiveData<String>()

    fun onClick(view: View){
        textData.value="Text success"
        btnText.value="Done"

    }

//    app:textwatcher="@{viewmodel.emailTextWatcher}"(place it it editText when using Textwatcher)
////    var emailTextWatcher:TextWatcher=object : TextWatcher{
////        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
////         }
////        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
////            Log.d("Textwacher:",s.toString())
////        }
////        override fun afterTextChanged(s: Editable?) {
////        }
////    }

    fun isEmailValid(email: String?):Boolean{
        val expression= ("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$")
        val pattern: Pattern= Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher:Matcher=pattern.matcher(email)
        return matcher.matches()
    }

}