package com.horizontalscrollviewdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableRow.LayoutParams wrapWrapTableRowParams = new TableRow.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        int fixedColumnWidth = 20;
        int scrollableColumnWidth = 20;
        int fixedRowHeight = 110;
        int fixedHeaderHeight = 120;

        TableLayout fixedColumn = (TableLayout) findViewById(R.id.fixed_column);
        //rest of the table (within a scroll view)
        TableLayout scrollablePart = (TableLayout) findViewById(R.id.scrollable_part);

        TableRow row = new TableRow(this);
        //header (fixed vertically)
        TableLayout header = (TableLayout) findViewById(R.id.table_header);
        row.setLayoutParams(wrapWrapTableRowParams);
        row.setGravity(Gravity.CENTER);
        row.setBackgroundColor(Color.GRAY);
        row.addView(buildRowWithText("col 1", fixedColumnWidth, fixedHeaderHeight));
        fixedColumn.addView(row);
        row = new TableRow(this);
        row.addView(buildRowWithText("col 2", fixedColumnWidth, fixedHeaderHeight));
        row.addView(buildRowWithText("col 3", fixedColumnWidth, fixedHeaderHeight));
        row.addView(buildRowWithText("col 4", fixedColumnWidth, fixedHeaderHeight));
        row.addView(buildRowWithText("col 5", fixedColumnWidth, fixedHeaderHeight));
        row.addView(buildRowWithText("col 6", fixedColumnWidth, fixedHeaderHeight));
        row.addView(buildRowWithText("col 7", fixedColumnWidth, fixedHeaderHeight));
        row.addView(buildRowWithText("col 8", fixedColumnWidth, fixedHeaderHeight));
        row.addView(buildRowWithText("col 9", fixedColumnWidth, fixedHeaderHeight));
        row.addView(buildRowWithText("col 10", fixedColumnWidth, fixedHeaderHeight));
        row.addView(buildRowWithText("col 11", fixedColumnWidth, fixedHeaderHeight));


        // header.addView(row);
        //header (fixed horizontally)
        row.setBackgroundColor(Color.GRAY);
        scrollablePart.addView(row);
        for(int i = 0; i < 10; i++) {
            TextView fixedView = buildRowWithText("row " + i, scrollableColumnWidth, fixedRowHeight);
            fixedView.setBackgroundColor(Color.WHITE);
            fixedColumn.addView(fixedView);
            row = new TableRow(this);
            row.setLayoutParams(wrapWrapTableRowParams);
            row.setGravity(Gravity.CENTER);
            row.setBackgroundColor(Color.WHITE);
            row.addView(buildRowWithText("value 2", scrollableColumnWidth, fixedRowHeight));
            row.addView(buildRowWithText("value 3", scrollableColumnWidth, fixedRowHeight));
            row.addView(buildRowWithText("value 4", scrollableColumnWidth, fixedRowHeight));
            row.addView(buildRowWithText("value 5", scrollableColumnWidth, fixedRowHeight));
            row.addView(buildRowWithText("value 6", scrollableColumnWidth, fixedRowHeight));
            row.addView(buildRowWithText("value 7", scrollableColumnWidth, fixedRowHeight));
            row.addView(buildRowWithText("value 8", scrollableColumnWidth, fixedRowHeight));
            row.addView(buildRowWithText("value 9", scrollableColumnWidth, fixedRowHeight));
            row.addView(buildRowWithText("value 10", scrollableColumnWidth, fixedRowHeight));
            row.addView(buildRowWithText("value 11", scrollableColumnWidth, fixedRowHeight));

            scrollablePart.addView(row);
        }

    }


    private TextView recyclableTextView;

    public TextView buildRowWithText(String text, int widthInPercentOfScreenWidth, int fixedHeightInPixels) {
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        recyclableTextView = new TextView(this);
        recyclableTextView.setText(text);
        recyclableTextView.setTextColor(Color.BLACK);
        recyclableTextView.setTextSize(18);
        recyclableTextView.setWidth(widthInPercentOfScreenWidth * screenWidth / 100);
        recyclableTextView.setHeight(fixedHeightInPixels);
        return recyclableTextView;
    }

}
