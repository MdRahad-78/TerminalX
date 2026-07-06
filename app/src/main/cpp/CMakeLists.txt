cmake_minimum_required(VERSION 3.22.1)
project("terminalx")

add_library(native-terminal SHARED
    terminal.c
    x11_server.c
)

find_library(log-lib log)
find_library(EGL-lib EGL)
find_library(GLESv2-lib GLESv2)

target_link_libraries(native-terminal
    ${log-lib}
    ${EGL-lib}
    ${GLESv2-lib}
)
