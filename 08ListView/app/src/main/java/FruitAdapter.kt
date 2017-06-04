import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.wangxiao.a08_listview.R

/**
 * Created by wangxiao on 2017/6/4.
 */
public class FruitAdapter: ArrayAdapter<Fruit> {

    var resurceId: Int


    constructor(context: Context, resource: Int ,textViewResourceId: Int, objects: List<Fruit>): super(context, resource, textViewResourceId, objects) {
        this.resurceId = resource
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var fruit: Fruit = getItem(position)

        var view = convertView

        if (view == null) {
            var view = LayoutInflater.from(context).inflate(resurceId, parent, false)
        }
//        var view = LayoutInflater.from(context).inflate(resurceId, parent, false)

        val fruiteImage: ImageView = view?.findViewById(R.id.fruit_image) as ImageView
        val fruitName: TextView = view?.findViewById(R.id.fruit_name) as TextView

        fruiteImage.setImageResource(fruit.imageId)
        fruitName.setText(fruit.name)
        println("================= ${fruit.name}")

        return view
    }

}