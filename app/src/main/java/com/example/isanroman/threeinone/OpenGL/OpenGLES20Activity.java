package com.example.isanroman.threeinone.OpenGL;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

/**
 * Created by isanroman on 11/28/2016.
 */

public class OpenGLES20Activity extends Activity{

    private GLSurfaceView mGLView;

    @Override
    public void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);

        mGLView = new MyGLSurfaceView(this);
        setContentView(mGLView);
    }
}
