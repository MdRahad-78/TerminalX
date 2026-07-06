#include <jni.h>
#include <android/log.h>
#include <EGL/egl.h>
#include <GLES2/gl2.h>

#define LOG_TAG "TerminalX-Native"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

JNIEXPORT jstring JNICALL
Java_com_termx_engine_TerminalEngine_stringFromJNI(JNIEnv *env, jobject thiz) {
    LOGI("Native terminal engine initialized");
    return (*env)->NewStringUTF(env, "TerminalX Native Engine v0.1");
}
