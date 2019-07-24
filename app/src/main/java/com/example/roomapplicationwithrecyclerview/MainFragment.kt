package com.example.roomapplicationwithrecyclerview


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.roomapplicationwithrecyclerview.adapters.RecordsAdapter
import com.example.roomapplicationwithrecyclerview.database.RecordEntity
import com.example.roomapplicationwithrecyclerview.database.RecordsDB
import com.example.roomapplicationwithrecyclerview.databinding.FragmentMainBinding
import com.example.roomapplicationwithrecyclerview.dialogs.StringDataDialog
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    private var viewModel:ColumnsViewModel ? = null
    private var adapter:RecordsAdapter? = null

    private var list:List<RecordEntity>? = null

    var db: RecordsDB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = Room
            .databaseBuilder(
                requireContext(),
                RecordsDB::class.java,
                "Records")
            .allowMainThreadQueries()
            .build()

        promptData()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding:FragmentMainBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        viewModel = ColumnsViewModel(this)
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = db!!.recordDao().getAll()
        adapter = RecordsAdapter(list!!)
        rvRecords.layoutManager = LinearLayoutManager(context)
        rvRecords.adapter = adapter
    }

    fun promptData(){

        db!!.recordDao().deleteAll()
        val list:MutableList<RecordEntity> = emptyList<RecordEntity>().toMutableList()

        list.add(RecordEntity(564564,"test1","31-01","12:0","user2" , "room3"))
        list.add(RecordEntity(335553,"test5","30-04","15:0","user4" , "room1") )
        list.add(RecordEntity(243533,"test3","01-01","16:0","user5" , "room5"))
        list.add(RecordEntity(53353423,"test2","23-01","11:0","user0" , "room10"))

        db!!.recordDao().insertAll(list)

    }

    private fun updateAdapter(adapter:RecordsAdapter){

        rvRecords.adapter =adapter
        rvRecords.adapter!!.notifyDataSetChanged()
    }

    fun showDialog(columnName: String){
        val dialog:StringDataDialog = StringDataDialog.newInstance(this,columnName)
        dialog.isCancelable = false
        dialog.show(fragmentManager!!, DIALOG_TAG)

    }


    fun filterByDate(date:String){

        list = db!!.recordDao().filterRecordByDate(date)
        adapter = RecordsAdapter(list!!)

        updateAdapter(adapter!!)
    }

    fun fiterByHour(hour:String){
        list = db!!.recordDao().filterRecordByHour(hour)
        adapter = RecordsAdapter(list!!)

        updateAdapter(adapter!!)

    }

    fun filterByName(name:String){

        list = db!!.recordDao().filterRecordsByName(name)
        adapter = RecordsAdapter(list!!)

        updateAdapter(adapter!!)


    }

    fun filterByUser(user:String){

        list = db!!.recordDao().filterRecordByUser(user)
        adapter = RecordsAdapter(list!!)

        updateAdapter(adapter!!)
    }

    fun filterByLocalName(local:String){

        list = db!!.recordDao().filterRecordByLocal(local)
        adapter = RecordsAdapter(list!!)

        updateAdapter(adapter!!)
    }



    companion object {


        val DIALOG_TAG = "search_dialog"
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {

            }
    }
}
