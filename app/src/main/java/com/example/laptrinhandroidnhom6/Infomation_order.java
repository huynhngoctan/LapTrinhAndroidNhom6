package com.example.laptrinhandroidnhom6;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.laptrinhandroidnhom6.custom.Custom_Adapter_list_infor;
import com.example.laptrinhandroidnhom6.custom.Custom_Cart;
import com.example.laptrinhandroidnhom6.database.OrderDetailDB;
import com.example.laptrinhandroidnhom6.map.MyMapFragment;
import com.example.laptrinhandroidnhom6.model.ItemOfListOrder;
import com.example.laptrinhandroidnhom6.model.OrderDetail;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Infomation_order extends Activity implements OnMapReadyCallback {
    Button btnBack;
    ArrayList<ItemOfListOrder> listItem;
    TextView txtPrice;
    RadioGroup radioGroup;
    RadioButton raBtnCod,raBtnOnline;
    Button btnOrder;
    OrderDetailDB orderDetailDB;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_order);
        createListItemOrder();
//        btnBack = findViewById(R.id.btnReturn);
        //Tinh tong gia
        txtPrice = findViewById(R.id.sumPrice);

        txtPrice.setText(""+sumPrice());
        //thanh toan

        //dat hang
        btnOrder = findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                   orderDetailDB = new OrderDetailDB();
                   orderDetailDB.insertContact(new OrderDetail("21","kk",20,1));
                   noficeSuccess();
               }catch (Exception e){
                    noficeFail();
               }

            }
        });



        //list food
        ListView listView = findViewById(R.id.listViewOrder);

        Custom_Adapter_list_infor adapter = new Custom_Adapter_list_infor(listItem, this);
        listView.setAdapter(adapter);

        //map

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mymap);
        mapFragment.getMapAsync(this);
        //event btn back
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentBack = new Intent(Infomation_order.this,Cart.class);
//                startActivity(intentBack);
//            }
//        });
    }

    @Override
    public void onMapReady( GoogleMap googleMap) {
        LatLng syd  = new LatLng(-33.867,151.206);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(syd,13));
        googleMap.addMarker(new MarkerOptions().title("cuong")
        .snippet("cuong123")
                .position(syd)
        );
    }
    public void createListItemOrder() {
        listItem = new ArrayList<>();
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));

    }

    //tinh tong tien
    public int sumPrice(){
        int sum =0;
        for (int i=0 ;i<5;i++){
            sum += listItem.get(i).getPrice();
        }
        return sum;
    }

    //thong bao thanh cong
    public void noficeSuccess(){

        AlertDialog.Builder b = new AlertDialog.Builder(this);

        b.setTitle("Thông báo");
        b.setMessage("Đặt hàng thành công");

        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intentBack = new Intent(Infomation_order.this,MainActivity.class);
                startActivity(intentBack);
            }
        });


        AlertDialog al = b.create();

        al.show();
    }
    //thong bao thanh cong
    public void noficeFail(){

        AlertDialog.Builder b = new AlertDialog.Builder(this);

        b.setTitle("Thông báo");
        b.setMessage("Đặt hàng thất bại");

        b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });

        AlertDialog al = b.create();

        al.show();
    }
}
