package com.example.isanroman.threeinone.OpenGL;

import android.content.Context;
import android.opengl.GLSurfaceView;

import com.example.isanroman.threeinone.OpenGL.MyGLRenderer;

/**
 * Created by isanroman on 11/28/2016.
 */

public class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer mRenderer;

    public MyGLSurfaceView(Context context){
        super(context);

        setEGLContextClientVersion(2);
        mRenderer = new MyGLRenderer();
        setRenderer(mRenderer);
    }
}