package com.termx.engine

class TerminalEngine {
    companion object {
        init {
            System.loadLibrary("native-terminal")
        }
    }

    external fun stringFromJNI(): String
}
