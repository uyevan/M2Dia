[![ko-fi](https://www.ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/R6R21LO82)

# M2Dia

<div align="center">
    <img src="https://pan.losfer.cn/view.php/911f908b42b9c15bfcf1543cb45f33d8.png">
</div>

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
    ...
    implementation 'com.github.GrenderG:Toasty:1.5.2'
}
```

## Configuration

Context, title, and type must be assigned, and other parameters can be customized and implemented. Place this anywhere in your app:

```java
Toasty.Config.getInstance()
    .tintIcon(boolean tintIcon) // optional (apply textColor also to the icon)
    .setToastTypeface(@NonNull Typeface typeface) // optional
    .setTextSize(int sizeInSp) // optional
    .allowQueue(boolean allowQueue) // optional (prevents several Toastys from queuing)
    .setGravity(int gravity, int xOffset, int yOffset) // optional (set toast gravity, offsets are optional)
    .supportDarkTheme(boolean supportDarkTheme) // optional (whether to support dark theme or not)
    .setRTL(boolean isRTL) // optional (icon is on the right)
    .apply(); // required
```

When you want to close it, you can define an M2Dia class variable and implement the following methods:

```java
private M2Dia m2Dia;
...
m2Dia = M2Dia.createError(MainActivity.this, getString(R.string.error_title), M2Dia.M2ButTpe.NO_CLOSE_BUT)
                        .showM2();
...
m2Dia.dismiss();
```

## Usage

Each method always returns a `Toast` object, so you can customize the Toast much more. **DON'T FORGET THE `show()` METHOD!**

Have confirm and close button:

```java
M2Dia.createWarning(MainActivity.this, getString(R.string.warning_title), M2Dia.M2ButTpe.HAVE_ALL_BUT)
                        .showM2();
```

Have confirm button ,no have close button:

```java
M2Dia.createError(MainActivity.this, getString(R.string.error_title), M2Dia.M2ButTpe.NO_CLOSE_BUT)
                        .showM2();
```

### The Me Email

[I am evan !](https://jfkj.xyz)

**You can contact me at my personal center.**

uyevan@163.com

## Screenshots

###### gif

<img title="" src="https://pan.losfer.cn/view.php/96e453d85b91c934f2f6313bcbcd45b7.gif" alt="" width="221" data-align="center">



###### img

<img title="" src="https://pan.losfer.cn/view.php/a649e8418926da7df8e957703e369afa.jpg" alt="" width="219" data-align="center">

<img title="" src="https://pan.losfer.cn/view.php/1e657818d594831f94722e6f442cb3d2.jpg" alt="" width="223" data-align="center">

<img title="" src="https://pan.losfer.cn/view.php/d46b2866c9c52f02cf8e29d23629f41f.jpg" alt="" width="227" data-align="center">

# About

### Hi there 👋,I'm Evan.

- 🔭 I’m currently working on something cool.

- 🌱 I’m currently learning Everything I like.

- 💬 Ask me about anything related to Java/Python.

- 📫 How to reach me: uyevan@163.com

- 😄 Read more about my Blog: [GoTo](https://jfkj.xyz)


