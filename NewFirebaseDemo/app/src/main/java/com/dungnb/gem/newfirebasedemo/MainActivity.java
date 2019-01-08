package com.dungnb.gem.newfirebasedemo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
  DatabaseReference mDatabase;
  TextView tvKhoaHoc;
  Button btnAndroid, btnIos;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mDatabase = FirebaseDatabase.getInstance().getReference();
    addControls();
    addData();
    addEvents();
  }

  private void addControls() {
    tvKhoaHoc = findViewById(R.id.tvKhoaHoc);
    btnAndroid = findViewById(R.id.btnAndroid);
    btnIos = findViewById(R.id.btnIOS);
  }

  private void addData() {
    // Add database by field.
    mDatabase.child("ho_va_ten").setValue("Nguyễn Bá Dũng");
    // Add database by object.
    mDatabase.child("sinh_vien").setValue(new Student("Nguyễn Bá Dũng", "Hà Nội", "2000"));
    // Add to firebase by map .
    Map<String, Integer> myMap = new HashMap<>();
    myMap.put("xe_may", 2);
    mDatabase.child("phuong_tien").setValue(myMap);
    // Add to firebase database with push .
    Student hocvien = new Student("Lưu Hoàng ", "TP Hải Phòng", "1982");
    mDatabase.child("hoc_vien").push().setValue(hocvien);

    // Bắt sự kiện hoàn thành khi thêm dữ liệu .
    mDatabase.child("bai_hoc").setValue("Lập trình android với firebase", new DatabaseReference.CompletionListener() {
      @Override
      public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
        if (databaseError == null) {
          Toast.makeText(MainActivity.this, R.string.save_data_suggest, Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(MainActivity.this, R.string.save_data_error, Toast.LENGTH_SHORT).show();
        }
      }
    });

    // Firebase RealmTime

    mDatabase.child("khoa_hoc").setValue("Khoá học lập trình Android");
    mDatabase.child("khoa_hoc").addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists())
          tvKhoaHoc.setText(dataSnapshot.getValue().toString());
      }

      @Override
      public void onCancelled(@NonNull DatabaseError databaseError) {

      }
    });
  }

  private void addEvents() {
    btnAndroid.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mDatabase.child("khoa_hoc").setValue("Android");
      }
    });
    btnIos.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mDatabase.child("khoa_hoc").setValue("Ios");
      }
    });
  }
}
