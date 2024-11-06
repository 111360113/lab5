package com.example.lab5

import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val dialog: androidx.appcompat.app.AlertDialog.Builder =
                androidx.appcompat.app.AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("請選擇功能")
            dialog.setMessage("請根據下方按鈕選擇要顯示的物件")

            dialog.setNeutralButton("取消",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(
                        this@MainActivity,
                        "dialog關閉",
                        Toast.LENGTH_SHORT
                    ).show()
                })

            dialog.setNegativeButton("自定義Toast",
                DialogInterface.OnClickListener { dialogInterface, i -> showToast() })

            dialog.setPositiveButton("顯示list",
                DialogInterface.OnClickListener { dialogInterface, i -> showListDialog() })
            dialog.show()
        }
    }

    private fun showToast() {
        val toast = Toast(this@MainActivity)
        toast.setText("message")
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.duration = Toast.LENGTH_SHORT
        val inflater: LayoutInflater = getLayoutInflater()
        val layout = inflater.inflate(
            R.layout.custom_toast,
            findViewById(R.id.custom_toast_root)
        )
        toast.setView(layout)
        toast.show()
    }

    private fun showListDialog() {
        val list = arrayOf("message1", "message2", "message3", "message4", "message5")
        val dialog_list: androidx.appcompat.app.AlertDialog.Builder =
            androidx.appcompat.app.AlertDialog.Builder(
                this@MainActivity
            )
        dialog_list.setTitle("使用List呈現")
        dialog_list.setItems(list,
            DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(
                    this@MainActivity, "您選擇的是" + list[i],
                    Toast.LENGTH_SHORT
                ).show()
            })
        dialog_list.show()
    }
}