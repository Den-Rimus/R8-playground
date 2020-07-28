package com.example.r8testplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.r8playgroundlib.Alice
import com.example.r8playgroundlib.Bar
import com.example.r8playgroundlib.Bob
import com.example.r8playgroundlib.SomeOtherClass

class MainActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)

      val myDerivedFoo = object : Bar.DerivedFoo {

         override fun handle(result: SomeOtherClass<Alice, Bob>): Boolean {
            val worksCorrectly = this.javaClass.simpleName == "DerivedFoo"

            if (worksCorrectly.not()) {
               showToast(this.javaClass.simpleName)
            } else {
               showToast(worksCorrectly.toString())
            }
            return true
         }
      }

      myDerivedFoo.handle(SomeOtherClass.Success(Alice()))
   }

   private fun showToast(message: String) {
      Toast.makeText(this, message, LENGTH_SHORT).show()
   }
}
