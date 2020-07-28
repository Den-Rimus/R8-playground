
# <common_rules>
    -dontshrink
    -ignorewarnings
    -renamesourcefileattribute SourceFile
    -keepattributes SourceFile,LineNumberTable,*Annotation*,Signature,InnerClasses,EnclosingMethod,MethodParameters

    -keep enum * { public *; }

    -keep class * implements android.os.Parcelable {*;}

    -keep public class com.example.**.BuildConfig { *; }

    -keepnames class * implements android.os.Parcelable {
        public static final ** CREATOR;
    }

    -keepclasseswithmembernames class * {
        native <methods>;
    }
# </common_rules>

# <library_rules>
    -keeppackagenames com.example.**
    -keep public interface com.example.r8playgroundlib.BaseFoo { *; }
    -keep public class com.example.r8playgroundlib.Bar { *; }
    -keep public class com.example.r8playgroundlib.SomeOtherClass { *; }
    -keep public class com.example.r8playgroundlib.SomeOtherClass$* { *; }
    -keep public class com.example.r8playgroundlib.Alice { *; }
    -keep public class com.example.r8playgroundlib.Bob { *; }
    -keep public interface com.example.r8playgroundlib.Bar$DerivedFoo { *; }
# </library_rules>
