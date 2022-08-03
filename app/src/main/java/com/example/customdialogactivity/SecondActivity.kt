package com.example.customdialogactivity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.example.customdialogactivity.databinding.ActivityMainBinding
import com.example.customdialogactivity.databinding.ActivitySecondBinding
import com.example.customdialogactivity.databinding.CustomdialogBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener{
         var dialogBinding = CustomdialogBinding.inflate(layoutInflater)
            var dialog = Dialog(this)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
            dialogBinding.etName.setText(binding.tvName2.text.toString())
            dialogBinding.etAge.setText(binding.tvAge2.text.toString())
               dialogBinding.btnSubmit.setOnClickListener{
                   dialogBinding.rgGender.setOnCheckedChangeListener { group, id ->
                       when(id) {
                           R.id.rbOther -> dialogBinding.etDescription.visibility = View.VISIBLE
                           else -> {
                               dialogBinding.etDescription.visibility = View.GONE
                           }
                       }
                   }
                   if(dialogBinding.etName.text.toString().isNullOrEmpty()){
                       Toast.makeText(this,"Enter name",Toast.LENGTH_SHORT).show()
                   }
                   else if(dialogBinding.etAge.text.toString().isNullOrEmpty()){
                       Toast.makeText(this,"Enter Age",Toast.LENGTH_SHORT).show()
                   }
                  else if(dialogBinding.rbOther.isChecked&&dialogBinding.etDescription.text.toString().isNullOrEmpty()){
                       Toast.makeText(this,"Enter description",Toast.LENGTH_SHORT).show()
                   }
                   else{

                       binding.tvName2.setText(dialogBinding.etName.text.toString())
                       binding.tvAge2.setText(dialogBinding.etAge.text.toString())
                       if(dialogBinding.rbHe.isChecked){
                           binding.tvGender2.setText("He")
                       }
                       else if(dialogBinding.rbShe.isChecked){
                           binding.tvGender2.setText("She")
                       }
                       else {
                           binding.tvGender2.setText("Other")
                       }
                       dialog.dismiss()
                   }


               }
                   dialog.show()
        }

    }
}