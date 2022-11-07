

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.productrecyclerlist.ProductDetail
import com.example.productrecyclerlist.R
import kotlinx.android.synthetic.main.product_list.view.*

class ProductAdapter(var productList: ArrayList<Product>, var context: Context, var img:IntArray): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list, parent,false)
        return ProductViewHolder(view)
    }

    @SuppressLint("DiscouragedApi")
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        holder.itemView.title.text = productList[position].title
        "Price: ${productList[position].price}".also { holder.itemView.price.text = it }
        "Color: ${productList[position].color}".also { holder.itemView.color.text = it }
        holder.itemView.image.setImageResource(img[position])
        holder.itemView.cv.setOnClickListener{
            Toast.makeText(context, "You clicked ${productList[position].title}", Toast.LENGTH_LONG).show()
            var detailIntent = Intent(context,ProductDetail::class.java)
            detailIntent.putExtra("image", img[position])
            detailIntent.putExtra("title", productList[position].title)
            detailIntent.putExtra("color", productList[position].color)
            detailIntent.putExtra("itemID", productList[position].itemid)
            detailIntent.putExtra("desc",productList[position].desc)
            context.startActivity(detailIntent)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}