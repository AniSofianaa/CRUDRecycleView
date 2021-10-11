package com.example.crudrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var inputNis:EditText
    private lateinit var inputNama:EditText
    private lateinit var jkLakiLaki:RadioButton
    private lateinit var jkPerempuan:RadioButton
    private lateinit var btnTambah:Button
    private lateinit var recyclerView:RecyclerView
    private lateinit var recycleAdapter:RecyclerView.Adapter<*>
    private lateinit var viewManager:RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNis = findViewById(R.id.txtInputNis)
        inputNama = findViewById(R.id.txtInputNama)
        jkLakiLaki = findViewById(R.id.rblakilaki)
        jkPerempuan = findViewById(R.id.rbPerempuan)
        btnTambah = findViewById(R.id.btnTambah)
        recyclerView = findViewById(R.id.listData)
        // membuat variabel kosong tipe array Mutablelist untuk simpan data array
        // data array disimpan di data class Siswadata
        var data = mutableListOf<SiswaData>()
        viewManager = LinearLayoutManager(this)
        recycleAdapter = SiswaAdapter(data)
        recyclerView.adapter = recycleAdapter
        recyclerView.layoutManager = viewManager
        //setOnClickListener untuk tombol Tambah Data
        btnTambah.setOnClickListener {
            //1. membuat variabel penyimpan data
            val nis = inputNis.text.toString()
            val nama = inputNama.text.toString()
            var jk =""
            if (jkLakiLaki.isChecked){
                jk= "Laki-Laki"
            }else {
                jk = "Perempuan"
            }
            // simpan data ke array mutableList
            val dataSiswa = SiswaData(nis,nama, jk)
            data.add(dataSiswa)
            recycleAdapter.notifyDataSetChanged()
        }
    }
}