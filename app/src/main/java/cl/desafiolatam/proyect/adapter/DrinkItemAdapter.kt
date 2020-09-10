package cl.desafiolatam.proyect.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.proyect.R
import cl.desafiolatam.proyect.room.DrinkEntity
import com.squareup.picasso.Picasso
import java.util.ArrayList

class DrinkItemAdapter( val data: ArrayList<DrinkEntity>) : RecyclerView.Adapter<DrinkItemAdapter.CustomViewHolder>(){

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTitle: TextView = itemView.findViewById(R.id.name1)
        val mImgPost: ImageView = itemView.findViewById(R.id.image)
        //val mDesc : TextView = itemView.findViewById(R.id.name2)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return CustomViewHolder(itemView)
    }



    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.mTitle.text = data[position].nombre
       // holder.mDesc.text = data[position].thumbnail

       // val img1 = data[position].thumbnail, es para imagen sour

      //  Picasso.get()
      //      .load(img1)
        //    .into(holder.mImgPost)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}