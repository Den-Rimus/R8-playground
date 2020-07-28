package com.example.r8testplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.example.r8playgroundlib.Alice
import com.example.r8playgroundlib.Bar
import com.example.r8playgroundlib.Bob
import com.example.r8playgroundlib.SomeOtherClass

class MainActivity : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)

      // Alice class name should be kept due to rule packaged in R8_playground_library consumer-rules.pro file!!!
      val worksCorrectly = Alice::class.java.simpleName == "Alice"
      showToast(if (worksCorrectly) "Works correctly!  $funSmile" else "Something went wrong!  $sadSmile")

      val myDerivedFoo = object : Bar.DerivedFoo {
         override fun handle(result: SomeOtherClass<Alice, Bob>): Boolean {
            return true
         }
      }
   }

   private fun showToast(message: String) {
      Toast.makeText(this, message, LENGTH_LONG).show()
   }

   companion object {

      const val funSmile = "\uD83C\uDF89" // 🎉
      const val sadSmile = "\uD83D\uDE12" // 😒
   }
}
