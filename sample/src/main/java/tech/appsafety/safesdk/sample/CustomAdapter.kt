package tech.appsafety.safesdk.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

/**
 * Provide views to RecyclerView with data from dataSet.
 *
 * Initialize the dataset of the Adapter.
 **/
class CustomAdapter :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>(),
    DiffUpdateAdapter {

    companion object {
        private val TAG = "CustomAdapter"
    }

    var dataSet: List<Data> by Delegates.observable(emptyList()) { _, oldValue, newValue ->
        autoNotify(oldValue, newValue) { o, n -> o == n }
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val title: TextView = v.findViewById(R.id.title)
        val status: ImageView = v.findViewById(R.id.status)
        val lvlOfConfidence: TextView = v.findViewById(R.id.confidence_lvl)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_item, viewGroup, false)

        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.title.text = dataSet[position].title
        viewHolder.status.setImageResource(
            when {
                dataSet[position].percentage == 0 -> R.drawable.ic_error_24
                dataSet[position].check -> R.drawable.ic_block_24
                else -> R.drawable.ic_check_24
            }
        )
        viewHolder.lvlOfConfidence.text = "(${dataSet[position].percentage}%)"
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}