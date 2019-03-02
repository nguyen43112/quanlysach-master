package com.tiennvph06776.bookmanager.project.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tiennvph06776.bookmanager.project.R;

public class DangKyActivity extends AppCompatActivity {

    private TextView tvDangNhap;
    private Button btnDangKy;
    private AutoCompleteTextView edtTenDangNhap;
    private EditText edtMatKhau;
    private EditText edtNhapLaiMatKhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        tvDangNhap = (TextView) findViewById(R.id.tvDangNhap);
        btnDangKy = (Button) findViewById(R.id.btnDangKy);
        edtTenDangNhap = (AutoCompleteTextView) findViewById(R.id.edtTenDangNhap);
        edtMatKhau = (EditText) findViewById(R.id.edtMatKhau);
        edtNhapLaiMatKhau = (EditText) findViewById(R.id.edtNhapLaiMatKhau);
        tvDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtTenDangNhap.getText().toString().trim();
                if(username.matches("")){
                    edtTenDangNhap.setError(getString(R.string.notify_empty_user_name));
                    return;
                }
                String password=edtMatKhau.getText().toString().trim();
                if(password.matches("")){
                    edtMatKhau.setError(getString(R.string.notify_empty_pass));
                    return;
                }
                if(password.length()<6){
                    edtMatKhau.setError(getString(R.string.notify_min_pass));
                    return;
                }
                String confimpassword=edtNhapLaiMatKhau.getText().toString().trim();
                if(confimpassword.matches("")){
                    edtNhapLaiMatKhau.setError(getString(R.string.notify_empty_pass));
                    return;
                }
                if(username!=null&&password!=null&&confimpassword!=null){
                    Intent intent=new Intent(getApplicationContext(),ActivityHome.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(DangKyActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(DangKyActivity.this, "Mời điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
