import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.wangxiao.a08_listview.R

/**
 * Created by wangxiao on 2017/6/5.
 */
class FruitAdapter2: RecyclerView.Adapter<FruitAdapter2.ViewHolder> {

    var mFruitList: List<Fruit>

    inner class ViewHolder: RecyclerView.ViewHolder {
        var fruitView: View
        var fruitImage: ImageView
        var fruitNme: TextView

        constructor(view: View):super(view) {
            fruitView = view
            fruitImage = view.findViewById(R.id.fruit_image) as ImageView
            fruitNme = view.findViewById(R.id.fruit_name) as TextView
        }
    }

    constructor(furitList: List<Fruit> ) {
        this.mFruitList = furitList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item2, parent, false)
        var holder = ViewHolder(view)

        holder.fruitImage.setOnClickListener {
            var position = holder.adapterPosition
            val fruit = mFruitList.get(position)
            Toast.makeText(view.context, "You clicked view" + fruit.name, Toast.LENGTH_SHORT).show()
        }

        holder.fruitView.setOnClickListener {
            var position = holder.adapterPosition
            val fruit = mFruitList.get(position)
            Toast.makeText(view.context, "You clicked view" + fruit.name, Toast.LENGTH_SHORT).show()
        }


        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var fruit = mFruitList.get(position)
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitNme.setText(fruit.name)
    }

    override fun getItemCount(): Int {
        return mFruitList.size
    }
}