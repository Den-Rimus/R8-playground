package com.example.r8testplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.r8playgroundlib.Alice
import com.example.r8playgroundlib.Bar
import com.example.r8playgroundlib.Bob
import com.example.r8playgroundlib.SomeOtherClass

class MainActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)

      val myDerivedFoo = object : Bar.DerivedFoo {

         override fun handle(result: SomeOtherClass<D, E>): Boolean {
         }
      }
   }
}
