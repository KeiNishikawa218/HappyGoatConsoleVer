#!/bin/sh

echo "ブログラムをビルドします。\nnow building ..."

# OpenCV込みのビルドを行う
#javac -cp /usr/local/Cellar/opencv/4.5.2_4/share/java/opencv4/opencv-452.jar WriteLetter.java
javac -classpath /Users/kei/.m2/repository/org/openpnp/opencv/4.5.1-2/opencv-4.5.1-2.jar WriteLetter

echo "build succeeded\n"

echo "ブログラムを実行します。\nnow  running ...\n"

# 実行
# OK
java -Djava.library.path="/usr/local/Cellar/opencv/4.5.2_4/share/java/opencv4" -classpath /usr/local/Cellar/opencv/4.5.2_4/share/java/opencv4/opencv-452.jar: WriteLetter


# NG
#java -Djava.library.path="/Users/kei/.m2/repository/org/openpnp/opencv/4.5.1-2" -classpath /Users/kei/.m2/repository/org/openpnp/opencv/4.5.1-2/opencv-4.5.1-2.jar: WriteLetter
