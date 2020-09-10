package cl.desafiolatam.proyect.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.proyect.R
import cl.desafiolatam.proyect.livedata.DrinkViewModel
import cl.desafiolatam.proyect.retrofit.DrinkRetrofitClient
import cl.desafiolatam.proyect.room.DrinkEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    private val viewModel: DrinkViewModel by lazy {
        ViewModelProviders.of(this, DrinkViewModel.Factory(application))
            .get(DrinkViewModel::class.java)
    }
    internal lateinit var adapter : DrinkItemAdapter
    internal lateinit var recyclerView: RecyclerView
    internal lateinit var coordinatorLayout: CoordinatorLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerHero)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)

        viewModel.AllDrinkItem.observe(this, Observer{drink->drink.let{


            loadApiData()
        } })

    }

private fun loadApiData(){
    val service = DrinkRetrofitClient.retrofitInstance()
    val call = service.getAllDrink()

    //Async
    call.enqueue(object : Callback<ArrayList<DrinkEntity>> {
        override fun onResponse(call: Call<ArrayList<DrinkEntity>>, response: Response<ArrayList<DrinkEntity>>) {

            val postsFromApi = response.body()

            if (postsFromApi != null) {
                adapter = DrinkItemAdapter(postsFromApi)
                recyclerView.adapter = adapter


            }
        }



        override fun onFailure(call: Call<ArrayList<DrinkEntity>>, t: Throwable) {
            Log.d("MAIN", "Error:$t")
            Toast.makeText(
                applicationContext,
                "Error: no pudimos recuperar los posts desde el api",
                Toast.LENGTH_SHORT
            ).show()
        }
    })



}
}

