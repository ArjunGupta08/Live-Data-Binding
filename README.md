# Live Data Binding (One Way and Two Way)

Here I'm going to show you how to implement one way and two binding

First you have to enable :



buildFeatures{

     dataBinding true

}



And implement the dependency of viewModel and LiveData in your build.gradele (app module)



// ViewModel    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")   

 // LiveData    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")}



Now convert your XML layout into dataBinding layout



Let's start with one way dataBinding :



One way binding with data class :



After completing initial steps create an data class,

We will bind data directly from this data class to our XML layout.

data class example :



data class Quote(val text : String)



Now creat an variable in your  XML layout 



    <data>



          <variable

                 name="oneWay"

                 type="com.arjun.livedatabinding.Quote" />



    </data>



Now bind your XML layout Views with this data class variable.



           <Textview

                   android:text="@{oneWay.text}" />



Now initialise data class and this data variable into your mainActivity :

            

val quoteData =Quote("it is oneWay Text, \nbelow You can see the example of two way")



binding.oneWay = quoteData



Here oneWay binding with data class is done. You can run this application!



One way binding with ViewModel() :



Create an  MainViewModel class for your mainActivity



Ex :



class MainViewModel : ViewModel() {

    val factsLiveDataObject = MutableLiveData<String>("This is a fact")



 fun updatedData(){
        factsLiveDataObject.value = "This task has been updated"
    }



Now create another variable of MainViewModel class in XML layout.



   <data>
     <variable
            name="mainViewModel"
     type="com.arjun.livedatabinding.MainViewModel"/>           

    

      <variable
            name="oneWay"
            type="com.arjun.livedatabinding.Quote" />
    </data>



Now initialise this viewModel class and viewModel variable into your mainActivity



lateinit var mainViewModel : MainViewModel



mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)



binding.mainViewModel = mainViewModel

binding.lifecycleOwner = this





Two way binding :



To implement two way data binding you just have to do one extra step in your XML layout :



<Edit text

           android:text="@={mainViewModel.factsLiveDataObject}"

 />



That's it 




