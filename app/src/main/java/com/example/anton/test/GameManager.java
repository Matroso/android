package com.example.anton.test;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

public class GameManager {
    private static final int MAX_CIRCLES_ENEMY = 10;
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> circles;
    private CanvasView canvasView;
    private static int width;
    private static int height;


    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
        initEnemyCircle();
    }

    private void initEnemyCircle() {
        circles = new ArrayList<EnemyCircle>();
        for (int i = 0; i < MAX_CIRCLES_ENEMY ; i++) {
            circles.add(EnemyCircle.getRandomCircle());
        }
    }

    public static int getWidth() {
        return  width;
    }

    public static int getHeight() {
        return height;
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }


    public void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle: circles) {
            canvasView.drawCircle(circle);
        }
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
    }
}
