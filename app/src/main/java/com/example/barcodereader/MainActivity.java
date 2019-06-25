package com.example.barcodereader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import info.androidhive.barcode.BarcodeReader;

public class MainActivity extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {
    private static final String TAG = "MainActivity";
    private BarcodeReader barcodeReader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_fragment);

    }

    @Override
    public void onScanned(Barcode barcode) {
//        Toast.makeText(this, barcode.displayValue, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onScanned: " + barcode.displayValue);
        barcodeReader.playBeep();
    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {
        for (int i = 0; i < barcodes.size(); i++) {
        Log.d(TAG, "onScannedMultiple: "+ barcodes.get(i).displayValue);
        }

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String errorMessage) {
        Log.e(TAG, "onScanError: "+ errorMessage);
    }

    @Override
    public void onCameraPermissionDenied() {

    }
}
