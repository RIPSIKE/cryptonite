

# Native code #
## Toolchain setup ##
  1. Get the current [android ndk](https://developer.android.com/sdk/ndk/index.html) (`r10` at the time of writing).
  1. Set up a standalone toolchain:
```
  $ cd ${HOME}/android-ndk-r10/build/tools
  $ rm -rf ${HOME}/android-toolchain
  # On Linux:
  $ ./make-standalone-toolchain.sh --arch=arm --ndk-dir=${HOME}/android-ndk-r10 --install-dir=${HOME}/android-toolchain --platform=android-8 --system=linux-x86_64 --toolchain=arm-linux-androideabi-4.8
  # On Mac:
  $ ./make-standalone-toolchain.sh --arch=arm --ndk-dir=${HOME}/android-ndk-r10 --install-dir=${HOME}/android-toolchain --platform=android-8 --system=darwin-x86_64 --toolchain=arm-linux-androideabi-4.8
```
  1. Get the agcc wrapper scripts, and make sure they're both in your path (e.g. in `/usr/local/bin`). You'll need to update them in case the NDK version has changed since your last build (e.g. from r8b to r8c).
```
  $ wget https://neurodroid.googlecode.com/git/nrn/agcc
  $ wget https://neurodroid.googlecode.com/git/nrn/agcc-vfp
  $ sudo mv agcc* /usr/local/bin
  $ sudo chmod +x /usr/local/bin/agcc*

```
  1. Then, get the latest Cryptonite code from the [git repository](https://code.google.com/p/cryptonite/source/checkout). `${CRYPTONITE}` will refer to the cryptonite source directory. It's strongly recommended to put it into `${HOME}/cryptonite` at this time because some build scripts use hard-coded references to this directory (someone come up with a solution please!).

**You'll need all dependencies listed below (Boost, OpenSSL, FUSE, rlog) to build EncFS and Cryptonite.**

## Boost ##
<a href='Hidden comment: Boost is no longer required since we updated to encfs 1.8.0.'></a>
  1. Download and patch Boost:
```
  $ cd ${CRYPTONITE}/boost
  $ ./download.sh
```
  1. Build Boost:
```
  $ ./build.sh
```

## OpenSSL ##
  1. Download OpenSSL:
```
  $ cd ${CRYPTONITE}/openssl
  $ ./download.sh
```
  1. Build OpenSSL:
```
  $ ./build.sh
```

## FUSE ##
  1. Build FUSE:
```
  $ cd ${CRYPTONITE}/fuse28
  $ ./build.sh
```

## rlog ##
  1. Download rlog:
```
  $ cd ${CRYPTONITE}/rlog
  $ ./download.sh
```
  1. Build rlog:
```
  $ ./build.sh
```
<a href='Hidden comment: 
==protobuf==
# Download protobuf:
```
  $ cd ${CRYPTONITE}/protobuf
  $ ./download.sh
```
# Build protobuf:
```
  $ ./build.sh
```

==tinyxml==
# Download tinyxml:
```
  $ cd ${CRYPTONITE}/tinyxml
  $ ./download.sh
```
# Build tinyxml:
```
  $ ./build.sh
```
'></a>
## EncFS ##
  1. Get GNU sed, automake and autoreconf (which is part of the autoconf package on most systems):
```
  # On Ubuntu:
  $ sudo apt-get install autoconf automake
  # On OS X:
  $ sudo port install gsed autoconf automake
```
  1. Download and patch EncFS:
```
  $ cd ${CRYPTONITE}/encfs-1.7.4
  $ ./download.sh
```
  1. Build EncFS:
```
  $ ./build.sh
```

You'll end up with a split version of the standalone encfs binary in `${CRYPTONITE}/cryptonite/assets/arm{-v7a}/`

## Cryptonite JNI ##
  1. Add the file `${CRYPTONITE}/cryptonite/jni/android_key.h` if you have it (contains the dropbox keys for this app). Otherwise you can do:
```
  $ ln -s ${CRYPTONITE}/cryptonite/jni/android_fake.h ${CRYPTONITE}/cryptonite/jni/android_key.h
```
  1. Build libcryptonite.so for armeabi and armeabi-v7a:
```
  $ cd ${CRYPTONITE}/cryptonite
  $ ./jni-build.sh
```

# Cryptonite app #
## Dependencies ##
  1. Install the [Android SDK](https://developer.android.com/sdk/index.html) for your platform.
  1. Download and unzip [ActionBarSherlock](http://actionbarsherlock.com/) and rename the directory to `${HOME}/ActionBarSherlock`. In Eclipse do "File -> New -> Android Project -> Create project from existing source" and select the `actionbarsherlock` dir. If you have lot of errors, check if the project Java compliance is set to 1.6 (Project -> Properties -> Java Compiler).
  1. Download the [Dropbox Android SDK](https://www.dropbox.com/developers/reference/sdk) and put the unzipped jars (dropbox-android-sdk-x.y.z.jar, httpmime-x.y.z.jar, json\_simple.jar) into the `${CRYPTONITE}/cryptonite/libs` folder.

## Cryptonite ##
Start a new Android project from existing code in Eclipse using `${CRYPTONITE}/cryptonite` as the root directory. Then go to "Configure Build Path -> Add JARs" and add Dropbox SDK jars.

If you don't have the Dropbox keys, generate fake ones:
```
$ cd ${CRYPTONITE}/cryptonite
$ echo "db-xxxxxxxxxxxxxxx" > AndroidManifest.xml.key
$ echo "db-xxxxxxxxxxxxxxx" > AndroidManifest.xml.key2
$ cd ..
```

Then, insert the keys into AndroidManifest.xml:
```
$ cd ${CRYPTONITE}
$ ./insert_key.sh
```

Make sure that you set the compiler compliance level to 1.6 (Project settings -> Java compiler).

Alternatively, build from the command line. First, generate `${CRYPTONITE}/cryptonite/build.xml` if you don't have it yet (`android` is located in the `tools` subdirectory of the Android SDK):
```
$ cd ${CRYPTONITE}/cryptonite
$ android update project --path .
```
The `.` at the end of the line is intentional. Then, generate an Android package:
```
$ cd ${CRYPTONITE}/cryptonite
$ ant debug
```
This will produce an apk in `${CRYPTONITE}/cryptonite/bin/cryptonite-debug.apk`

# TrueCrypt #
TrueCrypt is shipped as a standalone binary with the Cryptonite apk. It's not required for the GUI and the EncFS part to work. Conversely, you can use the TrueCrypt binary independently of the Cryptonite app.
## FUSE ##
Get the official ndk and build FUSE [as described above](https://code.google.com/p/cryptonite/wiki/BuildInstructions#FUSE). You won't need any of the other libraries for TrueCrypt.

## wxWidgets ##
  1. Download and patch wxWidgets:
```
  $ cd ${CRYPTONITE}/wx
  $ ./download.sh
```
  1. Build wxWidgets:
```
  $ ./build.sh
```

## TrueCrypt ##
  1. Get the [TrueCrypt source distribution](http://www.truecrypt.org/downloads2) and save it under `${CRYPTONITE}/tc/`
  1. Extract and patch the source and get some additional header files:
```
  $ cd ${CRYPTONITE}/tc
  $ ./patch.sh
```
  1. Build TrueCrypt:
```
  $ ./build.sh
```

The truecrypt binary will be located in `${CRYPTONITE}/tc/truecrypt-7.1a-source/Main/truecrypt`. You can push it directly to the Cryptonite app directory if you have a rooted phone:
```
$ adb root
$ adb push ${CRYPTONITE}/tc/truecrypt-7.1a-source/Main/truecrypt /data/data/csh.cryptonite
```

And then test whether it's working:
```
adb shell
# cd /data/data/csh.cryptonite
# ./truecrypt
```
This should print some usage information if everything went well.